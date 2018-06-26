package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticExportFile;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseCalculationService {
	
	private Singleton config;
	private EssbaseServer server = new EssbaseServer(config, "fdsm-dev-oac01.anthem.com");
	private EssbaseCube calcBso01Cube = server.getApplication(config, ServiceDefs.CALC_NAME_BSO_01).getCube(ServiceDefs.CALC_NAME_BSO_01);
	
	public EssbaseCalculationService(Singleton s) {
		config = s;
	}
	
	public EssbaseCalculationService clearAllData() {
		calcBso01Cube.clear();
		return this;
	}
	public AnalyticExportFile exportCube( final String exportType) throws Exception {
		return calcBso01Cube.export(f -> f.fileName(ServiceDefs.RPTG_NAME_PRIMARY + "_" + exportType + ".txt"));
	}
	
	public EssbaseCalculationService loadCurrentPeriod() {
		calcBso01Cube.loadFilesInDirectory(config.getHome() + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL);
		calcBso01Cube.loadFilesInCloudDirectory(config.getHome() + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
}
