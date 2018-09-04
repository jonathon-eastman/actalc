package com.antm.fdsm.caas.actadm2;


import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Singleton;
import io.reactivex.Observable;
import io.vertx.core.json.JsonArray;


public class RelationalDatabaseService {
	private Singleton dbService;
	
	public RelationalDatabaseService (Singleton service) {
		dbService = service;
	}

	public void extractPSGLCurrentMonth() {

		DatabaseService hypusr = new DatabaseService(dbService);
		hypusr.executeUpdate("truncate.sql").blockingSingle();
		hypusr.executeUpdate("insert_from_gl.sql", new JsonArray().add(Def.CP).add(Def.CY));
		hypusr.executeUpdate("update_project.sql").blockingSingle();
		
		Observable<DatabaseService> qryAdm = hypusr.queryToFile("balance_adm.sql", Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryFte = hypusr.queryToFile("balance_fte.sql", Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryHct = hypusr.queryToFile("balance_hct.sql", Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryHrs = hypusr.queryToFile("balance_hrs.sql", Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryMon = hypusr.queryToFile("query_act_monetary.sql",  Def.DIR_RELATIONAL + "/act_monetary_ap" + Def.CP + "_" + Def.CY + ".txt");
		Observable<DatabaseService> qryStat = hypusr.queryToFile("query_act_statistical.sql",  Def.DIR_RELATIONAL + "/act_statistical_ap" + Def.CP + "_" + Def.CY + ".txt");
		qryAdm.blockingSubscribe( db -> Logger.info("finished adm balance query."));
		qryFte.blockingSubscribe( db -> Logger.info("finished fte balance query."));
		qryHct.blockingSubscribe( db -> Logger.info("finished hct balance query."));
		qryHrs.blockingSubscribe( db -> Logger.info("finished hrs balance query."));
		qryMon.blockingSubscribe( db -> Logger.info("finished monetary amount extract query."));
		qryStat.blockingSubscribe( db -> System.out.println("finished statistical amount extract query."));

	}

}
