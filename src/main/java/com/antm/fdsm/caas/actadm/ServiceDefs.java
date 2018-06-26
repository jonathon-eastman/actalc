package com.antm.fdsm.caas.actadm;

public class ServiceDefs {
	
	public final static String CUBE_NAME = "ACTADM";
	public final static String RPTG_NAME = "RPTG-ASO-" + CUBE_NAME;
	public final static String CALC_NAME = "CALC-BSO-" + CUBE_NAME;
	public final static String META_NAME_BSO = "META-BSO-" + CUBE_NAME;
	public final static String META_NAME_ASO = "META-ASO-" + CUBE_NAME;
	
	public static final String DIRECTORY_PROJECT = CUBE_NAME.toLowerCase();
	public static final String DIRECTORY_HISTORY = "history";
	public static final String DIRECTORY_DATA = "data";
	public static final String DIRECTORY_CURRENTPERIOD = "cp";
	public static final String DIRECTORY_RELATIONAL = "relational";
	
	public static final int CURRENT_PERIOD  = 4;
	public static final int CURRENT_YEAR  = 2018;
	
	public static final String EXPORT_TYPE_BASE = "base";
	public static final String EXPORT_TYPE_INCREMENTAL = "incremental";

}
