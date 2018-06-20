package com.antm.fdsm.caas.actadm;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServiceFacade.incremental();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
