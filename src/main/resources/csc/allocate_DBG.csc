//ESS_LOCALE English_UnitedStates.Latin1@Binary
SET LOCKBLOCK HIGH;
SET AGGMISSG ON;
SET MSG SUMMARY;
SET CACHE OFF;
SET CALCPARALLEL 1;
SET CALCTASKDIMS 1;




FIX (@RELATIVE("WellPoint, Inc. (Cons)", 0), @RELATIVE("Funding Type Total", 0),@RELATIVE("Fixed Pool Total", 0),
      @RELATIVE("Product Total", 0),@RELATIVE("Diversified Business Group", 0),"Admin Exp Alloc", <<CURRENT_PERIOD_ACTUAL>>)


ENDFIX