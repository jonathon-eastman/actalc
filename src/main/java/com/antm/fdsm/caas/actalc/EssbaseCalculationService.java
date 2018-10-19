package com.antm.fdsm.caas.actalc;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.pmw.tinylog.Logger;
import com.antm.fdsm.orcl.oac.AnalyticExportFile;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.LoadRule;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseCalculationService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube calcCube;

	public EssbaseCalculationService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		calcCube = server.getApplication(service, Def.CALC_NAME).getCube(Def.CALC_NAME);
	}
	
	public EssbaseCalculationService allocate() throws Exception {
		List<String> alternateStructures = Arrays.asList("par_dtl1", "par_dtl2", "par_dtl3", "par_dtl4", "par_dtl5", "par_dtl6");
		List<CompletableFuture<Void>> cfList = alternateStructures.stream().parallel().map(str -> calcCube.calculate(str)).collect(Collectors.toList());
		cfList.parallelStream().forEach(cf -> {
			try {
				cf.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return this;
	}

	public EssbaseCalculationService clearAllData() throws InterruptedException, ExecutionException {
		calcCube.clear().get();
		return this;
	}

	public EssbaseCalculationService exportCube() throws Exception {
		List<String> alternateStructures = Arrays.asList("Alloc_0", "Alloc_1", "Alloc_2", "Alloc_3", "Alloc_4", "Alloc_5");
		List<CompletableFuture<AnalyticExportFile>> cfList = alternateStructures.stream().parallel().map(str -> exportWithFixStatement(calcCube, str)).collect(Collectors.toList());
		cfList.parallelStream().forEach(cf -> formatExport(service, cf));
		return this;
	}

	/*public EssbaseCalculationService exportIncremental() throws Exception {
		AnalyticExportFile export = calcCube.export(f -> f.fileName(Def.DIR_PROJECT + ".txt")).get();
		export.bringLocally(service.getHome() + "/" + Def.DIR_INCREMENTAL + "/" + Def.DIR_PROJECT + ".txt")
			.pipeify()
			.removeZeros();
		return this;
	}*/
	
	private static CompletableFuture<AnalyticExportFile> exportWithFixStatement(EssbaseCube cube, String str ) {
		String fix = "FIX (@RELATIVE(\"Company\", 0), @RELATIVE(\"Funding Type Total\", 0),@RELATIVE(\"Fixed Pool Total\", 0),@RELATIVE(\"MBU Total\", 0),@RELATIVE(\"Product Total\", 0),@RELATIVE(\"" + str + "\", 0), \"Admin Exp Alloc\", \"" + str + "\", " + Helpers.convertMonthNumber(Def.CP) + ")"; 
		CompletableFuture<AnalyticExportFile> export = null;
		try {
			export = cube.export(f -> f.fileName(Def.DIR_PROJECT + ".txt").addFixStatement(fix));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return export;
	}

	private static void formatExport(Singleton service, CompletableFuture<AnalyticExportFile> cf) {
		try {
			AnalyticExportFile export = cf.get();
			export.bringLocally(
				service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt",
				service.getHome() + "/" + Def.DIR_NEW + "/" + Def.DIR_PROJECT + ".txt"
			).pipeify().copy2Backup(service.getHome() + "/" + Def.DIR_BKP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CompletableFuture<Void> loadUnallocated() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			Logger.info("loading current period.");
			try {
				calcCube.load((loadFile, ruleFile) -> {
					loadFile.localPath(service.getHome() + "/" + Def.DIR_MDX + "/unallocated_admin.txt");
					ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_MDX + "/unallocated_admin.txt")
					.addVirtualColumn("MBU", "MUDDDD")
					.addVirtualColumn("Product", "PRDDD")
					.addVirtualColumn("Company", "GDDDD")
					.addVirtualColumn("Funding Type", "DD")
					.addVirtualColumn("Time Periods", Helpers.translateMonthNumber(Def.CP))
					.addVirtualColumn("Fixed Pool", "F00")
					.addVirtualColumn("Scenarios", "Actual");
				}).get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		return cf;
	}
	
	public CompletableFuture<Void> loadCostCenterRatesDetail() {
		return calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt");
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt");
		});
	}
	
	public CompletableFuture<Void> loadCostCenterRatesSummary() {
		return calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt");
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt");
		});
	}

	public CompletableFuture<EssbaseCalculationService> loadCurrentPeriodHistory()  {
		CompletableFuture<EssbaseCalculationService> cf = CompletableFuture.supplyAsync(() -> {
			Logger.info("loading current period.");
			try {
				calcCube.loadFilesInDirectory(service.getHome() + "/" + Def.DIR_CPHISTORY).get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		});
		return cf;
	}

	public EssbaseCalculationService loadPreviousExport() throws Exception {
		Logger.info("loading previous period.");
		calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt").isFileLocal(true);
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt")
				.setValuesOperator(LoadRule.ValuesOperator.SUBTRACT);
		}).get();
		return this;
	}

	public EssbaseCalculationService moveNewExport2Previous() { 
		Helpers.moveLocalFile(
			service.getHome() + "/" + Def.DIR_NEW + "/" + Def.DIR_PROJECT + ".txt",
			service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + Def.DIR_PROJECT + ".txt",
			service.getFs()
		);
		return this;
	}

}
