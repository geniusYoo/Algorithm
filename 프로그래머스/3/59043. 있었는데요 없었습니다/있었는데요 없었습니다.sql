-- 코드를 입력하세요
SELECT outs.animal_id, outs.name
from animal_outs outs
join animal_ins ins
on outs.animal_id = ins.animal_id
where outs.datetime < ins.datetime
order by ins.datetime
