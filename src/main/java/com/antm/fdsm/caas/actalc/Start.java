package com.antm.fdsm.caas.actalc;

import org.pmw.tinylog.Logger;
import com.antm.fdsm.orcl.odc.services.HYPUSR;
import com.antm.fdsm.orcl.odc.services.OracleOptions;
import com.antm.fdsm.orcl.odc.services.OracleService;
import com.antm.fdsm.orcl.oac.services.EssbaseAnalyticsOptions;
import com.antm.fdsm.orcl.oac.services.EssbaseAnalyticsService;
import com.antm.fdsm.orcl.oac.services.OACACT;
import com.antm.fdsm.orcl.utils.GlobalOptions;

import io.vertx.core.AbstractVerticle;

public class Start extends AbstractVerticle {

	private final static EssbaseAnalyticsService essbase = OACACT.configure(new EssbaseAnalyticsOptions().setName(Def.PROJECT_NAME).setHome(GlobalOptions.HOME).setSlack(Def.SLACK_WEBHOOK_APP).setLinks(Def.LINKS));
	private final static OracleService hypusr = HYPUSR.configure(new OracleOptions().setName(Def.PROJECT_NAME).setHome(GlobalOptions.HOME));

	
	public static void main(String[] args) {
		try {
			if( args[0].equals("1")) {
				ServiceFacade.base(essbase,hypusr);
			}
				ServiceFacade.incremental(essbase,hypusr);{
			}
			System.exit(0);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.error("bubbled up error to main method. [{}].", e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}

	}

}
