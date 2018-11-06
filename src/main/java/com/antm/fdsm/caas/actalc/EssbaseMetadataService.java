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
import com.antm.fdsm.orcl.utils.Singleton;

public class EssbaseMetadataService {

	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube metaBsoCube;
	private EssbaseCube metaAsoCube;

	public EssbaseMetadataService(Singleton oacServiceSingleton) {
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
				EssbaseCube cube = metaBsoCube.copyToNewApplication(Def.CALC_NAME).getCube(Def.META_NAME_BSO).rename(Def.CALC_NAME).get();
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
				/*metaOtl.addMember(mbr -> mbr
					.name("BegBalance")
					.parent("Time Periods")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.updateDimension(mbr -> mbr
					.storage(DimensionStorage.SPARSE)
					.name("Time Periods")
				);*/
				metaOtl.addMember(mbr -> mbr
					.name("Admin Unallocated")
					.parent("Accounts")
					.previousSibling("Admin Exp Alloc")
					.consolidation(ConsolidationAttribute.INGORE)
				);
						
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
				metaOtl.addMember(mbr -> mbr
					.name("Drivers")
					.parent("Accounts")
					.previousSibling("QI Alloc Exp")
					.consolidation(ConsolidationAttribute.INGORE)
				);
				metaOtl.deleteMember("Time Periods");
				metaOtl.addDimension( dim -> dim
					.name("Time Periods")
					.previousSibling("Funding Type")
					.category(MemberCategory.TIME)
					.storage(DimensionStorage.SPARSE)
				);
				metaOtl.addMember(mbr -> mbr
					.name("YearTotal")
					.parent("Time Periods")
					//.consolidation(ConsolidationAttribute.INGORE)
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.addMember(mbr -> mbr
					.name("Q1")
					.parent("YearTotal")
					.storage(DataStorage.DYNAMIC)
				);
				metaOtl.addMember(mbr -> mbr
					.name("Jan")
					.parent("Q1")
					.storage(DataStorage.STORE_DATA)
				);
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
				EssbaseCube cube = metaAsoCube.copyToNewApplication(Def.RPTG_NAME).getCube(Def.META_NAME_ASO).rename(Def.RPTG_NAME).get();
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
