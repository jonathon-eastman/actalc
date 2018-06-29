package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class Start {

	private final static Singleton oacActService = Singleton.OACDEV.setDirs(Def.DIRS);

	public static void main(String[] args) {
		try {
			//automatically handle backups with exports.
			//remove zero function.
			ServiceFacade.incremental(oacActService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
