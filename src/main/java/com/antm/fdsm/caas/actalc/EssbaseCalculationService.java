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
		List<String> alternateStructures = Arrays.asList("allocate_region1.csc", "allocate_region2.csc", "allocate_region3.csc", "allocate_region4.csc", "allocate_region5.csc", "allocate_region6.csc");
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
	
	private static CompletableFuture<AnalyticExportFile> exportWithFixStatement(EssbaseCube cube, String str ) {
		String fix = "FIX (@RELATIVE(\"Company\", 0), @RELATIVE(\"Funding Type Total\", 0),@RELATIVE(\"Fixed Pool Total\", 0),@RELATIVE(\"" + str +"\", 0),@RELATIVE(\"Product Total\", 0),@RELATIVE(\"" + str + "\", 0), \"Admin Exp Alloc\", \"" + str + "\", " + Helpers.convertMonthNumber(Def.CP) + ")"; 
		CompletableFuture<AnalyticExportFile> export = null;
		try {
			export = cube.export(f -> f.fileName(Def.DIR_PROJECT + "_" + str + ".txt").addFixStatement(fix));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return export;
	}

	private static void formatExport(Singleton service, CompletableFuture<AnalyticExportFile> cf) {
		try {
			List<String> ccs = Arrays.asList(  "4801900000", "4810000100", "4810001100", "4810001800", "4810002300", "4810010600", "4810010800",                              
					"4810015100", "4810020100", "4810025100", "4810100000", "4810110000", "4810120000", "4810410000",                              
					"4810540000", "4810712000", "4812500000", "4812510000", "4814900000", "4814900100", "4816000100",                              
					"4816001100", "4816001800", "4816002300", "4816010600", "4816010800", "4816015100", "4816020100",                              
					"4819800000", "4821100100", "4821110600", "4822100100", "4823100100", "4824100000", "4824100100",                              
					"4824101000", "4824101100", "4824101200", "4824101800", "4824102300", "4824110600", "4824110800",                              
					"4824115100", "4824120100", "4824125100", "4830000100", "4830001100", "4830001800", "4830002300",                              
					"4830010600", "4830010800", "4830015100", "4830020100", "4840100000", "4840100100", "4840101100",                              
					"4840101800", "4840102300", "4840110600", "4840110800", "4840115100", "4840120000", "4840120100",                              
					"4840125100", "4840200000", "4840200100", "4840201100", "4840201800", "4840202300", "4840202900",                              
					"4840203300", "4840210000", "4840210100", "4840210600", "4840210800", "4840215100", "4840220100",                              
					"4840225100", "4840250000", "4840300000", "4840300100", "4840301000", "4840301100", "4840301800",                              
					"4840302300", "4840302900", "4840310600", "4840310800", "4840315100", "4840320100", "4840400000",                              
					"4840400100", "4840401000", "4840401800", "4840410600", "4840410800", "4840415100", "4840420100",                              
					"4840500100", "4840510600", "4840515100", "4840520100", "4840600100", "4840700100", "4840800000",                              
					"4840910600", "4841000000", "4841100100", "4841200100", "4850200000", "4851120000", "4851120100",                              
					"4851120200", "4851120300", "4851120400", "4851220000", "4851320000", "4851420000", "4860100000",                              
					"4880000100", "4880001800", "4880020100", "4880100100", "4880101800", "4880120100", "4880200100",                              
					"4880220100", "4880300100", "4880320100", "4880400100", "4880420100", "4880500100", "4880520100",                              
					"4890800000", "4890900000", "4891000000", "4891200000", "4891810000",                                                          
					"6331100400", "6331100700", "6331102100", "6331102700", "6331103100", "6331200600", "6331202500", "6331400400",                
					"6331400700", "6331401600", "6331401800", "6331402200", "6331402300", "6331402700", "6331500600", "6331502500",                
					"6331600400", "6331600700", "6331601600", "6331601800", "6331602200", "6331602300", "6331602700", "6331603400",
					"6331403400" );
			AnalyticExportFile export = cf.get();
			export.bringLocally(
				service.getHome() + "/" + Def.DIR_PREVIOUS + "/" + export.fileName,
				service.getHome() + "/" + Def.DIR_NEW + "/" + export.fileName)
			.pipeify().copy2Backup(service.getHome() + "/" + Def.DIR_BKP);
			
			String fn = export.fileName.replace(".txt", "_qireclass.txt");
			export.intersect(ccs, service.getHome() + "/" + Def.DIR_REQUIRED + "/" + fn);
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
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt")
			.ignoreFileColumn("Accounts")
			.addVirtualColumn("Accounts", "Driver Detail");
		});
	}
	
	public CompletableFuture<Void> loadCostCenterRatesSummary() {
		return calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt");
			ruleFile.aiSourceFile(service.getHome() + "/" + Def.DIR_REQUIRED + "/" + Def.DIR_PROJECT + "_r1.txt")
			.ignoreFileColumn("Fixed Pool")
			.ignoreFileColumn("Company")
			.ignoreFileColumn("Product")
			.ignoreFileColumn("MBU")
			.ignoreFileColumn("Funding Type")
			.ignoreFileColumn("Accounts")
			.addVirtualColumn("Fixed Pool", "F00")
			.addVirtualColumn("Company", "GDDDD")
			.addVirtualColumn("Product", "PRDDD")
			.addVirtualColumn("MBU", "MUDDDD")
			.addVirtualColumn("Funding Type", "DD")
			.addVirtualColumn("Accounts", "Driver Summary");
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
