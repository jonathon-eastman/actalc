package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.otl.ConsolidationAttribute;
import com.antm.fdsm.orcl.oac.otl.DataStorage;
import com.antm.fdsm.orcl.oac.otl.DimensionStorage;
import com.antm.fdsm.orcl.oac.otl.EssbaseOutline;
import com.antm.fdsm.orcl.oac.otl.MemberCategory;
import com.antm.fdsm.orcl.oac.otl.RestructureOption;
import com.antm.fdsm.orcl.oac.services.EssbaseAnalyticsService;

public class EssbaseMetadataService {

	private EssbaseAnalyticsService service;
	private EssbaseServer server;
	private EssbaseCube metaBsoCube;
	private EssbaseCube metaAsoCube;

	public EssbaseMetadataService(EssbaseAnalyticsService oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		metaBsoCube = server.getApplication(service, Def.META_NAME_BSO).getCube(Def.META_NAME_BSO);
		metaAsoCube = server.getApplication(service, Def.META_NAME_ASO).getCube(Def.META_NAME_ASO);
	}

	public CompletableFuture<Void> createCalculatingCube() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try {
				EssbaseApplication calcBsoApp = server.getApplication(service, Def.CALC_NAME);
				if (calcBsoApp.exists()) {
					calcBsoApp.delete().get();
				}
				EssbaseCube cube = metaBsoCube.copyToNewApplication(Def.CALC_NAME).get();
				EssbaseOutline metaOtl = cube.getOutline();
				metaOtl.beginBatchOutlineEdit();
				metaOtl.deleteMember("Alt Company Hierarchies");
				metaOtl.deleteMember("Unconsolidated Companies");
				metaOtl.deleteMember("Company Alloc");
				metaOtl.deleteMember("Alt Product Structures");
				metaOtl.deleteMember("Product Alloc");
				metaOtl.deleteMember("DOI Product");
				metaOtl.deleteMember("MBU Alloc");
				metaOtl.deleteMember("Drivers");
				metaOtl.deleteMember("Scenarios");
				metaOtl.deleteMember("CBE");
				metaOtl.deleteMember("Brand State");
				metaOtl.deleteMember("Product Type");
				metaOtl.deleteMember("CC Function");	
				metaOtl.addMember(mbr -> mbr
					.name("QI Alloc Exp")
					.parent("Accounts")
					.previousSibling("Admin Exp Alloc")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("Drivers")
					.parent("Accounts")
					.previousSibling("QI Alloc Exp")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("Driver Detail")
					.parent("Drivers")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("Driver Total")
					.parent("Drivers")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.deleteMember("Time Periods");
				metaOtl.addDimension( dim -> dim
					.name("Time Periods")
					.previousSibling("Funding Type")
					.category(MemberCategory.TIME)
					.dimensionStorage(DimensionStorage.SPARSE)
					
				);
				metaOtl.addMember(mbr -> mbr
					.name("YearTotal")
					.consolidation(ConsolidationAttribute.INGORE)
					.parent("Time Periods")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Q1")
					.parent("YearTotal")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Jan")
					.parent("Q1")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Feb")
					.parent("Q1")
					.previousSibling("Jan")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Mar")
					.parent("Q1")
					.previousSibling("Feb")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Q2")
					.parent("YearTotal")
					.previousSibling("Q1")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Apr")
					.parent("Q2")
				);
				metaOtl.addMember(mbr -> mbr
					.name("May")
					.parent("Q2")
					.previousSibling("Apr")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Jun")
					.parent("Q2")
					.previousSibling("May")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Q3")
					.parent("YearTotal")
					.previousSibling("Q2")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Jul")
					.parent("Q3")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Aug")
					.parent("Q3")
					.previousSibling("Jul")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Sep")
					.parent("Q3")
					.previousSibling("Aug")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Q4")
					.parent("YearTotal")
					.previousSibling("Q3")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Oct")
					.parent("Q4")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Nov")
					.parent("Q4")
					.previousSibling("Oct")
				);
				metaOtl.addMember(mbr -> mbr
					.name("Dec")
					.parent("Q4")
					.previousSibling("Nov")
				);
				metaOtl.addMember(mbr -> mbr
					.name("BegBalance")
					.parent("Time Periods")
					.previousSibling("YearTotal")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.updateMember(mbr -> mbr
					.name("YearTotal")
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.updateMember(mbr -> mbr
					.name("Q1")
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.updateMember(mbr -> mbr
					.name("Q2")
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.updateMember(mbr -> mbr
					.name("Q3")
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.updateMember(mbr -> mbr
					.name("Q4")
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.updateMember(mbr -> mbr
					.name("Time Periods")
					.storage(DataStorage.LABEL_ONLY)
				);
				metaOtl.finishBatchOutlineEdit(RestructureOption.NO_DATA);
				
				metaOtl.beginBatchOutlineEdit();
				metaOtl.moveMember("Accounts", "", "Funding Type");
				metaOtl.finishBatchOutlineEdit(RestructureOption.NO_DATA);
				
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		return cf;
	}

	public CompletableFuture<Void> createReportingCube() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			EssbaseApplication rptgApp = server.getApplication(service, Def.RPTG_NAME);
			try {
				if (rptgApp.exists()) {
					rptgApp.delete().get();
				}
				EssbaseCube cube = metaAsoCube.copyToNewApplication(Def.RPTG_NAME).get();
				EssbaseOutline metaOtl = cube.getOutline();
				metaOtl.beginBatchOutlineEdit();
				metaOtl.addMember(mbr -> mbr
					.name("QI Alloc Exp")
					.parent("Accounts")
					.previousSibling("Drivers")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("CareMore QI Exp")
					.parent("Accounts")
					.previousSibling("QI Alloc Exp")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("DBG QI Exp")
					.parent("Accounts")
					.previousSibling("CareMore QI Exp")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("Contingent Vendor Fees")
					.parent("Accounts")
					.previousSibling("DBG QI Exp")
					.consolidation(ConsolidationAttribute.INGORE)
				);								
				metaOtl.finishBatchOutlineEdit(RestructureOption.NO_DATA);
			}
			catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//EssbaseReportingService rptgService = new EssbaseReportingService(service);
			return null;
		});
		return cf;
	}
}
