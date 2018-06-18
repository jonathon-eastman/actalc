package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;

public class MetaAsoCubeService {

	private EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
	private EssbaseCube metaAsoCube = server.getApplication(ServiceDefs.META_NAME_ASO_01).getCube(ServiceDefs.META_NAME_ASO_01);
	
	public RptgAsoCubeService prepareReportingCube() {
		EssbaseApplication rptgAsoApp = server.getApplication(ServiceDefs.RPTG_NAME_ASO_01);
		if (rptgAsoApp.exists()) {
			rptgAsoApp.delete();
		}
		metaAsoCube.copyToNewApplication(ServiceDefs.RPTG_NAME_ASO_01).getCube(ServiceDefs.META_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_ASO_01);
		RptgAsoCubeService cube = new RptgAsoCubeService();
		return cube;
	}
}
