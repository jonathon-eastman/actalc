package com.antm.fdsm.caas.actalc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import com.antm.fdsm.orcl.oac.AnalyticExportFile;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.services.EssbaseAnalyticsService;
import com.antm.fdsm.orcl.utils.GlobalOptions;
import com.antm.fdsm.orcl.utils.Helpers;


public class EssbaseReportingService {

	private EssbaseAnalyticsService service;
	private EssbaseServer server;
	private EssbaseApplication rptgApp;
	private EssbaseCube rptgCube;

	public EssbaseReportingService(EssbaseAnalyticsService oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		rptgApp = server.getApplication(service, Def.RPTG_NAME);
		rptgCube = rptgApp.getCube(Def.RPTG_NAME);
	}

	public EssbaseReportingService agg() throws InterruptedException, ExecutionException {
		rptgCube.aggregate().get();
		return this;
	}

	public EssbaseReportingService clearAllData() throws InterruptedException, ExecutionException {
		rptgCube.clear().get();
		return this ;
	};
	
	public EssbaseReportingService loadAlloc() throws InterruptedException, ExecutionException {
		List<String> alternateStructures = Arrays.asList("Alloc_0", "Alloc_1", "Alloc_2", "Alloc_3", "Alloc_4", "Alloc_5");
		alternateStructures.stream().forEach( structure -> loadDivAllocFile(rptgCube, GlobalOptions.HOME,structure));
		return this;
	}
	
	public CompletableFuture<EssbaseReportingService> loadCurrentPeriodHistory()  {
		CompletableFuture<EssbaseReportingService> cf = CompletableFuture.supplyAsync(() -> {
			try {
				rptgCube.load((loadFile, ruleFile) -> {
					loadFile.localPath(Def.CPHISTORY + "/h_" + Def.PROJECT_NAME + "_ar_" + Def.YR2D + ".txt");
					ruleFile.aiSourceFile(Def.CPHISTORY + "/h_" + Def.PROJECT_NAME + "_ar_" + Def.YR2D + ".txt")
					.ignoreFileColumn("BegBalance");
				}).get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		});
		return cf;
	}

	private static void loadDivAllocFile(EssbaseCube cube, String strHome, String strDiv ) {
		try {
			cube.load((loadFile, ruleFile) -> {
				loadFile.localPath(Def.EXPORT + "/required/" + Def.PROJECT_NAME + "_" + strDiv.toLowerCase() + ".txt");
				ruleFile.aiSourceFile(Def.EXPORT + "/required/" + Def.PROJECT_NAME + "_" + strDiv.toLowerCase() + ".txt")
				.addVirtualColumn("Scenarios", "Actual")
				.ignoreFileColumn("BegBalance");
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EssbaseCubeService move2Production() throws InterruptedException, ExecutionException {
		rptgApp.ifAppExistsThenDelete(Def.CUBE_NAME).get();

		rptgApp.rename(Def.CUBE_NAME).get();

		EssbaseCube cube = server.getApplication(service, Def.CUBE_NAME).getCube(Def.RPTG_NAME);

		cube.rename(Def.CUBE_NAME).get();

		EssbaseCubeService cubeService = new EssbaseCubeService(service);
		return cubeService;
	}

	public void updateTime() {

	}

	public EssbaseReportingService exportActallc4Regalc() throws Exception {
		String fix = "FIX ( Jan:Dec, @RELATIVE(\"Company\",0),@REMOVE(@RELATIVE(\"Accounts\", 0), \"Admin Exp Alloc\" ))";
		AnalyticExportFile export = rptgCube.export(f -> f.fileName("par_actallc_4regalc.txt")
				.addFixStatement(fix))
				.get();
		export.bringLocally(
				Def.EXPORT+ "/required/" + "par_actallc_4regalc.txt",
				Def.EXPORT+ "/new/" + "par_actallc_4regalc.txt"
		).pipeify().copy2Backup(Def.BKP);
		return this;	
	}
	
	
}
