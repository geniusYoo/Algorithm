select month(start_date) as MONTH , car_id, COUNT(CAR_ID) AS RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date >= '2022-08-01' and start_date <= '2022-10-31' and car_id IN (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date >= '2022-08-01' and start_date <= '2022-10-31'
    group by car_id
    having count(*) >= 5
)
group by car_id, MONTH
order by MONTH, car_id desc