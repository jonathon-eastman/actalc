SELECT CC, CO, PJT, TP, ACC, REPLACE(DTA, -99999999999999999999, 'Actual') FROM (
    SELECT 'Cost Center' as "CC", 'Company' as "CO", 'Project' as "PJT", 'Time Periods' as "TP", 'Accounts' as "ACC", -99999999999999999999 as "DTA" FROM DUAL
    UNION ALL
    SELECT HYP.deptid as "CC", HYP.business_unit as "CO", HYP.project_id as "PJT", (CASE HYP.accounting_period
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
        END ) as "TP", PS.WP_HYP_ACCT as "ACC", sum(HYP.statistic_amount) as "DTA"
    FROM cloud_actadm HYP
    LEFT JOIN (select WP_HYP_ACCT, WP_PSFT_ACCT FROM sysadm.ps_wp_psfthyp_acct@PS_TABLE_LINK GROUP BY WP_HYP_ACCT, WP_PSFT_ACCT) PS
    ON HYP.account = PS.WP_PSFT_ACCT
    WHERE  (((HYP.account like '953%') OR (HYP.account like '952%') OR (HYP.account like '951%')))
    GROUP BY HYP.deptid, HYP.business_unit, HYP.project_id, (CASE HYP.accounting_period WHEN 1 THEN 'Jan' WHEN 2 THEN 'Feb' WHEN 3 THEN 'Mar' WHEN 4 THEN 'Apr' WHEN 5 THEN 'May' WHEN 6 THEN 'Jun' WHEN 7 THEN 'Jul' WHEN 8 THEN 'Aug' WHEN 9 THEN 'Sep' WHEN 10 THEN 'Oct' WHEN 11 THEN 'Nov' WHEN 12 THEN 'Dec' END ), PS.WP_HYP_ACCT

)
WHERE (dta <> 0)
ORDER BY dta
