package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class ServiceFacade {

	public void archive() {

	}

	public static void base(Singleton service) throws Exception {
		EssbaseMetadataService metaService = new EssbaseMetadataService(service);
		EssbaseReportingService rptgService = metaService.createReportingCube();
		metaService.createCalculatingCube();
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(service);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.moveNewExport2Previous();
		rptgService
			.clearAllData()
			.loadCurrentPeriod()
			.loadHistory()
			.agg()
			.move2Production();
	}

	public static void incremental(Singleton service) throws Exception {
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(service);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.loadPreviousExport()
			.exportIncremental()
			.moveNewExport2Previous();
		
		EssbaseReportingService rptgService = new EssbaseReportingService(service);
		rptgService.loadIncrementalSlice();
		//update time here.
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
