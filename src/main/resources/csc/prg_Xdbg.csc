//ESS_LOCALE English_UnitedStates.Latin1@Binary
SET LOCKBLOCK HIGH;
SET AGGMISSG ON;
SET MSG SUMMARY;
SET CACHE OFF;
SET CALCPARALLEL 8;
SET CALCTASKDIMS 1;

SET DATAEXPORTOPTIONS {
	DataExportLevel "level0";
	DataExportDynamicCalc OFF;
	DataExportDecimal 13;
	DataExportColFormat ON;	DataExportColHeader "Accounts";
	DataExportDimHeader OFF;
	DataExportRelationalFile OFF;
	DataExportOverwriteFile ON;
	DataExportDryRun OFF;
};

FIX (@RELATIVE("WellPoint, Inc. (Cons)", 0), @RELATIVE("Funding Type Total", 0),@RELATIVE("Fixed Pool Total", 0),
     @RELATIVE("Product Total", 0),@RELATIVE("Diversified Business Group", 0),"Admin Exp Alloc", <<CURRENT_PERIOD_ACTUAL>>)

	      DATAEXPORT "File" " " "/u01/js/bkup/cbd/par_Admin_detail_DBG.txt" "#Mi";

ENDFIX