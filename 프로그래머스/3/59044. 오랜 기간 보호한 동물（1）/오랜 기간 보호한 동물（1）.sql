-- 코드를 입력하세요
SELECT name, datetime
from animal_ins ins
where not exists (
    select *
    from animal_outs outs
    where ins.ANIMAL_ID = outs.ANIMAL_ID
)
order by ins.datetime
limit 3
