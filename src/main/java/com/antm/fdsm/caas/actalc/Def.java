package com.antm.fdsm.caas.actalc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Def {

	public final static String CUBE_NAME = "ACTALC";
	public final static String CUBE_NAME_SOURCE = "ACTALC";
	public final static String RPTG_NAME = "RPTG-ASO-" + CUBE_NAME;
	public final static String CALC_NAME = "CALC-BSO-" + CUBE_NAME;
	public final static String META_NAME_BSO = "META-BSO-" +CUBE_NAME_SOURCE;
	public final static String META_NAME_ASO = "META-ASO-" + CUBE_NAME_SOURCE;

	public final static String SLACK_WEBHOOK_APP = "/services/TBNP5JXQT/BCXHTUREG/UaV6MeFMgY4zhonkus9YlLLp";


	public static final String DIR_PROJECT = CUBE_NAME.toLowerCase();
	public static final String DIR_BALANCE = DIR_PROJECT + "/" +"balance";
	public static final String DIR_BKP = DIR_PROJECT + "/" +"bkp";
	public static final String DIR_TMP = DIR_PROJECT +"/" +"tmp";
	public static final String DIR_LOG = DIR_PROJECT + "/" + "log";
	public static final String DIR_DATA = DIR_PROJECT +"/" +"data";
	public static final String DIR_HISTORY = DIR_DATA + "/" + "history";
	public static final String DIR_CP = DIR_DATA + "/" + "cp";
	public static final String DIR_MDX = DIR_DATA + "/" + "mdx";
	public static final String DIR_EXPORT = DIR_DATA + "/" + "export";
	public static final String DIR_RELATIONAL = DIR_CP + "/" + "relational";
	public static final String DIR_LAST = DIR_CP + "/" + "last";
	public static final String DIR_CPHISTORY = DIR_CP + "/" + "history";
	public static final String DIR_NEW = DIR_EXPORT + "/" + "new";
	public static final String DIR_PREVIOUS = DIR_EXPORT + "/" + "previous";
	public static final String DIR_INCREMENTAL = DIR_EXPORT + "/" + "incremental";
	public static final String DIR_REQUIRED = DIR_EXPORT + "/" + "required";
	public static final String DIR_INPUT = DIR_EXPORT + "/" + "input";
	public static final String DIR_UNIQUE = DIR_DATA + "/" + "unique";
	public static final String DIR_OPTION = DIR_PROJECT + "/" + "option";
	public static final List<String> DIRS = Arrays.asList(DIR_PROJECT,DIR_BALANCE,DIR_BKP,DIR_TMP,DIR_DATA,DIR_HISTORY,DIR_CP,DIR_EXPORT,DIR_RELATIONAL,DIR_CPHISTORY,DIR_NEW,DIR_PREVIOUS,DIR_INCREMENTAL, DIR_LAST, DIR_LOG, DIR_MDX, DIR_REQUIRED, DIR_INPUT, DIR_UNIQUE, DIR_OPTION);
	public static final Map<String, String> LINKS = new HashMap<String, String>();
	
	public static final int CP  = 2;
	public static final int CY  = 2019;
	public static final int YR2D = 19;
	public static final int YR2DS1 = 18;
	public static final int YR2DS2 = 17;
	
	static {
		LINKS.put("/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_ar_" + YR2DS1 + ".txt", DIR_HISTORY);
		LINKS.put("/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_ar_" + YR2DS2 + ".txt", DIR_HISTORY);
		LINKS.put("/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_af48_" + YR2D + ".txt", DIR_HISTORY);
		LINKS.put("/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_wp_" + YR2D + ".txt", DIR_HISTORY);
		LINKS.put("/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_ar_" + YR2D + ".txt", DIR_CPHISTORY);
		LINKS.put("/tstalc/data/export/required/" + CUBE_NAME_SOURCE.toLowerCase() + "_r1.txt", DIR_INPUT);
	};

	public static final int VARIANCE_TOLERANCE = 1;

}
