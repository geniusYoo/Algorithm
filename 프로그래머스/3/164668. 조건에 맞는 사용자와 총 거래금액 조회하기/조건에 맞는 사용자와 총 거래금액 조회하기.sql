-- 코드를 입력하세요
SELECT b.user_id, b.nickname, sum(a.price) as TOTAL_SALES
from USED_GOODS_USER b
join (
    select *
    from USED_GOODS_BOARD
    where status = 'DONE'
) a
on a.writer_id = b.user_id
group by a.writer_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES 
