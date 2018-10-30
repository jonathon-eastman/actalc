//ESS_LOCALE English_UnitedStates.Latin1@Binary
SET LOCKBLOCK HIGH;
SET AGGMISSG ON;
SET MSG SUMMARY;
SET CACHE OFF;
SET CALCPARALLEL 1;
SET CALCTASKDIMS 1;




FIX ( @RELATIVE("Alloc_1",0), @RELATIVE("MBU Total" ,0),@RELATIVE("Funding Type Total" ,0),@RELATIVE("Product Total" ,0),@RELATIVE("Anthem, Inc. (Cons)" ,0),
		@RELATIVE("Fixed Pool Total",0), &CUR_PER_A)

		"Admin Exp Alloc" =
					"Admin Exp Alloc"->"GDDDD"->"MUDDDD"->"PRDDD"->"DD"->"F00"
					* ("Driver Detail"
							/"Driver Total"->"GDDDD"->"MUDDDD"->"PRDDD"->"DD"->"F00");

ENDFIX