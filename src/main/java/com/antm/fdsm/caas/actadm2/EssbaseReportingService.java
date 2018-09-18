package com.antm.fdsm.caas.actadm2;

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

	public EssbaseReportingService loadData() throws InterruptedException, ExecutionException {
		//int bufferNumber = 1000;
		//rptgCube.createBuffer(bufferNumber, 0.1).get();
		/*CompletableFuture<Void> curentPeriodLoad = */rptgCube.loadFilesInDirectory(service.getHome()  + "/"+ Def.DIR_NEW/*, bufferNumber*/);
		/*CompletableFuture<Void> historyLoad = */rptgCube.loadFilesInDirectory(service.getHome() + "/" + Def.DIR_HISTORY/*, bufferNumber*/);
		//curentPeriodLoad.get();
		//historyLoad.get();
		//rptgCube.commitBuffer(bufferNumber).get();
		return this;
	}

	public void loadCurrentPeriodWithPartialClear() {
		
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
