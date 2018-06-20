package com.antm.fdsm.caas.actadm;

public class ServiceFacade {
	
	public void archive() {
		
	}
	
	public static void base() {
		EssbaseMetadataService metaService = new EssbaseMetadataService();
		EssbaseReportingService rptgService = metaService.createReportingCube();
		RelationalDatabaseService.extractPSGLCurrentMonthBase();
		rptgService.clearAllData().loadCurrentPeriodBase().loadHistory();
	}
	
	public static void incremental() throws Exception {
		EssbaseCalculationService calcService = new EssbaseCalculationService();
		calcService.exportCube("incremental");
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
