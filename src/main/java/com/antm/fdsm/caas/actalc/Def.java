package com.antm.fdsm.caas.actalc;


import java.util.HashMap;
import com.antm.fdsm.orcl.utils.GlobalOptions;
import com.antm.fdsm.orcl.utils.GlobalPaths;
import com.antm.fdsm.orcl.utils.Helpers;




public class Def {
	
	//project specific static vars.
	public final static int START4_JOB_ID = 1;
	public final static int VARIANCE_TOLERANCE = 1;
	public final static String CUBE_NAME = "ACTALC";
	public final static String CUBE_NAME_SOURCE = "ACTALC";
	public final static String RPTG_NAME = "RPTG-ASO-" + CUBE_NAME;
	public final static String CALC_NAME = "CALC-BSO-" + CUBE_NAME;
	public final static String META_NAME_BSO = "META-BSO-" +CUBE_NAME_SOURCE;
	public final static String META_NAME_ASO = "META-ASO-" + CUBE_NAME_SOURCE;
	public final static String PROJECT_NAME = CUBE_NAME.toLowerCase();
	
	public final static String SLACK_WEBHOOK_APP = "/services/TBNP5JXQT/BCXHTUREG/UaV6MeFMgY4zhonkus9YlLLp";
	
	public final static String BALANCE = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.BALANCE;
	public final static String TMP  = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.TMP;
	public final static String LOG = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.LOG;
	public final static String CONF = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.CONF;
	public final static String TIME = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.TIME;
	public final static String CURRENT = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.CURRENT;
	public final static String BKP = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.BKP;
	public final static String TAR = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.TAR;
	public final static String DATA = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.DATA;
	public final static String SRC = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.SRC;
	public final static String ORACLE = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.ORACLE;
	public final static String SQL = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.SQL;
	public final static String SQL_LATEST = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.SQL_LATEST;
	public final static String SQL_PREVIOUS = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.SQL_PREVIOUS;
	public final static String ESSBASE = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.ESSBASE;
	public final static String EXPORT = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.EXPORT;
	public final static String ESSBASE_LATEST = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.ESSBASE_LATEST;
	public final static String ESSBASE_PREVIOUS = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.ESSBASE_PREVIOUS;
	public final static String ESSBASE_INCREMENTAL = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.ESSBASE_INCREMENTAL;
	public final static String EXCHANGE = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.EXCHANGE;
	public final static String IN = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.IN;
	public final static String FTPIN = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.FTPIN;
	public final static String HISTORY = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.HISTORY;
	public final static String CPHISTORY =GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.CPHISTORY;
	public final static String OUT = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.OUT;
	public final static String FTPOUT = GlobalOptions.HOME + "/" + PROJECT_NAME + "/" + GlobalPaths.FTPOUT;
	public final static int CP  = 3;
	public final static int CY  = 2019;
//	public final static int CP  = Helpers.readJsonObjectFile(GlobalOptions.HOME + "/" + GlobalPaths.CURRENT + "/act.json", GlobalOptions.VERTX_FS).getInteger("cp");
//	public final static int CY  = Helpers.readJsonObjectFile(GlobalOptions.HOME + "/" + GlobalPaths.CURRENT + "/act.json", GlobalOptions.VERTX_FS).getInteger("cy");
	public static final int YR2D = 19;
	

	
	
	// file links
	public static final HashMap<String, String> LINKS = new HashMap<String, String>();

	static {
		LINKS.put(GlobalOptions.HOME + "/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_ar_" + (CY -2 - 2000) + ".txt", HISTORY);
		LINKS.put(GlobalOptions.HOME + "/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_ar_" + (CY -1 -2000) + ".txt", HISTORY);
		LINKS.put(GlobalOptions.HOME + "/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_ar_" + (CY - 2000) + ".txt", CPHISTORY);
		LINKS.put(GlobalOptions.HOME + "/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_af48_" + (CY - 2000) + ".txt", HISTORY);
		LINKS.put(GlobalOptions.HOME + "/wh/h_" + CUBE_NAME_SOURCE.toLowerCase() + "_wp_" + (CY - 2000) + ".txt", HISTORY);
		LINKS.put("/js/" + GlobalPaths.CURRENT + "/" + "act.json", CURRENT);
	};
	
}



