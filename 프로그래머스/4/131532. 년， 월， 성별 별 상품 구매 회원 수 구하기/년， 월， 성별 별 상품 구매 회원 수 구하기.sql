-- 코드를 입력하세요
select year(b.sales_date) as YEAR, 
        month(b.sales_date) MONTH, 
        a.GENDER, 
        count(distinct a.user_id) as USERS
from user_info a
join online_sale b
    on a.user_id = b.user_id 
where a.gender is not null
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER