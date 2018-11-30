scp oracle@va10p30024.wellpoint.com:/u01/js/prod/repo/act/PALCA1/PALCA1/*.csc ./
mv par_dtl1.csc allocate_region1.csc
mv par_dtl2.csc allocate_region2.csc
mv par_dtl3.csc allocate_region3.csc
mv par_dtl4.csc allocate_region4.csc
mv par_dtl5.csc allocate_region5.csc
mv par_dtl6.csc allocate_region6.csc
rm prg_E*.csc
rm par_ClrA.csc
rm par_qi.csc
# Change sub var in csc files
csc_files=`ls ./*.csc`
csc_files=( $csc_files )
for csc_file in ${csc_files[*]}
do
  mod_csc_file=${csc_file}.mod
  perl -p -e 's/&cur_per_a/<<CURRENT_PERIOD_ACTUAL>>/gi' <$csc_file > $mod_csc_file
  mv $mod_csc_file $csc_file
done