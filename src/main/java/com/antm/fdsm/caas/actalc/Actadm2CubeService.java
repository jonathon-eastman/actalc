package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.MdxOutputFile;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.utils.Singleton;

public class Actadm2CubeService {
	
	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube actadm2;

	public Actadm2CubeService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		actadm2 = server.getApplication(service, "ACTADM2").getCube("ACTADM2");
	}
	
	public CompletableFuture<Void> extractUnallocated()  {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try {
				String mdx = 	"SELECT CROSSJOIN({[Administrative Expenses for Cost Allocations]}, CROSSJOIN({[Actual]}, CROSSJOIN({[Anthem, Inc. (Cons)]}, " + 
								"CROSSJOIN({[" + Helpers.convertMonthNumber(Def.CP) + "]}, {[Project Total]})))) ON AXIS(0), " + 
								"NON EMPTY Descendants([Cost Center].[Cost Center Total], [Cost Center].levels(0)) DIMENSION PROPERTIES [Cost Center].[MEMBER_UNIQUE_NAME] on AXIS(1) " + 
								"FROM ACTADM2.ACTADM2";
				MdxOutputFile extract = actadm2.runMdx(mdx, Def.DIR_MDX + "/unallocated_admin.txt").get();
				extract.applicationName(Def.CALC_NAME)
					.cubeName(Def.CALC_NAME)
					.replaceHeader("From Center|Admin Exp Alloc", 1)
					.returnCloud();
			} 
			catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		});
		return cf;
	}
	
}
