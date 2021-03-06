package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.tinylog.Logger;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.MdxOutputFile;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.oac.services.EssbaseService;
import io.vertx.core.json.JsonObject;

public class Actadm2CubeService {
	
	private EssbaseService essbase;
	private EssbaseServer server;
	private EssbaseCube actadm2;

	public Actadm2CubeService(EssbaseService essbaseService) {
		essbase = essbaseService;
		server = new EssbaseServer(essbase);
		actadm2 = server.getApplication(essbase, "ACTADM2").getCube("ACTADM2");
	}
	
	public CompletableFuture<Void> extractUnallocated()  {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try {
				String mdx = 	"SELECT CROSSJOIN({[Administrative Expenses for Cost Allocations]}, CROSSJOIN({[Actual]}, CROSSJOIN({[Anthem, Inc. (Cons)]}, " + 
								"CROSSJOIN({[" + Helpers.convertMonthNumber(Def.CP) + "]}, {[Project Total]})))) ON AXIS(0), " + 
								"NON EMPTY Descendants([Cost Center].[Cost Center Total], [Cost Center].levels(0)) DIMENSION PROPERTIES [Cost Center].[MEMBER_UNIQUE_NAME] on AXIS(1) " + 
								"FROM ACTADM2.ACTADM2";
				MdxOutputFile extract = actadm2.runMdxGrid(mdx, "unallocated_admin.txt").get();
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
	
	
	public double getTotalUnallocatedAdmin() throws InterruptedException, ExecutionException {
		String mdx = 	"SELECT CROSSJOIN({[Cost Center Total]},CROSSJOIN({[Administrative Expenses for Cost Allocations]},CROSSJOIN({[Project Total]},CROSSJOIN({[Anthem, Inc. (Cons)]},{[Actual]})))) ON AXIS(0),\n" +
						"{ [" + Helpers.convertMonthNumber(Def.CP) + "]} ON AXIS(1)\n" +
						"FROM ACTADM2.ACTADM2";
		//essbase
		JsonObject essbaseResults = actadm2.runMdxGrid(mdx).get();
		Logger.info("Got essbase results as json [{}].", essbaseResults);
		double admEssbase = Helpers.ifNumberGetDoubleElseZero(essbaseResults.getJsonObject("slice").getJsonObject("data").getJsonArray("ranges").getJsonObject(0).getJsonArray("values").getString(11));

		return admEssbase;
	}
	
}
