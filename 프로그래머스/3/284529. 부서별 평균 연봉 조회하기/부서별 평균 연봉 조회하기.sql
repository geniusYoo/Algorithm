-- 코드를 작성해주세요
select emp.dept_id, dept.DEPT_NAME_EN, emp.AVG_SAL
from HR_DEPARTMENT dept
join (
    select dept_id, round(avg(sal),0) as AVG_SAL
    from HR_EMPLOYEES
    group by dept_id
) emp
on dept.dept_id = emp.dept_id
order by emp.AVG_SAL desc