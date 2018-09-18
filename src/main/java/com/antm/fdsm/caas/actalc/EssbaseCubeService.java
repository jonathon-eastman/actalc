package com.antm.fdsm.caas.actalc;

import java.util.concurrent.ExecutionException;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.utils.Singleton;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class EssbaseCubeService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseApplication app;
	private EssbaseCube cube;

	public EssbaseCubeService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		app = server.getApplication(service, Def.CUBE_NAME);
		cube = app.getCube(Def.CUBE_NAME);
	}

	public EssbaseCubeService associate(Singleton dbService) throws InterruptedException, ExecutionException {
		DatabaseService hypusr = new DatabaseService(dbService);
		app.associateApplicationPermissions(hypusr);
		cube.associateFilterPermissions(hypusr).get();
		return this;
	}

	public EssbaseCubeService balance() throws InterruptedException, ExecutionException {
		String mdx = 	"SELECT CROSSJOIN({[Project Total]},CROSSJOIN({[Anthem, Inc. (Cons)]},CROSSJOIN({[Administrative Expenses for Cost Allocations],[Headcount],[FTE],[Hours]},{[Actual]}))) ON AXIS(0),\n" +
						"{ [" + Helpers.convertMonthNumber(Def.CP) + "]} ON AXIS(1)\n" +
						"FROM " + Def.CUBE_NAME + "." + Def.CUBE_NAME;
		//essbase
		JsonObject essbaseResults = cube.runMdx(mdx).get();
		Logger.info("Got essbase results as json [{}].", essbaseResults);
		double admEssbase = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(21));
		double hctEssbase = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(22));
		double fteEssbase = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(23));
		double hrsEssbase = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(24));

		//gl adm
		double admGl = 0.00;
		if ( Helpers.fileExists(service.getHome() + "/" + Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json", service.getFs())) {
			JsonArray glResultsAdm = Helpers.readJsonArrayFile(service.getHome() + "/" + Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json", service.getFs());
			System.out.println("TEST: " + glResultsAdm.encodePrettily());
			admGl = Helpers.ifNumberGetDoubleElseZero(glResultsAdm.getString(1));
		}

		//gl hc
		double hctGl = 0.00;
		if ( Helpers.fileExists(service.getHome() + "/" + Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json", service.getFs())) {
			JsonArray glResultsHct = Helpers.readJsonArrayFile(service.getHome() + "/" + Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json", service.getFs());
			hctGl = Helpers.ifNumberGetDoubleElseZero(glResultsHct.getString(1));
		}

		//gl fte
		double fteGl = 0.00;
		if ( Helpers.fileExists(service.getHome() + "/" + Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json", service.getFs())) {
			JsonArray glResultsFte = Helpers.readJsonArrayFile(service.getHome() + "/" + Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json", service.getFs());
			fteGl = Helpers.ifNumberGetDoubleElseZero(glResultsFte.getString(1));
		}

		//gl hrs
		double hrsGl = 0.00;
		if ( Helpers.fileExists(service.getHome() + "/" + Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json", service.getFs())) {
			JsonArray glResultsHrs = Helpers.readJsonArrayFile(service.getHome() + "/" + Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json", service.getFs());
			hrsGl = Helpers.ifNumberGetDoubleElseZero(glResultsHrs.getString(1));
		}

		//variances
		double varAdm  = admEssbase - admGl;
		double varHct  = hctEssbase - hctGl;
		double varFte  = fteEssbase - fteGl;
		double varHrs  = hrsEssbase - hrsGl;

		Logger.info("\nessbase administrative expenses[{}]\ngl administrative expenses[{}]\n------------------------------------------------------\nvariance[{}]\n", admEssbase, admGl, varAdm);
		Logger.info("\nessbase headcount[{}]\ngl headcount[{}]\n------------------------------------------------------\nvariance[{}]\n", hctEssbase, hctGl, varHct);
		Logger.info("\nessbase fte[{}]\ngl fte[{}]\n------------------------------------------------------\nvariance[{}]\n", fteEssbase, fteGl, varFte);
		Logger.info("\nessbase hours[{}]\ngl hours[{}]\n------------------------------------------------------\nvariance[{}]\n", hrsEssbase, hrsGl, varHrs);
		if ( (Math.abs(varAdm) + Math.abs(varHct) + Math.abs(varFte) + Math.abs(varHrs) > Def.VARIANCE_TOLERANCE) ){
			Logger.info("an imbalance between " + Def.CUBE_NAME + " and the PeopleSoft gl ACTUALS ledger exists.");
			Singleton.slackErrorDev(Def.SLACK_WEBHOOK_APP, ":sob: an imbalance between " + Def.CUBE_NAME + " and the PeopleSoft gl ACTUALS ledger exists.");
		}
		else {
			Logger.info(Def.CUBE_NAME + " balances to the PeopleSoft gl ACTUALS ledger");
			service.slackBalance(Def.SLACK_WEBHOOK_APP, ":stuck_out_tongue_winking_eye: " + Def.CUBE_NAME + " balances to the PeopleSoft gl ACTUALS ledger");
		}

		return this;
	}

	public EssbaseCubeService loadIncrementalSlice() throws InterruptedException, ExecutionException {
		cube.createBuffer(1000, 0.99).get();
		cube.load2Buffer((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt");
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt").applyBufferNumber(1000);
		}).get();
		cube.addBufferAsSlice(1000).get();
		return this;
	}

}
