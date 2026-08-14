-- Last updated: 8/14/2026, 10:03:45 AM
select v.customer_id, count(*) as count_no_trans
from Visits v
left join Transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id
order by v.customer_id;