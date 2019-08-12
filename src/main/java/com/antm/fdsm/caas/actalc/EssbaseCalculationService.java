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
import com.antm.fdsm.orcl.utils.GlobalOptions;
import com.antm.fdsm.orcl.utils.GlobalPaths;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.oac.services.EssbaseAnalyticsService;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;


public class EssbaseCalculationService {

		
	private EssbaseAnalyticsService service;
	private EssbaseServer server;
	private EssbaseCube calcCube;

	public EssbaseCalculationService(EssbaseAnalyticsService oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		calcCube = server.getApplication(service, Def.CALC_NAME).getCube(Def.CALC_NAME);
	}
	
	public EssbaseCalculationService allocate() throws Exception {
		List<String> allocationScriptsRegion = Arrays.asList("allocate_region1.csc", "allocate_region2.csc", "allocate_region3.csc", "allocate_region4.csc", "allocate_region5.csc", "allocate_region6.csc", "allocate_DBG.csc");
		JsonArray vars = new JsonArray().add(new JsonObject().put("key", "CURRENT_PERIOD_ACTUAL").put("value", Helpers.translateMonthNumber(Def.CP)));
		calcCube.setSubstitutionVariables(vars);
		int skip = 0;
		int limit = 3;
		while (allocationScriptsRegion.size()> skip) {
			List<CompletableFuture<Void>> cfList = allocationScriptsRegion.stream().skip(skip).limit(limit).map(str -> calcCube.calculate(str, true)).collect(Collectors.toList());
			cfList.parallelStream().forEach(cf -> {
				try {
					cf.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			skip += limit;
		}
		return this;
	}

	public EssbaseCalculationService clearAllData() throws InterruptedException, ExecutionException {
		calcCube.clear().get();
		return this;
	}

	public EssbaseCalculationService exportCube() throws Exception {
		List<String> alternateStructures = Arrays.asList("Alloc_0", "Alloc_1", "Alloc_2", "Alloc_3", "Alloc_4", "Alloc_5");
		List<CompletableFuture<AnalyticExportFile>> cfList = alternateStructures.stream().parallel().map(str -> exportWithFixStatement(calcCube, GlobalOptions.HOME, str)).collect(Collectors.toList());
		cfList.parallelStream().forEach(cf -> formatExport(service, cf));
		return this;
	}
	
	private static CompletableFuture<AnalyticExportFile> exportWithFixStatement(EssbaseCube cube,String strHome, String str ) {
		String fix = "FIX (@RELATIVE(\"Company\", 0), @RELATIVE(\"Funding Type Total\", 0),@RELATIVE(\"Fixed Pool Total\", 0),@RELATIVE(\"" + str +"\", 0),@RELATIVE(\"Product Total\", 0),@RELATIVE(\"" + str + "\", 0), \"Admin Exp Alloc\", \"" + str + "\", " + "Jan:" + Helpers.translateMonthNumber(Def.CP) + ")"; 
		CompletableFuture<AnalyticExportFile> export = null;
		try {
			export = cube.export(f -> f
				.fileName(Def.PROJECT_NAME + "_" + str.toLowerCase() + ".txt")
				.addFixStatement(fix)
				.setHeaderDimension("Accounts")
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return export;
	}
	public EssbaseCalculationService exportCubeDBG() throws Exception {
		List<String> alternateStructures = Arrays.asList("Alloc_DBG");
		List<CompletableFuture<AnalyticExportFile>> cfList = alternateStructures.stream().parallel().map(str -> exportDBGWithFixStatement(calcCube, GlobalOptions.HOME, str)).collect(Collectors.toList());
		cfList.parallelStream().forEach(cf -> formatExport(service, cf));
		return this;
	}
	
	private static CompletableFuture<AnalyticExportFile> exportDBGWithFixStatement(EssbaseCube cube,String strHome, String str ) {
		String fix = "FIX (@RELATIVE(\"WellPoint, Inc. (Cons)\", 0), @RELATIVE(\"Funding Type Total\", 0),@RELATIVE(\"Fixed Pool Total\", 0),@RELATIVE(\"" + str +"\", 0),@RELATIVE(\"Product Total\", 0),@RELATIVE(\"" + str +"\", 0),@RELATIVE(\"Diversified Business Group\", 0),@RELATIVE(\"" + str + "\", 0), \"Admin Exp Alloc\", \"" + str + "\", " + Helpers.translateMonthNumber(Def.CP) + ")"; 
		CompletableFuture<AnalyticExportFile> export = null;
		try {
			export = cube.export(f -> f
				.fileName(Def.PROJECT_NAME + "_" + str.toLowerCase() + ".txt")
				.addFixStatement(fix)
				.setHeaderDimension("Accounts")
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return export;
	}
	
	
	
	
	
	
	private static void formatExport(EssbaseAnalyticsService service, CompletableFuture<AnalyticExportFile> cf) {
		try {
			List<String> ccs = Arrays.asList(  "4801900000", "4810000100", "4810001100", "4810001800", "4810002300", "4810010600", "4810010800",
					          "4810015100", "4810020100", "4810025100", "4810100000", "4810110000", "4810120000", "4810410000",
					          "4810540000", "4810712000", "4812500000", "4812510000", "4812520000", "4814900000", "4814900100",
					          "4816000100", "4816001100", "4816001800", "4816002300", "4816010600", "4816010800", "4816015100",
					          "4816020100", "4819800000", "4821100100", "4821110600", "4822100100", "4823100100", "4824100000",
					          "4824100100", "4824101000", "4824101100", "4824101200", "4824101800", "4824102300", "4824110600",
					          "4824110800", "4824115100", "4824120100", "4824125100", "4830000100", "4830001100", "4830001800",
					          "4830002300", "4830010600", "4830010800", "4830015100", "4830020100", "4840100000", "4840100100",
					          "4840101100", "4840101800", "4840102300", "4840110600", "4840110800", "4840115100", "4840120000",
					          "4840120100", "4840125100", "4840200000", "4840200100", "4840201100", "4840201800", "4840202300",
					          "4840202900", "4840203300", "4840210000", "4840210100", "4840210600", "4840210800", "4840215100",
					          "4840220100", "4840225100", "4840250000", "4840300000", "4840300100", "4840301000", "4840301100",
					          "4840301800", "4840302300", "4840302900", "4840310600", "4840310800", "4840315100", "4840320100",
					          "4840400000", "4840400100", "4840401000", "4840401800", "4840410600", "4840410800", "4840415100",
					          "4840420100", "4840500100", "4840510600", "4840515100", "4840520100", "4840600100", "4840700100",
					          "4840800000", "4840910600", "4841000000", "4841100100", "4841200100", "4850200000", "4851120000",
					          "4851120100", "4851120200", "4851120300", "4851120400", "4851220000", "4851320000", "4851420000",
					          "4860100000", "4880000100", "4880001800", "4880020100", "4880100100", "4880101800", "4880120100",
					          "4880200100", "4880220100", "4880300100", "4880320100", "4880400100", "4880420100", "4880500100",
					          "4880520100", "4890800000", "4890900000", "4891000000", "4891200000", "4891810000", "6331100100",
					          "6331100300", "6331100400", "6331100700", "6331101000", "6331101100", "6331101200", "6331101500",
					          "6331101700", "6331102000", "6331102100", "6331102700", "6331102800", "6331103000", "6331103100",
					          "6331103200", "6331103300", "6331103600", "6331200300", "6331200600", "6331201000", "6331202500",
					          "6331203900", "6331400300", "6331400400", "6331400700", "6331401000", "6331401500", "6331401600",
					          "6331401800", "6331402200", "6331402300", "6331402700", "6331403400", "6331403700", "6331500600",
					          "6331501000", "6331502500", "6331504200", "6331600300", "6331600400", "6331600700", "6331601000",
					          "6331601500", "6331601600", "6331601800", "6331602200", "6331602300", "6331602700", "6331603400",
					          "6331603800" );
			AnalyticExportFile export = cf.get();
			export.bringLocally(
				Def.ESSBASE_PREVIOUS + "/" + export.fileName,
				Def.EXPORT + "/required/" + export.fileName)
			.pipeify().copy2Backup(Def.BKP);
			
			String fn = export.fileName.replace(".txt", "_qi_reclass.txt");
			export.intersect(ccs, Def.EXPORT + "/required/" + fn).replaceInHeader("Admin Exp Alloc", "CareMore QI Exp");
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
					loadFile.localPath(Def.TMP + "/unallocated_admin.txt");
					ruleFile.aiSourceFile(Def.TMP + "/unallocated_admin.txt")
					.addVirtualColumn("MBU", "MUDDDD")
					.addVirtualColumn("Product", "PRDDD")
					.addVirtualColumn("Company", "GDDDD")
					.addVirtualColumn("Funding Type", "DD")
					.addVirtualColumn("Time Periods", Helpers.translateMonthNumber(Def.CP))
					.addVirtualColumn("Fixed Pool", "F00");
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
			loadFile.localPath(Def.IN + "/" + Def.PROJECT_NAME + "_r1.txt");
			ruleFile.aiSourceFile(Def.IN + "/" + Def.PROJECT_NAME + "_r1.txt")
			.ignoreFileColumn("Accounts")
			.addVirtualColumn("Accounts", "Driver Detail");
		});
	}
	
	public CompletableFuture<Void> loadCostCenterRatesSummary() {
		return calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(Def.IN + "/" + Def.PROJECT_NAME + "_r1.txt");
			ruleFile.aiSourceFile(Def.IN + "/" + Def.PROJECT_NAME + "_r1.txt")
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
			.addVirtualColumn("Accounts", "Driver Total");
		});
	}

	public EssbaseCalculationService loadPreviousExport() throws Exception {
		Logger.info("loading previous period.");
		calcCube.load((loadFile, ruleFile) -> {
			loadFile.localPath(Def.ESSBASE_PREVIOUS + "/" + Def.PROJECT_NAME + ".txt").isFileLocal(true);
			ruleFile.aiSourceFile(Def.ESSBASE_PREVIOUS + "/" + Def.PROJECT_NAME + ".txt")
				.setValuesOperator(LoadRule.ValuesOperator.SUBTRACT);
		}).get();
		return this;
	}

	public EssbaseCalculationService moveNewExport2Previous() { 
		Helpers.moveLocalFile(
			Def.EXPORT + "/new/" + Def.PROJECT_NAME + ".txt",
			Def.ESSBASE_PREVIOUS + "/" + Def.PROJECT_NAME + ".txt",
			GlobalOptions.VERTX_FS
		);
		return this;
	}
		
}
