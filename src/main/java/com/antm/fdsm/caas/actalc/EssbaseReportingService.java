package com.antm.fdsm.caas.actalc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseReportingService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseApplication rptgApp;
	private EssbaseCube rptgCube;

	public EssbaseReportingService(Singleton oacServiceSingleton) {
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
		alternateStructures.stream().forEach( structure -> loadDivAllocFile(rptgCube, service.getHome(),structure));
		return this;
	}
	
	public CompletableFuture<EssbaseReportingService> loadCurrentPeriodHistory()  {
		CompletableFuture<EssbaseReportingService> cf = CompletableFuture.supplyAsync(() -> {
			try {
				rptgCube.load((loadFile, ruleFile) -> {
					loadFile.localPath(service.getHome() + "/" + Def.DIR_CPHISTORY + "/h_" + Def.DIR_PROJECT + "_ar_" + Def.YR2D + ".txt");
					ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_CPHISTORY + "/h_" + Def.DIR_PROJECT + "_ar_" + Def.YR2D + ".txt")
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
				loadFile.localPath(strHome + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_" + strDiv.toLowerCase() + ".txt");
				ruleFile.aiSourceFile(strHome + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_" + strDiv.toLowerCase() + ".txt")
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

}
