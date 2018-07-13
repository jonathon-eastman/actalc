package com.antm.fdsm.caas.actadm;
import com.antm.fdsm.orcl.utils.Singleton;

import io.vertx.core.AbstractVerticle;

public class Start extends AbstractVerticle {

	private final static Singleton oacActService = Singleton.OACDEV.setDirs(Def.DIRS);
	private final static Singleton dbHypusrService = Singleton.HYPUSR.setDirs(Def.DIRS);

	public static void main(String[] args) {
		try {
			//automatically download wh files.
			//add security.
			//test on server.
			//database service... make consistent.
			//add support for analyze
			//localhost on mac + SSL.
			//error handling.
			//maybe change from runnable to observable
			ServiceFacade.base(oacActService, dbHypusrService);
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
