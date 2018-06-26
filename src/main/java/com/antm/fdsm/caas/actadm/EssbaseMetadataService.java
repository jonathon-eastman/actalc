package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseMetadataService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube metaBsoCube;
	private EssbaseCube metaAsoCube;

	public EssbaseMetadataService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		metaBsoCube = server.getApplication(service, ServiceDefs.META_NAME_BSO).getCube(ServiceDefs.META_NAME_BSO);
		metaAsoCube = server.getApplication(service, ServiceDefs.META_NAME_ASO).getCube(ServiceDefs.META_NAME_ASO);
	}

	public EssbaseMetadataService createCalculatingCube() {
		EssbaseApplication calcBsoApp = server.getApplication(service, ServiceDefs.CALC_NAME);
		if (calcBsoApp.exists()) {
			calcBsoApp.delete();
		}
		metaBsoCube.copyToNewApplication(ServiceDefs.CALC_NAME).getCube(ServiceDefs.META_NAME_BSO).rename(ServiceDefs.CALC_NAME);
		return this;
	}

	public EssbaseReportingService createReportingCube() {
		EssbaseApplication rptgApp = server.getApplication(service, ServiceDefs.RPTG_NAME);
		if (rptgApp.exists()) {
			rptgApp.delete();
		}
		metaAsoCube.copyToNewApplication(ServiceDefs.RPTG_NAME).getCube(ServiceDefs.META_NAME_ASO).rename(ServiceDefs.RPTG_NAME);
		EssbaseReportingService rptgService = new EssbaseReportingService(service);
		return rptgService;
	}
}
