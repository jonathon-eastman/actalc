package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.odc.DatabaseServiceList.Database;

import io.vertx.core.json.JsonArray;

public class RelationalDatabaseService {
	
	public static void extractPSGLCurrentMonth() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute(ServiceDefs.DIRECTORY_PROJECT + "truncate.sql");
		hypusr.update(ServiceDefs.DIRECTORY_PROJECT + "insert_from_gl.sql", new JsonArray().add(ServiceDefs.CURRENT_PERIOD).add(ServiceDefs.CURRENT_YEAR));
		hypusr.update(ServiceDefs.DIRECTORY_PROJECT + "update_project.sql");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "query_monetary.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/" + ServiceDefs.DIRECTORY_BASE + "/act_monetary_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "query_stat.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/" + ServiceDefs.DIRECTORY_BASE + "/act_statistical_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "balance_adm.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_adm" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "balance_fte.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_fte" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "balance_hct.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hct" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs. DIRECTORY_PROJECT + "balance_hrs.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hrs" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
	}
	
}
