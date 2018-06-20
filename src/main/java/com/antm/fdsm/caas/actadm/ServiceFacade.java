package com.antm.fdsm.caas.actadm;

public class ServiceFacade {
	
	public void archive() {
		
	}
	
	public static void base() {
		EssbaseMetadataService metaService = new EssbaseMetadataService();
		EssbaseReportingService rptgService = metaService.createReportingCube();
		RelationalDatabaseService.extractPSGLCurrentMonth();
		rptgService.clearAllData().loadCurrentPeriod("incremental").loadHistory();
	}
	
	public static void incremental() throws Exception {
		RelationalDatabaseService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService();
		calcService.loadCurrentPeriod();
		calcService.exportCube(ServiceDefs.EXPORT_TYPE_INCREMENTAL);
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
