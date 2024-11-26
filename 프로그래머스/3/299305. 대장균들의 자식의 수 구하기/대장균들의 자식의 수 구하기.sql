-- 코드를 작성해주세요
with all_datas as (
    select id
    from ecoli_data
)

select ab.id, count(ed.parent_id) as CHILD_COUNT
from all_datas ab
left join ecoli_data ed
on ab.id = ed.parent_id
group by ab.id, ed.parent_id
order by ab.id