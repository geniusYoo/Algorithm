-- 코드를 입력하세요
SELECT b.category, sum(s.sales) as total_sales
from book as b
join (
    select *
    from book_sales 
    where SALES_DATE between '2022-01-01' and '2022-01-31'
) s
on b.book_id = s.book_id
group by b.category
order by b.category

