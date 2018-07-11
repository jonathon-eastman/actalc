package com.antm.fdsm.caas.actadm;

import java.util.Arrays;
import java.util.List;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.utils.Singleton;

public class ServiceFacade {

	public void archive() {

	}

	public static void base(Singleton service) throws Exception {
		service.slackInfo(Def.SLACK_WEBHOOK_APP, "Starting " + Def.CUBE_NAME + " update[base].");

		//create meta service,
		final EssbaseMetadataService metaService = new EssbaseMetadataService(service);

		Runnable step1 = () -> {
			metaService.createCalculatingCube();
		};
		Runnable step2 = () -> {
			metaService.createReportingCube();
		};

		List<Runnable> parallel1 = Arrays.asList(step1, step2);
		parallel1.stream().parallel().forEach((step) -> step.run());

		//RelationalDatabaseService.extractPSGLCurrentMonth();
		
		EssbaseCalculationService calcService = new EssbaseCalculationService(service);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.moveNewExport2Previous();

		EssbaseReportingService rptgService = new EssbaseReportingService(service);
		rptgService
			.clearAllData()
			.loadCurrentPeriod()
			.loadHistory()
			.agg()
			.move2Production();

		service.slackInfo(Def.SLACK_WEBHOOK_APP, "Finished " + Def.CUBE_NAME + "update[base].");
	}

	public static void incremental(Singleton service) throws Exception {
		service.slackInfo(Def.SLACK_WEBHOOK_APP, "Starting " + Def.CUBE_NAME + "update[incremental].");
		//RelationalDatabaseService.extractPSGLCurrentMonth();
		EssbaseCalculationService calcService = new EssbaseCalculationService(service);
		calcService.clearAllData()
			.loadCurrentPeriod()
			.exportCube()
			.loadPreviousExport()
			.exportIncremental()
			.moveNewExport2Previous();
		
		EssbaseCubeService cubeService = new EssbaseCubeService(service);
		cubeService.loadIncrementalSlice();
		//update time here.
		service.slackInfo(Def.SLACK_WEBHOOK_APP, "Finished " + Def.CUBE_NAME + "update[incremental].");
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
