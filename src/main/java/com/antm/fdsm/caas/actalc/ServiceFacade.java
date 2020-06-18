package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import com.antm.fdsm.orcl.odc.services.OracleRelationalService;
import com.antm.fdsm.orcl.oac.services.EssbaseService;
import com.antm.fdsm.orcl.utils.GlobalCom;


public class ServiceFacade {

	public static void archive(EssbaseService essbase, OracleRelationalService oracle) {
		//EssbaseCubeService svc = new EssbaseCubeService(oacService).associate(dbService);
	}

	public static void base(EssbaseService essbase, OracleRelationalService oracle) throws Exception {
//		GlobalCom.slackInfo(Def.SLACK_WEBHOOK_APP, ":rocket: starting " + Def.CUBE_NAME + " update[base].");

		final EssbaseMetadataService metaService = new EssbaseMetadataService(essbase);

		final Actadm2CubeService actadm2 = new Actadm2CubeService(essbase);
		CompletableFuture<Void> extract = actadm2.extractUnallocated();
		CompletableFuture<Void> createRptg =  metaService.createReportingCube();
		CompletableFuture<Void> createCalc =  metaService.createCalculatingCube();
		
		createCalc.get();
		createRptg.get();
		extract.get();
		EssbaseCalculationService calcService = new EssbaseCalculationService(essbase);
		calcService.clearAllData();
		CompletableFuture<Void> unallocatedLoad = calcService.loadUnallocated();
		CompletableFuture<Void> detailRates = calcService.loadCostCenterRatesDetail();
		CompletableFuture<Void> summaryRates = calcService.loadCostCenterRatesSummary();
//		CompletableFuture<Void> headcountLoad = calcService.loadHeadcountAllocation();
		unallocatedLoad.get();
		summaryRates.get();
		detailRates.get();
//		headcountLoad.get();
		calcService.allocate();
		calcService.exportCube();
		
//	calcService.exportCubeDBG();
//this export works, but doesn't produce correct data
		
		EssbaseReportingService rptgService = new EssbaseReportingService(essbase);
		rptgService
			.clearAllData()
			.loadAlloc()
			.loadHC()
			.loadCaremoreQiAlloc()
//			.loadDBGAlloc()
			.loadPSTQIAlloc()
			.loadCurrentPeriodHistory().get()
			.loadHistory()
			.move2Production()
			.balance()
		;
		
	}

	public static void incremental(EssbaseService oacService, OracleRelationalService oracle) throws Exception {

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
