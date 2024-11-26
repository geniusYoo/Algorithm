-- 코드를 입력하세요
SELECT b.FOOD_TYPE, REST_ID	,REST_NAME	,b.FAVORITES
from rest_info a
join (
    select food_type, max(FAVORITES) as FAVORITES
    from rest_info
    group by food_type
) b
on a.food_type = b.food_type and a.FAVORITES = b.FAVORITES
group by b.FOOD_TYPE
order by FOOD_TYPE desc