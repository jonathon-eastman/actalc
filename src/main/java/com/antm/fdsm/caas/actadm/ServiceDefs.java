package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;

public class ServiceDefs {
	
	public final static String CUBE_NAME = "ACTADM";
	public final static String RPTG_NAME_PRIMARY = "ACTADM";
	public final static String RPTG_NAME_SECONDARY = "ACTADM2";
	public final static String RPTG_NAME_BASE = "RPTG-ASO-" + CUBE_NAME;
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
	
	public static final String PROJECT_DIRECTORY = CUBE_NAME.toLowerCase();
	public static final String HISTORY_DIRECTORY = "history";
	public static final String HOME_DIRECTORY = AnalyticCloudPlatform.getFileHome();
	
	public static final int CURRENT_PERIOD  = 4;
	public static final int CURRENT_YEAR  = 2018;
	
	
}
