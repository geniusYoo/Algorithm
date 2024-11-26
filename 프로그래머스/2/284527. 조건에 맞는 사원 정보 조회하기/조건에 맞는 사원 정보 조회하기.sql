-- 코드를 작성해주세요

select sum(gd.score) as score, gd.emp_no, emp.emp_name, emp.position, emp.email
from hr_grade gd
join hr_employees emp on emp.emp_no = gd.emp_no
join hr_department dep on dep.dept_id = emp.dept_id
group by gd.emp_no
order by score desc
limit 1

