package com.antm.fdsm.caas.actadm2;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Singleton;
import io.vertx.core.json.JsonArray;


public class RelationalDatabaseService {
	private Singleton dbService;
	
	public RelationalDatabaseService (Singleton service) {
		dbService = service;
	}

	public CompletableFuture<Void> extractPSGLCurrentMonth() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try {
				Logger.info("extracting data out of gl for current month [{}].[{}].",  Def.CY, Def.CP);
				DatabaseService hypusr = new DatabaseService(dbService);
				hypusr.executeUpdate("truncate.sql").get();
				hypusr.executeUpdate("insert_from_gl.sql", new JsonArray().add(Def.CP).add(Def.CY)).get();
				hypusr.executeUpdate("update_project.sql").get();
				
				CompletableFuture<Void> qryAdm = hypusr.query2File("balance_adm.sql", Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json");
				CompletableFuture<Void> qryFte = hypusr.query2File("balance_fte.sql", Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json");
				CompletableFuture<Void> qryHct = hypusr.query2File("balance_hct.sql", Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json");
				CompletableFuture<Void> qryHrs = hypusr.query2File("balance_hrs.sql", Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json");
				CompletableFuture<Void> qryMon = hypusr.query2File("query_act_monetary.sql",  Def.DIR_RELATIONAL + "/act_monetary_ap" + Def.CP + "_" + Def.CY + ".txt");
				CompletableFuture<Void> qryStt = hypusr.query2File("query_act_statistical.sql",  Def.DIR_RELATIONAL + "/act_statistical_ap" + Def.CP + "_" + Def.CY + ".txt");
				
				Logger.info("waiting......for parallel code extractPSGLCurrentMonth.");
				
				qryAdm.get();
				qryFte.get();
				qryHct.get();
				qryHrs.get();
				qryMon.get();
				qryStt.get();
				
				Logger.info("extracted data out of gl for current month [{}].[{}].",  Def.CY, Def.CP);
			}
			catch (ExecutionException e){
				throw new CompletionException(e);
			}
			catch (InterruptedException e){
				throw new CompletionException(e);
			}
			return null;
		});
		return cf;
	}

}
