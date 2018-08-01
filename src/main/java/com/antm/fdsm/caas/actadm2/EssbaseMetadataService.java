package com.antm.fdsm.caas.actadm2;

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
		metaBsoCube = server.getApplication(service, Def.META_NAME_BSO).getCube(Def.META_NAME_BSO);
		metaAsoCube = server.getApplication(service, Def.META_NAME_ASO).getCube(Def.META_NAME_ASO);
	}

	public EssbaseMetadataService createCalculatingCube() {
		EssbaseApplication calcBsoApp = server.getApplication(service, Def.CALC_NAME);
		if (calcBsoApp.exists()) {
			calcBsoApp.delete();
		}
		metaBsoCube.copyToNewApplication(Def.CALC_NAME).getCube(Def.META_NAME_BSO).rename(Def.CALC_NAME);
		return this;
	}

	public EssbaseReportingService createReportingCube() {
		EssbaseApplication rptgApp = server.getApplication(service, Def.RPTG_NAME);
		if (rptgApp.exists()) {
			rptgApp.delete();
		}
		metaAsoCube.copyToNewApplication(Def.RPTG_NAME).getCube(Def.META_NAME_ASO).rename(Def.RPTG_NAME);
		EssbaseReportingService rptgService = new EssbaseReportingService(service);
		return rptgService;
	}
}
