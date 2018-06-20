INSERT INTO cloud_actadm (deptid, business_unit, project_id, accounting_period, account, monetary_amount, statistic_amount) (
  SELECT cc, co, pj, ap, acc, SUM(monetary_amount) AS "MONETARY_AMOUNT", SUM(statistic_amount) AS "STATISTIC_AMOUNT" FROM (
      SELECT sysadm.ps_jrnl_ln.deptid AS "CC", sysadm.ps_jrnl_header.business_unit AS "CO", sysadm.ps_jrnl_ln.project_id as "PJ", sysadm.ps_jrnl_header.accounting_period as "AP", sysadm.ps_jrnl_ln.account AS "ACC", sysadm.ps_jrnl_ln.monetary_amount, sysadm.ps_jrnl_ln.statistic_amount
      FROM sysadm.ps_jrnl_ln@PS_TABLE_LINK INNER JOIN sysadm.ps_jrnl_header@PS_TABLE_LINK ON (sysadm.ps_jrnl_ln.journal_id = sysadm.ps_jrnl_header.journal_id)
      AND (sysadm.ps_jrnl_ln.business_unit = sysadm.ps_jrnl_header.business_unit) AND (sysadm.ps_jrnl_ln.journal_date = sysadm.ps_jrnl_header.journal_date) AND (sysadm.ps_jrnl_ln.unpost_seq = sysadm.ps_jrnl_header.unpost_seq)
      WHERE ( (sysadm.ps_jrnl_ln.ledger ='ACTUALS') AND ( sysadm.ps_jrnl_header.accounting_period = ?) AND (sysadm.ps_jrnl_header.fiscal_year = ? ) AND ((sysadm.ps_jrnl_header.jrnl_hdr_status='P') OR (sysadm.ps_jrnl_header.jrnl_hdr_status='U')) AND ((sysadm.ps_jrnl_ln.account like '6%') OR (sysadm.ps_jrnl_ln.account like '9%')))
  )
  GROUP BY cc, co, pj, ap, acc
)
