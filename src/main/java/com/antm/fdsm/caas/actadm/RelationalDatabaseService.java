package com.antm.fdsm.caas.actadm;

import java.util.function.Consumer;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.odc.DatabaseServiceList.Database;

import io.vertx.core.json.JsonArray;

public class RelationalDatabaseService {
	
	public static void extractPSGLCurrentMonthBase() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute(ServiceDefs.DIRECTORY_PROJECT + "_base_table_truncate.sql");
		hypusr.update(ServiceDefs.DIRECTORY_PROJECT + "_base_table_insert.sql", new JsonArray().add(ServiceDefs.CURRENT_PERIOD).add(ServiceDefs.CURRENT_YEAR));
		hypusr.update(ServiceDefs.DIRECTORY_PROJECT + "_base_update_project.sql");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_base_query_monetary.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/base/act_monetary_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_base_query_stat.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/base/act_statistical_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_base_balance_adm.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_adm" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_base_balance_fte.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_fte" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_base_balance_hct.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hct" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs. DIRECTORY_PROJECT + "_base_balance_hrs.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hrs" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
	}
	
	public void extractCurrentMonthIncremental() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute(ServiceDefs.DIRECTORY_PROJECT + "_incr_table_truncate.sql");
		hypusr.update(ServiceDefs.DIRECTORY_PROJECT + "_incr_table_insert.sql", new JsonArray().add(ServiceDefs.CURRENT_PERIOD).add(ServiceDefs.CURRENT_YEAR));
		hypusr.update(ServiceDefs.DIRECTORY_PROJECT + "_incr_update_project.sql");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_incr_query_monetary.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/incr/act_monetary_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_incr_query_stat.sql", ServiceDefs.DIRECTORY_PROJECT + "/data/incr/act_monetary_ap"+ ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR +".txt");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_incr_balance_adm.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_adm.json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_incr_balance_fte.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_fte.json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_incr_balance_hct.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hct.json");
		hypusr.queryBlocking(ServiceDefs.DIRECTORY_PROJECT + "_incr_balance_hrs.sql", ServiceDefs.DIRECTORY_PROJECT + "/balances/act_hrs.json");
	}
	
}
