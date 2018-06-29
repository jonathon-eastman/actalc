package com.antm.fdsm.caas.actadm;

public class Def {

	public final static String CUBE_NAME = "ACTADM";
	public final static String RPTG_NAME = "RPTG-ASO-" + CUBE_NAME;
	public final static String CALC_NAME = "CALC-BSO-" + CUBE_NAME;
	public final static String META_NAME_BSO = "META-BSO-" + CUBE_NAME;
	public final static String META_NAME_ASO = "META-ASO-" + CUBE_NAME;

	public static final String DIR_PROJECT = CUBE_NAME.toLowerCase();
	public static final String DIR_BALANCE = DIR_PROJECT + "/" +"balances";
	public static final String DIR_BKP = DIR_PROJECT + "/" +"bkp";
	public static final String DIR_TMP = DIR_PROJECT +"/" +"tmp";
	public static final String DIR_DATA = DIR_PROJECT +"/" +"data";
	public static final String DIR_HISTORY = DIR_DATA + "/" + "history";
	public static final String DIR_CP = DIR_DATA + "/" + "cp";
	public static final String DIR_EXPORT = DIR_DATA + "/" + "export";
	public static final String DIR_RELATIONAL = DIR_CP + "/" + "relational";
	public static final String DIR_CPHISTORY = DIR_CP + "/" + "history";
	public static final String DIR_NEW = DIR_EXPORT + "/" + "new";
	public static final String DIR_PREVIOUS = DIR_EXPORT + "/" + "previous";
	public static final String DIR_INCREMENTAL = DIR_EXPORT + "/" + "incremental";

	public static final int CP  = 4;
	public static final int CY  = 2018;

}