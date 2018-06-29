package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.LoadRule;
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
		calcCube.export(f -> f.fileName(Def.DIR_PROJECT + ".txt"))
			.bringLocally(
				service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt",
				service.getHome() + "/" + Def.DIR_NEW + "/" + Def.DIR_PROJECT + ".txt"
			).pipeify();
		return this;
	}
	
	public EssbaseCalculationService exportIncremental() throws Exception {
		calcCube.export(f -> f.fileName(Def.DIR_PROJECT + ".txt"))
			.bringLocally(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt")
			.pipeify();
		return this;
	}

	public EssbaseCalculationService loadCurrentPeriod() {
		calcCube.loadFilesInDirectory(service.getHome() + "/" + Def.DIR_RELATIONAL);
		calcCube.loadFilesInCloudDirectory(service.getHome() + "/" + Def.DIR_HISTORY);
		return this;
	}

	public EssbaseCalculationService loadPreviousExport() {
		calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt").isFileLocal(true);
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt")
				.setValuesOperator(LoadRule.ValuesOperator.SUBTRACT);
		});
		return this;
	}

}
