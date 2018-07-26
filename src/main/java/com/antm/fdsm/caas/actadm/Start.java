package com.antm.fdsm.caas.actadm;
import com.antm.fdsm.orcl.utils.Singleton;
import io.vertx.core.AbstractVerticle;

public class Start extends AbstractVerticle {

	private final static Singleton oacActService = Singleton.OACDEV.setDirs(Def.DIRS).setSlackApp(Def.SLACK_WEBHOOK_APP).setApp(Def.CUBE_NAME);
	private final static Singleton dbHypusrService = Singleton.HYPUSR.setDirs(Def.DIRS).setSlackApp(Def.SLACK_WEBHOOK_APP);

	public static void main(String[] args) {
		try {
			//automatically download wh files.
			//add security.
			//error handling needs improvement.
			//localhost on mac + SSL.
			//maybe change from runnable to observable
			//create archive script.
			//encrypt file.
			//if (args[0].equalsIgnoreCase("base")) {
				ServiceFacade.base(oacActService,dbHypusrService);
			//}
			//else if(args[0].equalsIgnoreCase("incr")) {
			//	ServiceFacade.incremental(oacActService,dbHypusrService);
			//}

			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
