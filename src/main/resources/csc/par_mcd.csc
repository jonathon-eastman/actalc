//ESS_LOCALE English_UnitedStates.Latin1@Binary
SET LOCKBLOCK HIGH;
SET AGGMISSG ON;
SET MSG SUMMARY;
SET CACHE HIGH;
SET CALCPARALLEL 1;
SET CALCTASKDIMS 1;

FIX ( <<CURRENT_PERIOD_ACTUAL>>, "90",
        @RELATIVE ("Fixed Pool Total", 0),
        @RELATIVE ("WellPoint, Inc. (Cons)", 0), @RELATIVE ("Product Total", 0),
        "SSCOZZ","SSARZZ","SSMNZZ","SSHNNY","SSTXST","SSSCZZ","SSNCZZ"   )

FIX ("2700000100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("3000003600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("3000094100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("3000094200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("3522202400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("3522202500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("3544101300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("3544401300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("4073101200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0800000000;
ENDFIX
 
FIX ("4330010400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330011700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330011800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330013100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330013200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330013300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330013500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330013600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4330013700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8450000000;
ENDFIX
 
FIX ("4332190000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4332200100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4332220000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4332230500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2900000000;
ENDFIX
 
FIX ("4332231500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4332232000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9048168682;
ENDFIX
 
FIX ("4365017700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0347066466;
ENDFIX
 
FIX ("4365048600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8650000000;
ENDFIX
 
FIX ("4365180800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4501000400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("4501000800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4501001200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3920000000;
ENDFIX
 
FIX ("4501001700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8420221975;
ENDFIX
 
FIX ("4504301000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0110000000;
ENDFIX
 
FIX ("4812300300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6722000000;
ENDFIX
 
FIX ("4814200000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4814500000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4840450000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("4870400000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5100048000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5100115700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("5100115800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8601703681;
ENDFIX
 
FIX ("5100178000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8240000000;
ENDFIX
 
FIX ("5140612200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5140612300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2956386521;
ENDFIX
 
FIX ("5310154000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("5360026200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5360029800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5360034600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8601703681;
ENDFIX
 
FIX ("5360054500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5360060300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5360079400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5360105100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("5360113000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5360116500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5360980100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5360980200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6700000000;
ENDFIX
 
FIX ("5360987600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5360987800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6864000000;
ENDFIX
 
FIX ("5500011600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8716021495;
ENDFIX
 
FIX ("5500023500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500041600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500042200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500060200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8864883450;
ENDFIX
 
FIX ("5500060900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500061600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("5500062900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7950000000;
ENDFIX
 
FIX ("5500080800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0610000000;
ENDFIX
 
FIX ("5500104800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5500106400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9314225242;
ENDFIX
 
FIX ("5500139800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500151400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1350000000;
ENDFIX
 
FIX ("5500161000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500161600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500201100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("5500230100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2268228160;
ENDFIX
 
FIX ("5500257200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1240000000;
ENDFIX
 
FIX ("5500347300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0930000000;
ENDFIX
 
FIX ("5500350300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6560000000;
ENDFIX
 
FIX ("5500350800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500369200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1322032025;
ENDFIX
 
FIX ("5500429700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500433900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0390000000;
ENDFIX
 
FIX ("5500436700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0130000000;
ENDFIX
 
FIX ("5500481100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500484500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500484600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5500507400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5500508400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5500512100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5500526000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5500527400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5500554500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9060000000;
ENDFIX
 
FIX ("5500597800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5501400600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501610200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("5501621800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5501622900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("5501646900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0160000000;
ENDFIX
 
FIX ("5501702100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501885100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9314225242;
ENDFIX
 
FIX ("5501885300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501885700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501885800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501886100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3600000000;
ENDFIX
 
FIX ("5501886200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501886600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501886800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9210000000;
ENDFIX
 
FIX ("5501887100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501887400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5501887500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5502115100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2400000000;
ENDFIX
 
FIX ("5502141100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0830000000;
ENDFIX
 
FIX ("5502141900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0782899133;
ENDFIX
 
FIX ("5570100000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570110000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570120000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8142000000;
ENDFIX
 
FIX ("5570122000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570130000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570130500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570131000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570140000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570150000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570151000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570170500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570171000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570171500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570180000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570181000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570190000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570190500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570191000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570191500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570192500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("5570200400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0279769062;
ENDFIX
 
FIX ("5600000300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8210000000;
ENDFIX
 
FIX ("6030615700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030615800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030619000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030654500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030710200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030712200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030713500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9160000000;
ENDFIX
 
FIX ("6030723900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030725400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1350000000;
ENDFIX
 
FIX ("6030725700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0260000000;
ENDFIX
 
FIX ("6030728000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.5329232224;
ENDFIX
 
FIX ("6030728200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030728700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030728800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030728900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030729000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030729800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7660000000;
ENDFIX
 
FIX ("6030732000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030734200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030734300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8700000000;
ENDFIX
 
FIX ("6030735300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0700000000;
ENDFIX
 
FIX ("6030735400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030735600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030735700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030735800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030737900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030739100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030739500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030739800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030739900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030740200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0607000000;
ENDFIX
 
FIX ("6030740300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3950000000;
ENDFIX
 
FIX ("6030740400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030740500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030740700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3832000000;
ENDFIX
 
FIX ("6030742100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030742300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030742500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030742600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030743000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8812500000;
ENDFIX
 
FIX ("6030743100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030743300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8611111111;
ENDFIX
 
FIX ("6030744900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030745000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030745400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2650000000;
ENDFIX
 
FIX ("6030745500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030746000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1666666667;
ENDFIX
 
FIX ("6030746100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8171875000;
ENDFIX
 
FIX ("6030746200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6030747100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1270000000;
ENDFIX
 
FIX ("6037108100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0729000000;
ENDFIX
 
FIX ("6037108300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037108500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0729000000;
ENDFIX
 
FIX ("6037108900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0729000000;
ENDFIX
 
FIX ("6037110400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0729000000;
ENDFIX
 
FIX ("6037116800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6037123300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9420961067;
ENDFIX
 
FIX ("6037137200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2323294445;
ENDFIX
 
FIX ("6037137300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6037138100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6037140100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0729000000;
ENDFIX
 
FIX ("6037157600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037158000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037158100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037161600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037164700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9770000000;
ENDFIX
 
FIX ("6037175000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037175100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6037190000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4139989934;
ENDFIX
 
FIX ("6090012400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("6090014200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090015600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090016300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0220000000;
ENDFIX
 
FIX ("6090020200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090021500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("6090022500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8601703681;
ENDFIX
 
FIX ("6090023500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090024100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4500000000;
ENDFIX
 
FIX ("6090024300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090024400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8960000000;
ENDFIX
 
FIX ("6090024500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8530000000;
ENDFIX
 
FIX ("6090024700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4660000000;
ENDFIX
 
FIX ("6090024800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8716021495;
ENDFIX
 
FIX ("6090025500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090025600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090025700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090026000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090026300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090026900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090030200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090032500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3200000000;
ENDFIX
 
FIX ("6090032600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090033100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2928570746;
ENDFIX
 
FIX ("6090034000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6090034900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090035000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090035100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090035300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.5329232224;
ENDFIX
 
FIX ("6090038200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6178027010;
ENDFIX
 
FIX ("6090038400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090038500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8610000000;
ENDFIX
 
FIX ("6090039200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4370000000;
ENDFIX
 
FIX ("6090039400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8711138803;
ENDFIX
 
FIX ("6090040400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7131849315;
ENDFIX
 
FIX ("6090040500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9550000000;
ENDFIX
 
FIX ("6090044700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090044800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090045000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090045100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090045200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090045300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1390000000;
ENDFIX
 
FIX ("6090046600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090050200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090050400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.5985000000;
ENDFIX
 
FIX ("6090050500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9010000000;
ENDFIX
 
FIX ("6090050900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090051000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4198201439;
ENDFIX
 
FIX ("6090051500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7960000000;
ENDFIX
 
FIX ("6090053600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090053900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090055900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8934631376;
ENDFIX
 
FIX ("6090056000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090056200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9434852053;
ENDFIX
 
FIX ("6090056400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090056900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090057000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090057200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1391000000;
ENDFIX
 
FIX ("6090057500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1391000000;
ENDFIX
 
FIX ("6090057600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090058800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090059500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1040000000;
ENDFIX
 
FIX ("6090062600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8410836830;
ENDFIX
 
FIX ("6090062700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9245380983;
ENDFIX
 
FIX ("6090062800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090062900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8068472805;
ENDFIX
 
FIX ("6090063000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090063100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8778461567;
ENDFIX
 
FIX ("6090063200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090063300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6055897450;
ENDFIX
 
FIX ("6090063400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090063500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8155586599;
ENDFIX
 
FIX ("6090063600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090063700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8155586599;
ENDFIX
 
FIX ("6090063800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090063900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9311361859;
ENDFIX
 
FIX ("6090064000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090064100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9311361859;
ENDFIX
 
FIX ("6090064200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090064300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8601703681;
ENDFIX
 
FIX ("6090064400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090064500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8422790116;
ENDFIX
 
FIX ("6090064600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090064700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9048168682;
ENDFIX
 
FIX ("6090064800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090064900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7326218724;
ENDFIX
 
FIX ("6090065000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090065100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8677522110;
ENDFIX
 
FIX ("6090065200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090065300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6446253685;
ENDFIX
 
FIX ("6090065400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090065500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8528752524;
ENDFIX
 
FIX ("6090065600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090065700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090065800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090065900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8466993795;
ENDFIX
 
FIX ("6090066000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090066100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7308374224;
ENDFIX
 
FIX ("6090066200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090066300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8355687891;
ENDFIX
 
FIX ("6090066400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090066500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7511177279;
ENDFIX
 
FIX ("6090066600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090066700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8243315330;
ENDFIX
 
FIX ("6090066800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090067000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090067100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7989373422;
ENDFIX
 
FIX ("6090067200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090067300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7867486104;
ENDFIX
 
FIX ("6090067400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090067500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8557061653;
ENDFIX
 
FIX ("6090067600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090067700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6958898120;
ENDFIX
 
FIX ("6090067800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090067900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8116647792;
ENDFIX
 
FIX ("6090068200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4455369911;
ENDFIX
 
FIX ("6090068400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090068500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090069200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090069300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090069400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090069500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090069600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090069700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090070300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090100600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8304000000;
ENDFIX
 
FIX ("6090104100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090104200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090104300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6090104400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6101016600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3113986528;
ENDFIX
 
FIX ("6101016700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6101018200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6102010100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6103015400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8840000000;
ENDFIX
 
FIX ("6103016500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7290000000;
ENDFIX
 
FIX ("6103017100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8528752524;
ENDFIX
 
FIX ("6103017700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6103020200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4000000000;
ENDFIX
 
FIX ("6211620000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211620400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211625000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211631000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211650100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211660100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211670100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6211680100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6212101000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6213101000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9714285714;
ENDFIX
 
FIX ("6214701000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241101000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8595794543;
ENDFIX
 
FIX ("6241201000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241401000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241501000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241520000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241522300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241524000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241525000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241529900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241531000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241540100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241550100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241560100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241570100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6241580100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242001000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242020000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242024000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242025000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242029900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242031000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242040100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242050100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242060100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242280100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7500000000;
ENDFIX
 
FIX ("6242324000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242325000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242329900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242340100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242360100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242420000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242424000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242425000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242429900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242431000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242440100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242460100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242480100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242501000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242622300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6114000000;
ENDFIX
 
FIX ("6242660100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8538461538;
ENDFIX
 
FIX ("6242680100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6666666667;
ENDFIX
 
FIX ("6242720000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3143000000;
ENDFIX
 
FIX ("6242724000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2000000000;
ENDFIX
 
FIX ("6242725000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7000000000;
ENDFIX
 
FIX ("6242729900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1950000000;
ENDFIX
 
FIX ("6242731000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242740100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2176000000;
ENDFIX
 
FIX ("6242750100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2345000000;
ENDFIX
 
FIX ("6242760100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2000000000;
ENDFIX
 
FIX ("6242820000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1850000000;
ENDFIX
 
FIX ("6242824000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2010000000;
ENDFIX
 
FIX ("6242825000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2080000000;
ENDFIX
 
FIX ("6242829900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2660000000;
ENDFIX
 
FIX ("6242840100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2840000000;
ENDFIX
 
FIX ("6242850100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1990000000;
ENDFIX
 
FIX ("6242860100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4180000000;
ENDFIX
 
FIX ("6242870100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2460000000;
ENDFIX
 
FIX ("6242880100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1870000000;
ENDFIX
 
FIX ("6242922300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2216666667;
ENDFIX
 
FIX ("6242929900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242931000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242940100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242960100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6242970100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6243329900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6243340100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7777777778;
ENDFIX
 
FIX ("6243729900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6243731000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6243740100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244001000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244101000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3570000000;
ENDFIX
 
FIX ("6244201000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244301000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244520000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244524000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244529900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8426000000;
ENDFIX
 
FIX ("6244531000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244540100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244550100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9059000000;
ENDFIX
 
FIX ("6244560100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244570100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6244729900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6245001000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0790000000;
ENDFIX
 
FIX ("6271001000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2631619878;
ENDFIX
 
FIX ("6273301000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6273401000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6311593000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3943221967;
ENDFIX
 
FIX ("6311690000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6311692000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6311695000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6311696000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330130000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330270000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330280000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330605000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2460000000;
ENDFIX
 
FIX ("6330610000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330630000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330640000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4750000000;
ENDFIX
 
FIX ("6330650000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330900500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330901400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330901500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330901600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330901700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330902800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330902900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330903000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330903100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330903400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2320000000;
ENDFIX
 
FIX ("6330903500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7447000000;
ENDFIX
 
FIX ("6330904300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330904700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0720000000;
ENDFIX
 
FIX ("6330907300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7790000000;
ENDFIX
 
FIX ("6330907700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330907900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330908000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330908100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2820000000;
ENDFIX
 
FIX ("6330908200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2820000000;
ENDFIX
 
FIX ("6330908300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9101000000;
ENDFIX
 
FIX ("6330908400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330909000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330909100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330909300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330909400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2826215782;
ENDFIX
 
FIX ("6330910000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330910100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330910200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330910300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330910400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330910500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6330911200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6331301700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6331302000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341590000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341591000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341592000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341593000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341594000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341595000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6341596000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342090000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342091000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342092000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342094000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342095000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342096000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342390000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342392000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342492000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342496000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342691000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342692000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6342790000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3394000000;
ENDFIX
 
FIX ("6342791000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0606000000;
ENDFIX
 
FIX ("6342792000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.5886000000;
ENDFIX
 
FIX ("6342794000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1767000000;
ENDFIX
 
FIX ("6342795000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.5486000000;
ENDFIX
 
FIX ("6342796000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1500000000;
ENDFIX
 
FIX ("6342891000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2930000000;
ENDFIX
 
FIX ("6342892000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3210000000;
ENDFIX
 
FIX ("6342894000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2720000000;
ENDFIX
 
FIX ("6342896000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3030000000;
ENDFIX
 
FIX ("6342990000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3214285714;
ENDFIX
 
FIX ("6343390000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6344591000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3690000000;
ENDFIX
 
FIX ("6521500600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521521400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521570900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521571100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521571300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521571500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521571700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6521702200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7030000000;
ENDFIX
 
FIX ("6521702300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.8940000000;
ENDFIX
 
FIX ("6521702400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.7240000000;
ENDFIX
 
FIX ("6521703500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6590101000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590113800")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6590119000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.4588184946;
ENDFIX
 
FIX ("6590180700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590186100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590186900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590187000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590187400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590187500")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590190200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590191300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590195000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590195600")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590195700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590196900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3420000000;
ENDFIX
 
FIX ("6590197700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.9500000000;
ENDFIX
 
FIX ("6590198400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6590198700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.6722000000;
ENDFIX
 
FIX ("6590199000")
          "QI Alloc Exp" = "Admin Exp Alloc" * 1.0000000000;
ENDFIX
 
FIX ("6590210700")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590211200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.1098964701;
ENDFIX
 
FIX ("6590211300")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0909087084;
ENDFIX
 
FIX ("6590211900")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590212200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6590214200")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.0143360523;
ENDFIX
 
FIX ("6590215400")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.2404235202;
ENDFIX
 
FIX ("6599100100")
          "QI Alloc Exp" = "Admin Exp Alloc" * 0.3460098250;
ENDFIX


ENDFIX