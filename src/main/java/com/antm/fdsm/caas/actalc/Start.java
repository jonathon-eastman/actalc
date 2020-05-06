package com.antm.fdsm.caas.actalc;

import org.tinylog.Logger;
import com.antm.fdsm.orcl.oac.services.EssbaseOptions;
import com.antm.fdsm.orcl.oac.services.EssbaseService;
import com.antm.fdsm.orcl.odc.services.OracleRelationalOptions;
import com.antm.fdsm.orcl.odc.services.OracleRelationalService;

import io.vertx.core.AbstractVerticle;

public class Start extends AbstractVerticle {

	private final static EssbaseService essbase = new EssbaseService(new EssbaseOptions("actalc").setName(EssbaseService.Name.ESSACT).setLinks(Def.LINKS));
	private final static OracleRelationalService hypfinusrp = new OracleRelationalService(new OracleRelationalOptions("actalc").setName(OracleRelationalService.Name.HYPFINUSRP).setUser(OracleRelationalService.User.JSWH));

	
	public static void main(String[] args) {
		try {
			if( args[0].equals("1")) {
				ServiceFacade.base(essbase,hypfinusrp);
			}
				ServiceFacade.incremental(essbase,hypfinusrp);{
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
