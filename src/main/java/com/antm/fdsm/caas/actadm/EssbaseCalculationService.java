package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;

public class EssbaseCalculationService {
	
	private EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
	private EssbaseCube calcBso01Cube = server.getApplication(ServiceDefs.CALC_NAME_BSO_01).getCube(ServiceDefs.CALC_NAME_BSO_01);
	
	public EssbaseCalculationService exportCube( final String exportType) throws Exception {
		calcBso01Cube.export(f -> f.fileName(ServiceDefs.RPTG_NAME_PRIMARY + "_" + exportType + ".txt"));
		return this;
	}
	
	public EssbaseCalculationService loadCurrentPeriod() {
		calcBso01Cube.loadFilesInDirectory(ServiceDefs.DIRECTORY_HOME + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL);
		calcBso01Cube.loadFilesInDirectory(ServiceDefs.DIRECTORY_HOME + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
}
