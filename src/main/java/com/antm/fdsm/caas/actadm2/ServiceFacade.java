package com.antm.fdsm.caas.actadm2;

import java.util.concurrent.CompletableFuture;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.utils.Singleton;

public class ServiceFacade {

	public static void archive(Singleton oacService, Singleton dbService) {
		//EssbaseCubeService svc = new EssbaseCubeService(oacService).associate(dbService);
	}

	public static void base(Singleton oacService, Singleton dbService) throws Exception {
		oacService.slackInfo(Def.SLACK_WEBHOOK_APP, ":rocket: starting " + Def.CUBE_NAME + " update[base].");
		RelationalDatabaseService relationalService = new RelationalDatabaseService(dbService);

		final EssbaseMetadataService metaService = new EssbaseMetadataService(oacService);
		CompletableFuture<Void> createRptg =  metaService.createReportingCube();
		CompletableFuture<Void> createCalc =  metaService.createCalculatingCube();
		CompletableFuture<Void> extract = relationalService.extractPSGLCurrentMonth();

		
		extract.get();
		createCalc.get();
		
		Logger.info("calc cube creation completed.");
		EssbaseCalculationService calcService = new EssbaseCalculationService(oacService);
		
		calcService.clearAllData()
			.loadCurrentPeriod()
			.moveNewExport2Previous()
			.exportCube();
		
		/*createRptg.get();
		EssbaseReportingService rptgService = new EssbaseReportingService(oacService);
		rptgService
			.clearAllData()
			.loadHistory()
			.loadCurrentPeriod()
			.agg()
			.move2Production()
			.balance()
			.associate(dbService);*/
  
		oacService.slackInfo(Def.SLACK_WEBHOOK_APP, ":checkered_flag: finished " + Def.CUBE_NAME + " update[base].");
	}

	public static void incremental(Singleton oacService, Singleton dbService) throws Exception {
		oacService.slackInfo(Def.SLACK_WEBHOOK_APP, ":rocket: starting " + Def.CUBE_NAME + " update[incremental].");
		RelationalDatabaseService relationalService = new RelationalDatabaseService(dbService);
		relationalService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(oacService);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.loadPreviousExport()
			.exportIncremental()
			.moveNewExport2Previous();

		EssbaseCubeService cubeService = new EssbaseCubeService(oacService);
		cubeService.loadIncrementalSlice().balance();

		//update time here.
		oacService.slackInfo(Def.SLACK_WEBHOOK_APP, ":checkered_flag: finished " + Def.CUBE_NAME + " update[incremental].");
	}

	public void transitionPlan() {
		
	}

	public void transitionApprovedForecast() {
		
	}

	public void transitionBoardApprovedPlan() {

	}

	public void transitionActualMonth() {

	}

	public void transitionActualYear() {

	}
}
