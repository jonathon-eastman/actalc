package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;

public class ServiceDefs {
	
	public final static String CUBE_NAME = "ACTADM";
	public final static String RPTG_NAME_PRIMARY = "ACTADM";
	public final static String RPTG_NAME_SECONDARY = "ACTADM2";
	public final static String RPTG_NAME_ASO_01 = "RPTG-ASO-" + CUBE_NAME;
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
	public static final String DIRECTORY_HOME = AnalyticCloudPlatform.getFileHome();
	public static final String DIRECTORY_DATA = "data";
	public static final String DIRECTORY_BASE = "b1";
	public static final String DIRECTORY_INCR = "i1";
	
	public static final int CURRENT_PERIOD  = 4;
	public static final int CURRENT_YEAR  = 2018;
	
	
}
