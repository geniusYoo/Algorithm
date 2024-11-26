# -- 코드를 작성해주세요
with rankings as (
    select id, NTILE(4) OVER (order by size_of_colony desc) as colony_rank
    from ecoli_data
)
select id, 
    (case 
        when colony_rank = 1 then 'CRITICAL'
        when colony_rank = 2 then 'HIGH'
        when colony_rank = 3 then 'MEDIUM'
        else 'LOW'
    end) colony_name
from rankings
order by id

