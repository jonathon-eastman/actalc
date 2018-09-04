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
		hypusr.executeUpdate("insert_from_gl.sql", new JsonArray().add(Def.CP).add(Def.CY)).blockingSingle();
		hypusr.executeUpdate("update_project.sql").blockingSingle();
		
		Observable<DatabaseService> qryAdm = hypusr.query2File("balance_adm.sql", Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryFte = hypusr.query2File("balance_fte.sql", Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryHct = hypusr.query2File("balance_hct.sql", Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryHrs = hypusr.query2File("balance_hrs.sql", Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json");
		Observable<DatabaseService> qryMon = hypusr.query2File("query_act_monetary.sql",  Def.DIR_RELATIONAL + "/act_monetary_ap" + Def.CP + "_" + Def.CY + ".txt");
		Observable<DatabaseService> qryStat = hypusr.query2File("query_act_statistical.sql",  Def.DIR_RELATIONAL + "/act_statistical_ap" + Def.CP + "_" + Def.CY + ".txt");
		qryAdm.blockingSubscribe( db -> Logger.info("finished adm balance query."));
		qryFte.blockingSubscribe( db -> Logger.info("finished fte balance query."));
		qryHct.blockingSubscribe( db -> Logger.info("finished hct balance query."));
		qryHrs.blockingSubscribe( db -> Logger.info("finished hrs balance query."));
		qryMon.blockingSubscribe( db -> Logger.info("finished monetary amount extract query."));
		qryStat.blockingSubscribe( db -> System.out.println("finished statistical amount extract query."));

	}

}
