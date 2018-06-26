package com.antm.fdsm.caas.actadm;


import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseReportingService {
	
	private Singleton service;
	private EssbaseServer server;
	private EssbaseApplication rptgAso01App;
	private EssbaseCube rptgAso01Cube;
	
	public EssbaseReportingService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		rptgAso01App = server.getApplication(service, ServiceDefs.RPTG_NAME_ASO_01);
		rptgAso01Cube = rptgAso01App.getCube(ServiceDefs.RPTG_NAME_ASO_01);
	}
	public EssbaseReportingService clearAllData() {
		rptgAso01Cube.clear();
		return this;
	}
	
	public EssbaseReportingService loadHistory() {
		rptgAso01Cube.loadFilesInCloudDirectory(service.getHome() + "/" + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
	
	public EssbaseReportingService loadCurrentPeriod() {
		rptgAso01Cube.loadFilesInDirectory(service.getHome()  + "/" + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL);
		//CREATE FUNCTION TO DOWNLOAD FROM CLOUD HISTORY FILES.
		//rptgAso01Cube.loadFilesInCloudDirectory(config.getHome() + "/" +ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
	
	public void loadCurrentPeriodWithPartialClear() {
		
	}
	
	public EssbaseReportingService moveToProduction1() {
		rptgAso01App.rename(ServiceDefs.RPTG_NAME_PRIMARY).getCube(ServiceDefs.RPTG_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_PRIMARY);
		return this;
	}
	
	public EssbaseReportingService moveToProduction2() {
		rptgAso01App.rename(ServiceDefs.RPTG_NAME_SECONDARY).getCube(ServiceDefs.RPTG_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_SECONDARY);
		return this;
	}
	
	public void updateTime() {
		
	}
}
