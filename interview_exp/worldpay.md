SELECT employees.name, departments.dept_name
FROM employees
JOIN departments
ON employees.dept_id = departments.dept_id;



Types of Joins You Can Use:
INNER JOIN: Only matching rows (default)

LEFT JOIN: All rows from left table, matched rows from right

RIGHT JOIN: All rows from right table, matched rows from left

FULL OUTER JOIN: All rows from both tables (matched or not) — not supported in some databases like MySQL


--------

