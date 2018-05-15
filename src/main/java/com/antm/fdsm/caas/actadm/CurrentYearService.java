package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.odc.DatabaseServiceList.Database;

import io.vertx.core.json.JsonArray;


public class CurrentYearService {
	
	public static void main(String [] args) {
		CurrentYearService.run();
	}

	public static void run() {
		DatabaseService hypusr = new DatabaseService(Database.HYPUSR);
		hypusr.execute("actadm_base_table_truncate.sql");
		hypusr.update("actadm_base_table_insert.sql", new JsonArray().add(4).add(2018));
		hypusr.update("actadm_base_update_project.sql");
		hypusr.queryBlocking("actadm_base_query_monetary.sql", "actadm/data_mt_ap4_2018.txt");
		hypusr.queryBlocking("actadm_base_query_stat.sql", "actadm/data_st_ap4_2018.txt");
		hypusr.queryBlocking("actadm_base_balance_adm.sql", "actadm/balance_adm.json");
		hypusr.queryBlocking("actadm_base_balance_fte.sql", "actadm/balance_fte.json");
		hypusr.queryBlocking("actadm_base_balance_hct.sql", "actadm/balance_hct.json");
		hypusr.queryBlocking("actadm_base_balance_hrs.sql", "actadm/balance_hrs.json");
	}

}
