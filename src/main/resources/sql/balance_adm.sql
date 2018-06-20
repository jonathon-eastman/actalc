SELECT 'ADM', SUM(cloud_actadm.monetary_amount) as "ACC"
FROM cloud_actadm
WHERE ( (cloud_actadm.account LIKE '6%') AND (cloud_actadm.business_unit NOT LIKE 'G8%') AND (cloud_actadm.business_unit NOT LIKE 'E8%')) group by 'ADM'
