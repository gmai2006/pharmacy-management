SELECT
  date_trunc('month', dir_fee_recorded_at) AS month,
  dir_fee_payer_name,
  SUM(dir_fee_amount) AS total_dir_fees
FROM v_dir_fee_summary
GROUP BY month, dir_fee_payer_name
ORDER BY month DESC;