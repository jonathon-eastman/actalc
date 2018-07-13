package com.antm.fdsm.caas.actadm;

import java.util.Arrays;
import java.util.List;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.utils.Singleton;

public class ServiceFacade {

	public void archive() {

	}

	public static void base(Singleton oacService, Singleton dbService) throws Exception {
		//service.slackInfo(Def.SLACK_WEBHOOK_APP, "Starting " + Def.CUBE_NAME + " update[base].");
		RelationalDatabaseService relationalService = new RelationalDatabaseService(dbService);

		final EssbaseMetadataService metaService = new EssbaseMetadataService(oacService);

		Runnable step1 = () -> {
			relationalService.extractPSGLCurrentMonth();
		};
		Runnable step2 = () -> {
			metaService.createCalculatingCube();
			metaService.createReportingCube();
		};

		List<Runnable> parallel1 = Arrays.asList(step1, step2);
		parallel1.stream().parallel().forEach((step) -> step.run());

		/*EssbaseCalculationService calcService = new EssbaseCalculationService(oacService);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.moveNewExport2Previous();

		EssbaseReportingService rptgService = new EssbaseReportingService(oacService);
		rptgService
			.clearAllData()
			.loadCurrentPeriod()
			.loadHistory()
			.agg()
			.move2Production();

		service.slackInfo(Def.SLACK_WEBHOOK_APP, "Finished " + Def.CUBE_NAME + "update[base].");*/
	}

	public static void incremental(Singleton oacService, Singleton dbService) throws Exception {
		oacService.slackInfo(Def.SLACK_WEBHOOK_APP, "Starting " + Def.CUBE_NAME + "update[incremental].");
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
		cubeService.loadIncrementalSlice();
		//update time here.
		oacService.slackInfo(Def.SLACK_WEBHOOK_APP, "Finished " + Def.CUBE_NAME + "update[incremental].");
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
	
	public static void test(Singleton service) {
		EssbaseApplication app = new EssbaseApplication(service, "ACTADM");
		app.exists();
	}
}
