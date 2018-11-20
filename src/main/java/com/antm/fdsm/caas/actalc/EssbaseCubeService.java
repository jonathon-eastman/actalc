package com.antm.fdsm.caas.actalc;

import java.util.concurrent.ExecutionException;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.utils.Singleton;
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
		String mdx = 	"SELECT CROSSJOIN({[From Center Total]},CROSSJOIN({[Fixed Pool Total]},CROSSJOIN({[MBU Total]},CROSSJOIN({[Product Total]},CROSSJOIN({[Funding Type Total]},CROSSJOIN({[Anthem, Inc. (Cons)], [GDDDD]},CROSSJOIN({[Admin Exp Alloc]},{[Actual]}))))))) ON AXIS(0),\n" +
						"{ [" + Helpers.convertMonthNumber(Def.CP) + "]} ON AXIS(1)\n" +
						"FROM " + Def.CUBE_NAME + "." + Def.CUBE_NAME;
		//essbase
		JsonObject essbaseResults = cube.runMdx(mdx).get();
		Logger.info("Got essbase results as json [{}].", essbaseResults);
		double allocatedAdmin = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(25));
		double unallocatedAdmin = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(26));
		final Actadm2CubeService actadm2 = new Actadm2CubeService(service);
		double actadm2Admin = actadm2.getTotalUnallocatedAdmin();
		//variances
		double varActalc  = allocatedAdmin - unallocatedAdmin;
		double varActadm2  = allocatedAdmin - actadm2Admin;
		double varActadm2Unallocated  = unallocatedAdmin - actadm2Admin;
		String nfUnalloc = Helpers.loggerNumberFormat(unallocatedAdmin);
		String nfAlloc = Helpers.loggerNumberFormat(allocatedAdmin);
		String nfActadm2 = Helpers.loggerNumberFormat(actadm2Admin);
		String nfVarActalc = Helpers.loggerNumberFormat(varActalc);
		String nfVarActadm2 = Helpers.loggerNumberFormat(varActadm2);
		String nfVarActadm2Unallocated = Helpers.loggerNumberFormat(varActadm2Unallocated);

		Logger.info("\nactalc allocated admin[{"+ nfAlloc +"}]\ngl actalc unallocated admin[{" + nfUnalloc +"}]\n------------------------------------------------------\nvariance[{" + nfVarActalc + "}]\n", allocatedAdmin, unallocatedAdmin, varActalc);
		Logger.info("\nactalc allocated admin[{"+ nfAlloc +"}]\ngl actadm2 unallocated admin[{" + nfActadm2 +"}]\n------------------------------------------------------\nvariance[{" + nfVarActadm2 + "}]\n", allocatedAdmin, actadm2Admin, varActadm2);
		Logger.info("\nactalc unallocated admin[{"+ nfUnalloc +"}]\ngl actadm2 unallocated admin[{" + nfActadm2 +"}]\n------------------------------------------------------\nvariance[{" + nfVarActadm2Unallocated + "}]\n", unallocatedAdmin, actadm2Admin, varActadm2Unallocated);
		if ( (Math.abs(varActalc) + Math.abs(varActadm2) + Math.abs(varActadm2Unallocated) > Def.VARIANCE_TOLERANCE) ){
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
