-- Last updated: 8/14/2026, 10:05:11 AM
select p.product_name,s.year,s.price
from Sales s
join Product p on s.product_id = p.product_id;