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
	
	public static void incremental() {
		RelationalDatabaseService.extractPSGLCurrentMonthBase();
		EssbaseReportingService rptgService = new EssbaseReportingService();
		rptgService.clearAllData().loadCurrentPeriodBase().loadHistory();
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
