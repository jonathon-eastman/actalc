package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseCubeService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseApplication app;
	private EssbaseCube cube;

	public EssbaseCubeService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		app = server.getApplication(service, Def.CUBE_NAME);
		cube = app.getCube(Def.CUBE_NAME);
	}

	public EssbaseCubeService loadIncrementalSlice() {
		cube.createBuffer(1000, 0.99)
			.load2Buffer((loadFile, ruleFile) -> {
				loadFile.localPath(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt");
				ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt").applyBufferNumber(1000);
			})
			.addBufferAsSlice(1000);
		return this;
	}
}
