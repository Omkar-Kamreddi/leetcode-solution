-- Last updated: 8/14/2026, 10:03:36 AM
# Write your MySQL query statement below
select tweet_id 
from Tweets
where LENGTH(content) > 15;