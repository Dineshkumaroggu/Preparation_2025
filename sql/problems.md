To write an SQL query that selects `name`, `marks`, and an additional column called `grade` based on whether `marks > 25`, you can use a `CASE` statement.

### ✅ SQL Query:

```sql
SELECT 
    name, 
    marks,
    CASE 
        WHEN marks > 25 THEN 'A'
        ELSE 'B'
    END AS grade
FROM your_table;
```

### 🔍 Example Input Table (`your_table`):

| name | marks |
| ---- | ----- |
| John | 12    |
| Mike | 20    |
| Sam  | 30    |
| Rita | 350   |

### 📌 Output:

| name | marks | grade |
| ---- | ----- | ----- |
| John | 12    | B     |
| Mike | 20    | B     |
| Sam  | 30    | A     |
| Rita | 350   | A     |

