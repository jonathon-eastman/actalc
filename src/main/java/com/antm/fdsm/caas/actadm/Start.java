package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.utils.Singleton;

public class Start {
	
	private final static Singleton config = Singleton.INSTANCE.getInstance();
	
	public static void main(String[] args) {
		
		try {
			ServiceFacade.base(config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
