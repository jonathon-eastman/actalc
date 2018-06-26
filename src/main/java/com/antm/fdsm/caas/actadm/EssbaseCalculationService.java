package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticExportFile;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseCalculationService {
	
	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube calcCube;
	
	public EssbaseCalculationService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		calcCube = server.getApplication(service, ServiceDefs.CALC_NAME).getCube(ServiceDefs.CALC_NAME);
	}
	
	public EssbaseCalculationService clearAllData() {
		calcCube.clear();
		return this;
	}
	public AnalyticExportFile exportCube( final String exportType) throws Exception {
		return calcCube.export(f -> f.fileName(ServiceDefs.CUBE_NAME + "_" + exportType + ".txt"));
	}
	
	public EssbaseCalculationService loadCurrentPeriod() {
		calcCube.loadFilesInDirectory(service.getHome() + "/" + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL);
		calcCube.loadFilesInCloudDirectory(service.getHome() + "/" + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
}
