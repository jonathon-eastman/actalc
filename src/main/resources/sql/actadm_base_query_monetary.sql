SELECT CC, CO, PJT, TP, ACC, REPLACE(DTA, -99999999999999999999, 'Data') FROM (SELECT 'Cost Center' as "CC", 'Company' as "CO", 'Project' as "PJT", 'TimePeriods' as "TP", 'Accounts' as "ACC", -99999999999999999999 as "DTA" FROM DUAL
UNION ALL
SELECT deptid as "CC", business_unit as "CO", project_id as "PJT", (CASE accounting_period
  WHEN 1 THEN 'Jan'
  WHEN 2 THEN 'Feb'
  WHEN 3 THEN 'Mar'
  WHEN 4 THEN 'Apr'
  WHEN 5 THEN 'May'
  WHEN 6 THEN 'Jun'
  WHEN 7 THEN 'Jul'
  WHEN 8 THEN 'Aug'
  WHEN 9 THEN 'Sep'
  WHEN 10 THEN 'Oct'
  WHEN 11 THEN 'Nov'
  WHEN 12 THEN 'Dec'
END ) as "TP", account as "ACC", sum(monetary_amount) as "DTA"
FROM actadm_base
WHERE ( (actadm_base.account like '6%') AND (monetary_amount <> 0) )
GROUP BY deptid, business_unit, project_id, accounting_period, account,
(CASE accounting_period WHEN 1 THEN 'Jan' WHEN 2 THEN 'Feb' WHEN 3 THEN 'Mar' WHEN 4 THEN 'Apr' WHEN 5 THEN 'May' WHEN 6 THEN 'Jun' WHEN 7 THEN 'Jul' WHEN 8 THEN 'Aug' WHEN 9 THEN 'Sep' WHEN 10 THEN 'Oct' WHEN 11 THEN 'Nov' WHEN 12 THEN 'Dec' END )
ORDER BY dta)
