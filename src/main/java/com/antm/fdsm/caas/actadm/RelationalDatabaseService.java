package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.odc.DatabaseServiceList.Database;

import io.vertx.core.json.JsonArray;

public class RelationalDatabaseService {
	
	public static void extractPSGLCurrentMonth() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute("truncate.sql");
		hypusr.update("insert_from_gl.sql", new JsonArray().add(ServiceDefs.CURRENT_PERIOD).add(ServiceDefs.CURRENT_YEAR));
		hypusr.update("update_project.sql");
		hypusr.queryBlocking("query_monetary.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL + "/act_monetary_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking("query_stat.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/" + ServiceDefs.DIRECTORY_CURRENTPERIOD + "/" + ServiceDefs.DIRECTORY_RELATIONAL + "/act_statistical_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking("balance_adm.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_adm" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking("balance_fte.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_fte" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking("balance_hct.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hct" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking("balance_hrs.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hrs" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
	}
	
}
