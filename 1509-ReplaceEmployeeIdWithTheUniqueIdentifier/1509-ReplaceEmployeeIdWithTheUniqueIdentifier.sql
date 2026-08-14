-- Last updated: 8/14/2026, 10:04:06 AM
select  COALESCE(eu.unique_id, null) as unique_id ,e.name
from Employees e 
left join EmployeeUNI eu on e.id = eu.id
order by e.name;