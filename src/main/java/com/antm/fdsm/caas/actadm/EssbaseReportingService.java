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
		rptgApp = server.getApplication(service, ServiceDefs.RPTG_NAME);
		rptgCube = rptgApp.getCube(ServiceDefs.RPTG_NAME);
	}
	public EssbaseReportingService clearAllData() {
		rptgCube.clear();
		return this;
	}
	
	public EssbaseReportingService loadHistory() {
		rptgCube.loadFilesInCloudDirectory(service.getHome() + "/" + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
	
	public EssbaseReportingService loadCurrentPeriod() {
		rptgCube.loadFilesInDirectory(service.getHome()  + "/" + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL);
		//CREATE FUNCTION TO DOWNLOAD FROM CLOUD HISTORY FILES.
		//rptgCube.loadFilesInCloudDirectory(config.getHome() + "/" +ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
	
	public void loadCurrentPeriodWithPartialClear() {
		
	}
	
	public EssbaseReportingService moveToProduction1() {
		rptgApp.rename(ServiceDefs.CUBE_NAME).getCube(ServiceDefs.RPTG_NAME).rename(ServiceDefs.CUBE_NAME);
		return this;
	}
	
	public EssbaseReportingService moveToProduction2() {
		rptgApp.rename(ServiceDefs.CUBE_NAME + "2").getCube(ServiceDefs.RPTG_NAME).rename(ServiceDefs.CUBE_NAME +"2");
		return this;
	}
	
	public void updateTime() {
		
	}
}
