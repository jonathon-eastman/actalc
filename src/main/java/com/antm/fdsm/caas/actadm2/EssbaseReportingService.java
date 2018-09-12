package com.antm.fdsm.caas.actadm2;

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

	public EssbaseReportingService agg() {
		rptgCube.aggregate();
		return this;
	}
	
	public EssbaseReportingService clearAllData() {
		rptgCube.clear();
		return this ;
	};

	public EssbaseReportingService loadData() throws InterruptedException, ExecutionException {
		rptgCube.createBuffer(1000, .1);
		CompletableFuture<Void> curentPeriodLoad = rptgCube.loadFilesInDirectory(service.getHome()  + "/"+ Def.DIR_NEW);
		CompletableFuture<Void> historyLoad = rptgCube.loadFilesInDirectory(service.getHome() + "/" + Def.DIR_HISTORY);
		curentPeriodLoad.get();
		historyLoad.get();
		rptgCube.commitBuffer(1000);
		return this;
	}

	public void loadCurrentPeriodWithPartialClear() {
		
	}
	
	public EssbaseCubeService move2Production() throws InterruptedException, ExecutionException {
		rptgApp.ifAppExistsThenDelete(Def.CUBE_NAME);
			
		rptgApp.rename(Def.CUBE_NAME).get()
			.getCube(Def.CUBE_NAME)
			.rename(Def.CUBE_NAME).get();
		
		EssbaseCubeService cubeService = new EssbaseCubeService(service);
		return cubeService;
	}

	public void updateTime() {

	}
	
}
