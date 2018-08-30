package com.antm.fdsm.caas.actadm2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Def {

	public final static String CUBE_NAME = "ACTADM2";
	public final static String CUBE_NAME_SOURCE = "ACTADM";
	public final static String RPTG_NAME = "RPTG-ASO-" + CUBE_NAME;
	public final static String CALC_NAME = "CALC-BSO-" + CUBE_NAME;
	public final static String META_NAME_BSO = "META-BSO-" +CUBE_NAME_SOURCE;
	public final static String META_NAME_ASO = "META-ASO-" + CUBE_NAME_SOURCE;
	
	public final static String SLACK_WEBHOOK_APP = "/services/TBNP5JXQT/BC27FMF2T/O3Yycwp0lZc8cI5qau1h9RzS";


	public static final String DIR_PROJECT = CUBE_NAME.toLowerCase();
	public static final String DIR_BALANCE = DIR_PROJECT + "/" +"balance";
	public static final String DIR_BKP = DIR_PROJECT + "/" +"bkp";
	public static final String DIR_TMP = DIR_PROJECT +"/" +"tmp";
	public static final String DIR_LOG = DIR_PROJECT + "/" + "log";
	public static final String DIR_DATA = DIR_PROJECT +"/" +"data";
	public static final String DIR_HISTORY = DIR_DATA + "/" + "history";
	public static final String DIR_CP = DIR_DATA + "/" + "cp";
	public static final String DIR_EXPORT = DIR_DATA + "/" + "export";
	public static final String DIR_RELATIONAL = DIR_CP + "/" + "relational";
	public static final String DIR_LAST = DIR_CP + "/" + "last";
	public static final String DIR_CPHISTORY = DIR_CP + "/" + "history";
	public static final String DIR_NEW = DIR_EXPORT + "/" + "new";
	public static final String DIR_PREVIOUS = DIR_EXPORT + "/" + "previous";
	public static final String DIR_INCREMENTAL = DIR_EXPORT + "/" + "incremental";
	public static final List<String> DIRS = Arrays.asList(DIR_PROJECT,DIR_BALANCE,DIR_BKP,DIR_TMP,DIR_DATA,DIR_HISTORY,DIR_CP,DIR_EXPORT,DIR_RELATIONAL,DIR_CPHISTORY,DIR_NEW,DIR_PREVIOUS,DIR_INCREMENTAL, DIR_LAST, DIR_LOG);
	public static final Map<String, String> LINKS = new HashMap<String, String>();
	static {
		LINKS.put("h_" + CUBE_NAME.toLowerCase() + "_ar_17.txt", DIR_HISTORY);
		LINKS.put("h_" + CUBE_NAME.toLowerCase() + "_ar_16.txt", DIR_HISTORY);
		LINKS.put("h_" + CUBE_NAME.toLowerCase() + "_af48_18.txt", DIR_HISTORY);
		LINKS.put("h_" + CUBE_NAME.toLowerCase() + "_wp_18.txt", DIR_HISTORY);
		LINKS.put("h_" + CUBE_NAME.toLowerCase() + "_ar_18.txt", DIR_CPHISTORY);
	};
	public static final int CP  = 7;
	public static final int CY  = 2018;
	
	public static final int VARIANCE_TOLERANCE = 1;

}
