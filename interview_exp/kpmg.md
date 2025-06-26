

### ✅ 1. **`transient` keyword in Java**

* The `transient` keyword is used to **exclude fields from serialization**.
* When an object is serialized (converted to a byte stream), transient fields are **not saved**.
* Useful for sensitive data like passwords or fields that don't need persistence.

```java
class User implements Serializable {
    private String username;
    private transient String password; // will not be serialized
}
```

---

### ✅ 2. **`break` with outer loop (labeled break)**

* Java allows **labeled loops** so you can break out of **nested loops** directly.
* `break outer;` exits the loop labeled `outer`.

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) {
            break outer; // breaks out of both loops
        }
        System.out.println(i + " " + j);
    }
}
```

> Output:
> `0 0`
> Then breaks out completely

---

### ✅ 3. **`LIMIT` and `OFFSET` in SQL**

Used for **pagination** (fetching limited rows):

* **`LIMIT`** → Specifies how many rows to return.
* **`OFFSET`** → Specifies how many rows to skip **before** starting to return rows.

#### 🔹 Example:

```sql
SELECT * FROM employees
ORDER BY id
LIMIT 10 OFFSET 20;
```

> 🔍 Returns **10 rows**, starting **after skipping 20 rows**.


