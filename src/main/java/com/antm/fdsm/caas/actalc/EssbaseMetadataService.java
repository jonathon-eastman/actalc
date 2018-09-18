package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

	public CompletableFuture<Void> createCalculatingCube() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try {
				EssbaseApplication calcBsoApp = server.getApplication(service, Def.CALC_NAME);
				if (calcBsoApp.exists()) {
					calcBsoApp.delete().get();
				}
				metaBsoCube.copyToNewApplication(Def.CALC_NAME).getCube(Def.META_NAME_BSO).rename(Def.CALC_NAME).get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		return cf;
	}

	public CompletableFuture<Void> createReportingCube() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			EssbaseApplication rptgApp = server.getApplication(service, Def.RPTG_NAME);
			try {
				if (rptgApp.exists()) {
					rptgApp.delete().get();
				}
				metaAsoCube.copyToNewApplication(Def.RPTG_NAME).getCube(Def.META_NAME_ASO).rename(Def.RPTG_NAME).get();
			}
			catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//EssbaseReportingService rptgService = new EssbaseReportingService(service);
			return null;
		});
		return cf;
	}
}
