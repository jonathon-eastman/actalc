package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class Start {

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
			ServiceFacade.incremental(oacActService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
