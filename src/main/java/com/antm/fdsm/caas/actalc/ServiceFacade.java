package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import com.antm.fdsm.orcl.odc.services.OracleService;
import com.antm.fdsm.orcl.oac.services.EssbaseAnalyticsService;
import com.antm.fdsm.orcl.utils.GlobalCom;


public class ServiceFacade {

	public static void archive(EssbaseAnalyticsService oacService, OracleService dbService) {
		//EssbaseCubeService svc = new EssbaseCubeService(oacService).associate(dbService);
	}

	public static void base(EssbaseAnalyticsService oacService, OracleService dbService) throws Exception {
		GlobalCom.slackInfo(Def.SLACK_WEBHOOK_APP, ":rocket: starting " + Def.CUBE_NAME + " update[base].");

		final EssbaseMetadataService metaService = new EssbaseMetadataService(oacService);

		final Actadm2CubeService actadm2 = new Actadm2CubeService(oacService);
		CompletableFuture<Void> extract = actadm2.extractUnallocated();
		CompletableFuture<Void> createRptg =  metaService.createReportingCube();
		CompletableFuture<Void> createCalc =  metaService.createCalculatingCube();
		
		createCalc.get();
		createRptg.get();
		extract.get();
		
		EssbaseCalculationService calcService = new EssbaseCalculationService(oacService);
		calcService.clearAllData();
		CompletableFuture<Void> unallocatedLoad = calcService.loadUnallocated();
		calcService.loadCostCenterRatesDetail().get();
		CompletableFuture<Void> summaryRates = calcService.loadCostCenterRatesSummary();
		unallocatedLoad.get();
		summaryRates.get();
		calcService.allocate();
		calcService.exportCube();
		calcService.exportCubeHC();
////	calcService.exportCubeDBG();
		//this export works, but doesn't produce correct data - using 
		
		EssbaseReportingService rptgService = new EssbaseReportingService(oacService);
		rptgService.clearAllData()
			.loadAlloc()
			.loadCaremoreQiAlloc()
			.loadDBGAlloc()
			.loadPSTQIAlloc()
			.loadCurrentPeriodHistory().get()
			.loadHistory()
			.move2Production()
			.balance()
		;
		
		GlobalCom.slackInfo(Def.SLACK_WEBHOOK_APP, ":checkered_flag: finished " + Def.CUBE_NAME + " update[base].");
	}

	public static void incremental(EssbaseAnalyticsService oacService, OracleService dbService) throws Exception {
		GlobalCom.slackInfo(Def.SLACK_WEBHOOK_APP, ":rocket: starting " + Def.CUBE_NAME + " update[incremental].");

		/*RelationalDatabaseService relationalService = new RelationalDatabaseService(dbService);
		relationalService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(oacService);
		calcService.clearAllData()
			.loadDrivers().get()
			.loadUnallocated().get()
			.exportCube()
			.loadPreviousExport()
			.exportIncremental()
			.moveNewExport2Previous();

		EssbaseCubeService cubeService = new EssbaseCubeService(oacService);
		cubeService.loadIncrementalSlice().balance();

		//update time here.*/
		GlobalCom.slackInfo(Def.SLACK_WEBHOOK_APP, ":checkered_flag: finished " + Def.CUBE_NAME + " update[incremental].");
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
