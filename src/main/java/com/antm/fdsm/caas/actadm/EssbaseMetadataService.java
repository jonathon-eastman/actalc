package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseMetadataService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube metaBso01Cube;
	private EssbaseCube metaAso01Cube;

	public EssbaseMetadataService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		metaBso01Cube = server.getApplication(service, ServiceDefs.META_NAME_BSO_01).getCube(ServiceDefs.META_NAME_BSO_01);
		metaAso01Cube = server.getApplication(service, ServiceDefs.META_NAME_ASO_01).getCube(ServiceDefs.META_NAME_ASO_01);
	}

	public EssbaseMetadataService createCalculatingCube() {
		EssbaseApplication calcBsoApp = server.getApplication(service, ServiceDefs.CALC_NAME_BSO_01);
		if (calcBsoApp.exists()) {
			calcBsoApp.delete();
		}
		metaBso01Cube.copyToNewApplication(ServiceDefs.CALC_NAME_BSO_01).getCube(ServiceDefs.META_NAME_BSO_01).rename(ServiceDefs.CALC_NAME_BSO_01);
		return this;
	}

	public EssbaseReportingService createReportingCube() {
		EssbaseApplication rptgAsoApp = server.getApplication(service, ServiceDefs.RPTG_NAME_ASO_01);
		if (rptgAsoApp.exists()) {
			rptgAsoApp.delete();
		}
		metaAso01Cube.copyToNewApplication(ServiceDefs.RPTG_NAME_ASO_01).getCube(ServiceDefs.META_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_ASO_01);
		EssbaseReportingService rptgService = new EssbaseReportingService(service);
		return rptgService;
	}
}
