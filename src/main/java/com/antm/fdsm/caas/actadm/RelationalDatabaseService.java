package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.odc.DatabaseServiceList.Database;

import io.vertx.core.json.JsonArray;

public class RelationalDatabaseService {
	
	public static void extractPSGLCurrentMonthBase() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute(ServiceDefs.PROJECT_DIRECTORY + "_base_table_truncate.sql");
		hypusr.update(ServiceDefs.PROJECT_DIRECTORY + "_base_table_insert.sql", new JsonArray().add(ServiceDefs.CURRENT_PERIOD).add(ServiceDefs.CURRENT_YEAR));
		hypusr.update(ServiceDefs.PROJECT_DIRECTORY + "_base_update_project.sql");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_query_monetary.sql", ServiceDefs.PROJECT_DIRECTORY + "/data/act/data_mt_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_query_stat.sql", ServiceDefs.PROJECT_DIRECTORY + "/data/act/data_st_ap" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".txt");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_adm.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_adm" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_fte.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_fte" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_hct.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_hct" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_hrs.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_hrs" + ServiceDefs.CURRENT_PERIOD + "_" + ServiceDefs.CURRENT_YEAR + ".json");
	}
	
	public void extractCurrentMonthIncremental() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute(ServiceDefs.PROJECT_DIRECTORY + "_base_table_truncate.sql");
		hypusr.update(ServiceDefs.PROJECT_DIRECTORY + "_base_table_insert.sql", new JsonArray().add(ServiceDefs.CURRENT_PERIOD).add(ServiceDefs.CURRENT_YEAR));
		hypusr.update(ServiceDefs.PROJECT_DIRECTORY + "_base_update_project.sql");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_query_monetary.sql", ServiceDefs.PROJECT_DIRECTORY + "/gldata/act/data_mt_ap4_2018.txt");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_query_stat.sql", ServiceDefs.PROJECT_DIRECTORY + "/gldata/act/data_st_ap4_2018.txt");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_adm.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_adm.json");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_fte.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_fte.json");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_hct.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_hct.json");
		hypusr.queryBlocking(ServiceDefs.PROJECT_DIRECTORY + "_base_balance_hrs.sql", ServiceDefs.PROJECT_DIRECTORY + "/balances/balance_hrs.json");
	}
	
}
