SELECT 'ADM', SUM(actadm_base.monetary_amount) as "ACC"
FROM actadm_base
WHERE ( (actadm_base.account LIKE '6%') AND (actadm_base.business_unit NOT LIKE 'G8%') AND (actadm_base.business_unit NOT LIKE 'E8%')) group by 'ADM'
