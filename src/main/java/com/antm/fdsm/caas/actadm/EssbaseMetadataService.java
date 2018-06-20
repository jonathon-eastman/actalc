package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;

public class EssbaseMetadataService {

	private EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
	private EssbaseCube metaBso01Cube = server.getApplication(ServiceDefs.META_NAME_BSO_01).getCube(ServiceDefs.META_NAME_BSO_01);
	private EssbaseCube metaAso01Cube = server.getApplication(ServiceDefs.META_NAME_ASO_01).getCube(ServiceDefs.META_NAME_ASO_01);
	
	public EssbaseMetadataService createCalculatingCube() {
		EssbaseApplication calcBsoApp = server.getApplication(ServiceDefs.CALC_NAME_BSO_01);
		if (calcBsoApp.exists()) {
			calcBsoApp.delete();
		}
		metaBso01Cube.copyToNewApplication(ServiceDefs.CALC_NAME_BSO_01).getCube(ServiceDefs.META_NAME_BSO_01).rename(ServiceDefs.CALC_NAME_BSO_01);
		return this;
	}
	
	public EssbaseReportingService createReportingCube() {
		EssbaseApplication rptgAsoApp = server.getApplication(ServiceDefs.RPTG_NAME_ASO_01);
		if (rptgAsoApp.exists()) {
			rptgAsoApp.delete();
		}
		metaAso01Cube.copyToNewApplication(ServiceDefs.RPTG_NAME_ASO_01).getCube(ServiceDefs.META_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_ASO_01);
		EssbaseReportingService rptgService = new EssbaseReportingService();
		return rptgService;
	}
}
