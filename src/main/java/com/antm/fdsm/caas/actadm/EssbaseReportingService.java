package com.antm.fdsm.caas.actadm;

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
		return this;
	}

	public EssbaseReportingService loadCurrentPeriod() {
		rptgCube.loadFilesInDirectory(service.getHome()  + "/"+ Def.DIR_NEW);
		//CREATE FUNCTION TO DOWNLOAD FROM CLOUD HISTORY FILES.
		//rptgCube.loadFilesInCloudDirectory(config.getHome() + "/" +ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}

	public EssbaseReportingService loadHistory() {
		rptgCube.loadFilesInCloudDirectory(service.getHome() + "/" + Def.DIR_HISTORY);
		return this;
	}

	public void loadCurrentPeriodWithPartialClear() {
		
	}
	
	public EssbaseReportingService move2Production() {
		rptgApp.ifAppExistsThenDelete(Def.CUBE_NAME)
			.rename(Def.CUBE_NAME)
			.getCube(Def.RPTG_NAME)
			.rename(Def.CUBE_NAME);
		return this;
	}
	
	public EssbaseReportingService move2Production2() {
		rptgApp.ifAppExistsThenDelete(Def.CUBE_NAME + "2")
			.rename(Def.CUBE_NAME + "2")
			.getCube(Def.RPTG_NAME)
			.rename(Def.CUBE_NAME +"2");
		return this;
	}

	public void updateTime() {

	}
}
