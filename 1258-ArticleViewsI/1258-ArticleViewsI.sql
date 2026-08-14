-- Last updated: 8/14/2026, 10:04:56 AM
# Write your MySQL query statement below
select distinct author_id as id
from Views where
(author_id = viewer_id)
group by id
order by id;