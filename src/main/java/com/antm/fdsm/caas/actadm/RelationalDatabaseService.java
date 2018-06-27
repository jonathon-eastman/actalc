package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.odc.DatabaseServiceList.Database;

import io.vertx.core.json.JsonArray;

public class RelationalDatabaseService {

	public static void extractPSGLCurrentMonth() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute("truncate.sql");
		hypusr.update("insert_from_gl.sql", new JsonArray().add(Def.CP).add(Def.CY));
		hypusr.update("update_project.sql");
		hypusr.queryBlocking("query_monetary.sql", Def.DIR_RELATIONAL + "/act_monetary_ap" + Def.CP + "_" + Def.CY + ".txt");
		hypusr.queryBlocking("query_stat.sql", Def.DIR_RELATIONAL + "/act_statistical_ap" + Def.CP + "_" + Def.CY + ".txt");
		hypusr.queryBlocking("balance_adm.sql", Def.DIR_BALANCE + "/act_adm" + Def.CP + "_" + Def.CY + ".json");
		hypusr.queryBlocking("balance_fte.sql", Def.DIR_BALANCE + "/act_fte" + Def.CP + "_" + Def.CY + ".json");
		hypusr.queryBlocking("balance_hct.sql", Def.DIR_BALANCE + "/act_hct" + Def.CP + "_" + Def.CY + ".json");
		hypusr.queryBlocking("balance_hrs.sql", Def.DIR_BALANCE + "/act_hrs" + Def.CP + "_" + Def.CY + ".json");
	}

}
