-- 코드를 입력하세요
SELECT car_type, count(car_type) CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS like '%통풍시트%' or OPTIONS like '%열선시트%' or OPTIONS like '%가죽시%트%'
group by car_type
order by car_type
