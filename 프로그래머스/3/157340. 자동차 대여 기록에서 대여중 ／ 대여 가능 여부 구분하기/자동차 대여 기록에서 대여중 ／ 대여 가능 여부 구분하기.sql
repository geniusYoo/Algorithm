-- 코드를 입력하세요
select car_id, 
case when max('2022-10-16' between start_date and end_date) = 1 then '대여중'
else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc