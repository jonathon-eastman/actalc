package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class ServiceFacade {

	public void archive() {
		
	}

	public static void base(Singleton config) {
		EssbaseMetadataService metaService = new EssbaseMetadataService(config);
		EssbaseReportingService rptgService = metaService.createReportingCube();
		metaService.createCalculatingCube();
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		rptgService.clearAllData().loadCurrentPeriod();//.loadHistory();
	}

	public static void incremental(Singleton s) throws Exception {
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(s);
		calcService.clearAllData().loadCurrentPeriod();
		calcService.exportCube(ServiceDefs.EXPORT_TYPE_INCREMENTAL).bringLocally("/Users/AFRA01/Documents/js/actadm/data/actadm_export.txt").pipeify();
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
