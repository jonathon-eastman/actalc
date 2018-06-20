SELECT 'HCT', SUM(actadm_base.statistic_amount) as "ACC"
FROM actadm_base
WHERE ( (actadm_base.account like '953%') AND (actadm_base.business_unit NOT LIKE 'G8%') AND (actadm_base.business_unit NOT LIKE 'E8%')) group by 'HCT'
