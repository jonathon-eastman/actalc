package com.antm.fdsm.caas.actadm;
import com.antm.fdsm.orcl.utils.Singleton;

import io.vertx.core.AbstractVerticle;

public class Start extends AbstractVerticle {

	private final static Singleton oacActService = Singleton.OACDEV.setDirs(Def.DIRS);

	public static void main(String[] args) {
		try {
			//automatically download wh files.
			//aso slices and finalize base process.
			//add slack support + messaging.
			//add security.
			//test on server.
			//database service... make consistent.
			//error handling.
			ServiceFacade.base(oacActService);
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
