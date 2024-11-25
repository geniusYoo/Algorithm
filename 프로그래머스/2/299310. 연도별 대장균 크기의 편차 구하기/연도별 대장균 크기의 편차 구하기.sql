select new.year as YEAR, (new.max - old.size_of_colony) as YEAR_DEV, old.id
from ecoli_data as old
join (
    select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) max
    from ecoli_data
    group by year
) new
on year(old.DIFFERENTIATION_DATE) = new.year
order by YEAR, YEAR_DEV