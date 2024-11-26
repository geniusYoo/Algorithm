-- 코드를 입력하세요
select INGREDIENT_TYPE, sum(TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF f
join ICECREAM_INFO i
on f.flavor = i.flavor
group by INGREDIENT_TYPE