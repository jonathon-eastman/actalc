package com.antm.fdsm.caas.actadm2;


import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Singleton;

import io.vertx.core.json.JsonArray;

public class RelationalDatabaseService {
	private Singleton dbService;
	
	public RelationalDatabaseService (Singleton service) {
		dbService = service;
	}

	public void extractPSGLCurrentMonth() {

		DatabaseService hypusr = new DatabaseService(dbService);
		String outputFile = Def.DIR_RELATIONAL + "/act_monetary_ap" + Def.CP + "_" + Def.CY + ".txt";
		hypusr.execute("truncate.sql")
			.querySingleWithParams("insert_from_gl.sql", new JsonArray().add(Def.CP).add(Def.CY))
			.update("update_project.sql")
			.query2File("balance_adm.sql", Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json")
			.query2File("balance_fte.sql", Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json")
			.query2File("balance_hct.sql", Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json")
			.query2File("balance_hrs.sql", Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json")
			.query2FileTraditional("query_act_monetary.sql",  Def.DIR_RELATIONAL + "/act_monetary_ap" + Def.CP + "_" + Def.CY + ".txt")
			.query2FileTraditional("query_act_statistical.sql",  Def.DIR_RELATIONAL + "/act_statistical_ap" + Def.CP + "_" + Def.CY + ".txt");
			//.queryParallel(
			//	Arrays.asList("query_act_monetary.sql","query_act_statistical.sql"),//, "balance_adm.sql","balance_fte.sql", "balance_hct.sql", "balance_hrs.sql"),
			//	Arrays.asList(outputFile,outputFile.replace("monetary", "statistical"))//, Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json", Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json", Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json", Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json")
		//	);
	}

}
