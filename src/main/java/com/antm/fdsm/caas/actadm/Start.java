package com.antm.fdsm.caas.actadm;
import java.util.List;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.odc.DatabaseService;
import com.antm.fdsm.orcl.utils.Helpers;
import com.antm.fdsm.orcl.utils.Singleton;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;

public class Start extends AbstractVerticle {

	private final static Singleton oacActService = Singleton.OACDEV.setDirs(Def.DIRS).setSlackApp(Def.SLACK_WEBHOOK_APP).setApp(Def.CUBE_NAME);
	private final static Singleton dbHypusrService = Singleton.HYPUSR.setDirs(Def.DIRS).setSlackApp(Def.SLACK_WEBHOOK_APP);

	public static void main(String[] args) {
		try {
			//automatically download wh files.
			//error handling needs improvement.
			//localhost on mac + SSL.
			//maybe change from runnable to observable
			//create archive script.
			//encrypt file.
			//attach to fdsmstart.
			//if (args[0].equalsIgnoreCase("base")) {
			
			int num = Helpers.numberOfRunningProcesses(".*" + Def.CUBE_NAME.toLowerCase() + "-[0-9]\\.[0-9]\\.[0-9]*\\.jar.*");
			if ( num == -1) {
				Logger.error("something crazy going on.");
				System.exit(0);
			} 
			else if ( num == 1) {
				Logger.info("one job is running including this process.  So its ok to go ahead and run.");
				DatabaseService hypusr = new DatabaseService(dbHypusrService);
				
				//jobid actadm 74
				JsonArray ja = new JsonArray().add(74);
				List<JsonArray> record = hypusr.queryFromStringWithParams(
						"SELECT state, state_config\n" + 
						"FROM start_fact \n" + 
						"WHERE (job_id = ?)\n" + 
						"GROUP BY state, state_config", ja );
				if( record.get(0).getInteger(0) == 1) {
					if( record.get(0).getInteger(1) == 2) {
						Logger.info("running base.");
						ServiceFacade.base(oacActService,dbHypusrService);
					}
					else if ( record.get(0).getInteger(1) == 1) {
						Logger.info("running base.");
						ServiceFacade.incremental(oacActService,dbHypusrService);
					}
				}
				else {
					Logger.info("nothting to run here.");
				}
				System.exit(0);
			}
			else {
				Logger.info("already running, no need to run.");
				System.exit(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
