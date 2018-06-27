package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class Start {

	private final static Singleton oacActService = Singleton.OACDEV;

	public static void main(String[] args) {
		
		try {
			ServiceFacade.incremental(oacActService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
