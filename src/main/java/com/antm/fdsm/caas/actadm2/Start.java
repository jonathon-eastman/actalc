package com.antm.fdsm.caas.actadm2;

import org.pmw.tinylog.Logger;

import com.antm.fdsm.orcl.utils.Singleton;
import io.vertx.core.AbstractVerticle;

public class Start extends AbstractVerticle {

	private final static Singleton oacActService = Singleton.OACDEV.setDirs(Def.DIRS).setSlackApp(Def.SLACK_WEBHOOK_APP).setApp(Def.CUBE_NAME).print();
	private final static Singleton dbHypusrService = Singleton.HYPUSR.setDirs(Def.DIRS).setSlackApp(Def.SLACK_WEBHOOK_APP).print();

	public static void main(String[] args) {
		try {
			if( args[0].equals("1")) {
				ServiceFacade.base(oacActService,dbHypusrService);
			}
			else if ( args[0].equals("2")) {
				ServiceFacade.incremental(oacActService,dbHypusrService);
			}
			System.exit(0);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.error("bubbled up error to main method. [{}].", e.getMessage());
		}
		
	}

}
