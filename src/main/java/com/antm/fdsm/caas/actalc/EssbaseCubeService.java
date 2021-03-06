package com.antm.fdsm.caas.actalc;

import java.util.concurrent.ExecutionException;
import org.tinylog.Logger;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.oac.services.EssbaseService;
import com.antm.fdsm.orcl.odc.services.OracleRelationalService;
import io.vertx.core.json.JsonObject;
import com.antm.fdsm.orcl.utils.GlobalCom;

public class EssbaseCubeService {

	private EssbaseService essbase;
	private EssbaseServer server;
	private EssbaseApplication app;
	private EssbaseCube cube;

	public EssbaseCubeService(EssbaseService essbaseService) {
		essbase = essbaseService;
		server = new EssbaseServer(essbase);
		app = server.getApplication(essbase, Def.CUBE_NAME);
		cube = app.getCube(Def.CUBE_NAME);
	}

	public EssbaseCubeService associate(OracleRelationalService relational) throws InterruptedException, ExecutionException {
		DatabaseService oracle = new DatabaseService(relational);
		app.associateApplicationPermissions(oracle);
		cube.associateFilterPermissions(oracle).get();
		return this;
	}

	public EssbaseCubeService balance() throws InterruptedException, ExecutionException {
		String mdx = 	"SELECT CROSSJOIN({[From Center Total]},CROSSJOIN({[Fixed Pool Total]},CROSSJOIN({[MBU Total]},CROSSJOIN({[Product Total]},CROSSJOIN({[Funding Type Total]},CROSSJOIN({[Anthem, Inc. (Cons)], [GDDDD]},CROSSJOIN({[Admin Exp Alloc]},{[Actual]}))))))) ON AXIS(0),\n" +
						"{ [" + Helpers.convertMonthNumber(Def.CP) + "]} ON AXIS(1)\n" +
						"FROM " + Def.CUBE_NAME + "." + Def.CUBE_NAME;
		//essbase
		JsonObject essbaseResults = cube.runMdxGrid(mdx).get();
		Logger.info("Got essbase results as json [{}].", essbaseResults);
		double allocatedAdmin = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(25));
		double unallocatedAdmin = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(26));
		final Actadm2CubeService actadm2 = new Actadm2CubeService(essbase);
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
		}
		else {
			Logger.info(Def.CUBE_NAME + " balances to the PeopleSoft gl ACTUALS ledger");
		}

		return this;
	}

	
	public EssbaseCubeService loadIncrementalSlice() throws InterruptedException, ExecutionException {
		int BUFFER_NUMBER_4SLICE = 1000;
		cube.createBuffer(BUFFER_NUMBER_4SLICE, 20).get();
		cube.load2Buffer((loadFile, ruleFile) -> {
			loadFile.localPath(Def.ESSBASE_INCREMENTAL + "/" + Def.PROJECT_NAME + ".txt");
			ruleFile.aiSourceFile(Def.ESSBASE_INCREMENTAL + "/" + Def.PROJECT_NAME + ".txt").applyBufferNumber(1000);
		}, BUFFER_NUMBER_4SLICE).get();
		cube.slice(1000).get();
		return this;
	}	
	
}
