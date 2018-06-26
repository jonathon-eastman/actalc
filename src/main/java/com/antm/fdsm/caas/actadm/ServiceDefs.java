package com.antm.fdsm.caas.actadm;

public class ServiceDefs {
	
	public final static String CUBE_NAME = "ACTADM";
	public final static String RPTG_NAME_PRIMARY = "ACTADM";
	public final static String RPTG_NAME_SECONDARY = "ACTADM2";
	public final static String RPTG_NAME_ASO_01 = "RPTG-ASO01-" + CUBE_NAME;
	public final static String CALC_NAME_BSO_01 = "CALC-BSO01-" + CUBE_NAME;
	public final static String CALC_NAME_BSO_02 = "";
	public final static String CALC_NAME_BSO_03 = "";
	public final static String CALC_NAME_ASO_01= "";
	public final static String CALC_NAME_ASO_02 = "";
	public final static String CALC_NAME_ASO_03 = "";
	public final static String META_NAME_BSO_01 = "META-BSO01-" + CUBE_NAME;
	public final static String META_NAME_BSO_02 = "";
	public final static String META_NAME_BSO_03 = "";
	public final static String META_NAME_ASO_01 = "META-ASO01-" + CUBE_NAME;
	
	public static final String DIRECTORY_PROJECT = CUBE_NAME.toLowerCase();
	public static final String DIRECTORY_HISTORY = "history";
	public static final String DIRECTORY_DATA = "data";
	public static final String DIRECTORY_CURRENTPERIOD = "cp";
	public static final String DIRECTORY_RELATIONAL = "relational";
	
	public static final String OAC_SERVER_PRD = "fdsm-prd-act.anthem.com";
	public static final String OAC_SERVER_DEV = "fdsm-dev-oac01.anthem.com";
	public static final String OAC_SERVER_TST = "fdsm-tst-oac01.anthem.com";
	
	public static final int CURRENT_PERIOD  = 4;
	public static final int CURRENT_YEAR  = 2018;
	
	public static final String EXPORT_TYPE_BASE = "base";
	public static final String EXPORT_TYPE_INCREMENTAL = "incremental";
	
	
}
