-- 코드를 입력하세요
SELECT PRODUCT_CODE, price * o.amount as sales
from product p
join (
    select product_id, sum(sales_amount) as amount
    from offline_sale
    group by product_id
) o
on p.PRODUCT_ID = o.PRODUCT_ID
group by product_code
order by sales desc, product_code