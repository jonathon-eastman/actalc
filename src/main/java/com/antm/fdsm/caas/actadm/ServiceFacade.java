package com.antm.fdsm.caas.actadm;

public class ServiceFacade {
	
	public void archive() {
		
	}
	
	public void base() {
		
	}
	
	public static void incremental() {
		RelationalDatabaseService.extractPSGLCurrentMonthBase();
		RptgAsoCubeService rptg = new RptgAsoCubeService();
		rptg.clearAllData().loadCurrentPeriodBase().loadHistory();
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
