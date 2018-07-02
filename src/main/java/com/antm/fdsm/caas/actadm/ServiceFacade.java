package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class ServiceFacade {

	public void archive() {

	}

	public static void base(Singleton service) {
		EssbaseMetadataService metaService = new EssbaseMetadataService(service);
		EssbaseReportingService rptgService = metaService.createReportingCube();
		metaService.createCalculatingCube();
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		rptgService.clearAllData().loadCurrentPeriod().loadHistory();
	}

	public static void incremental(Singleton service) throws Exception {
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(service);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.loadPreviousExport()
			.exportIncremental();
		
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
