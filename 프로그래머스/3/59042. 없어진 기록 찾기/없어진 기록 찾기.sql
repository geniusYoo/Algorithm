-- 코드를 입력하세요
SELECT animal_id, name
from animal_outs outs
where not exists (
    select *
    from animal_ins ins
    where ins.animal_id = outs.animal_id
)