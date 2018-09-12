package com.antm.fdsm.caas.actadm2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.LoadRule;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseCalculationService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube calcCube;

	public EssbaseCalculationService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		calcCube = server.getApplication(service, Def.CALC_NAME).getCube(Def.CALC_NAME);
	}

	public EssbaseCalculationService clearAllData() {
		calcCube.clear();
		return this;
	}

	public EssbaseCalculationService exportCube() throws Exception {
		calcCube.export(f -> f.fileName(Def.DIR_PROJECT + ".txt")).get()
			.bringLocally(
				service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt",
				service.getHome() + "/" + Def.DIR_NEW + "/" + Def.DIR_PROJECT + ".txt"
			).pipeify().copy2Backup(service.getHome() + "/" + Def.DIR_BKP);
		return this;
	}
	
	public EssbaseCalculationService exportIncremental() throws Exception {
		calcCube.export(f -> f.fileName(Def.DIR_PROJECT + ".txt")).get()
			.bringLocally(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt")
			.pipeify()
			.removeZeros();
		return this;
	}

	public CompletableFuture<EssbaseCalculationService> loadCurrentPeriod() {
		CompletableFuture<EssbaseCalculationService> cf = CompletableFuture.supplyAsync(() -> {
			Logger.info("loading current period.");
			try {
				calcCube.loadFilesInDirectory(service.getHome() + "/" + Def.DIR_RELATIONAL).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Helpers.moveFilesInLocalDirectory(service.getHome() + "/" + Def.DIR_RELATIONAL, service.getHome() + "/" + Def.DIR_LAST, service.getFs());
			return this;
		});
		return cf;
	}
	
	public CompletableFuture<EssbaseCalculationService> loadCurrentPeriodHistory()  {
		CompletableFuture<EssbaseCalculationService> cf = CompletableFuture.supplyAsync(() -> {
			Logger.info("loading current period.");
			try {
				calcCube.loadFilesInDirectory(service.getHome() + "/" + Def.DIR_CPHISTORY).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		});
		return cf;
	}

	public EssbaseCalculationService loadPreviousExport() {
		Logger.info("loading previous period.");
		calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt").isFileLocal(true);
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt")
				.setValuesOperator(LoadRule.ValuesOperator.SUBTRACT);
		});
		return this;
	}

	public EssbaseCalculationService moveNewExport2Previous() {
		Helpers.moveLocalFile(
			service.getHome() + "/" + Def.DIR_NEW + "/" + Def.DIR_PROJECT + ".txt", 
			service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt", 
			service.getFs()
		);
		return this;
	}

}
