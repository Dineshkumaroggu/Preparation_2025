
### ❓1. **Can `null` be added to an `ArrayList` in Java?**

✅ **Corrected Question:**
Can `null` be added to an `ArrayList`?

✅ **Answer:**
Yes, `null` can be added to an `ArrayList` in Java. It is allowed and will be treated as a valid element. You can even add multiple `null` values if needed.

Example:

```java
List<String> list = new ArrayList<>();
list.add(null);
list.add("Hello");
System.out.println(list); // [null, Hello]
```

---

### ❓2. **What does REST mean in REST API?**

✅ **Corrected Question:**
What does REST mean in REST API?

✅ **Answer:**
REST stands for **Representational State Transfer**. It is an architectural style for building scalable web services. A RESTful API uses standard HTTP methods (GET, POST, PUT, DELETE) to perform operations on resources, which are usually represented as URLs.

Key principles of REST:

* Stateless communication
* Resource-based URLs
* Use of standard HTTP methods
* Representation in formats like JSON or XML

---

### ❓3. **How to map a list of employees to a map in Java?**

✅ **Corrected Question:**
How do you convert a list of employees to a map in Java?

✅ **Answer:**
You can use Java 8 Streams to convert a `List<Employee>` into a `Map<String, Employee>` (e.g., with the name as key):

```java
Map<String, Employee> map = employeeList.stream()
    .collect(Collectors.toMap(Employee::getName, e -> e));
```

To avoid a conflict if names repeat:

```java
Map<String, Employee> map = employeeList.stream()
    .collect(Collectors.toMap(Employee::getName, e -> e, (e1, e2) -> e1));
```

---

### ❓1. **How do you write test cases for a `void` method in Java?**

✅ **Corrected Question:**
How do you write a test case for a `void` method in Java?

✅ **Answer:**
You write test cases for `void` methods by verifying **side effects**, such as:

* changes to object state
* method calls on mock dependencies
* output printed/logged

If you're using **JUnit + Mockito**, here's an example:

#### ✅ Example: Testing a `void` method that saves data using a repository

```java
public class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void saveUser(User user) {
        repo.save(user); // void method
    }
}
```

#### ✅ Test case using Mockito

```java
@Test
public void testSaveUser() {
    UserRepository mockRepo = mock(UserRepository.class);
    UserService service = new UserService(mockRepo);

    User user = new User("Alice");
    service.saveUser(user);

    verify(mockRepo, times(1)).save(user); // verifies that save() was called once
}
```

---

### ❓2. **How do you create a JPA entity class for SQL in Java?**

✅ **Corrected Question:**
How do you create an entity class for SQL using JPA in Java?

✅ **Answer:**
You use the `@Entity` annotation along with JPA annotations like `@Id`, `@Column`, and `@Table` to map the class to an SQL table.

#### ✅ Example: Basic JPA Entity

```java
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department")
    private String department;

    // Constructors, Getters, Setters
}
```

💡 This class maps to a SQL table called `employees` with `id`, `name`, and `department` columns.


MongoDB does not support traditional SQL-style joins, but you **can perform joins between two collections** using the **`$lookup` aggregation stage**.

---

### ✅ **MongoDB Join Using `$lookup`**

Suppose you have two collections:

1. **`orders`**:

```json
{
  "_id": 1,
  "item": "Laptop",
  "customerId": 101
}
```

2. **`customers`**:

```json
{
  "_id": 101,
  "name": "Alice",
  "city": "Bangalore"
}
```

---

### 🔍 **Join `orders` with `customers`** on `orders.customerId = customers._id`

```javascript
db.orders.aggregate([
  {
    $lookup: {
      from: "customers",           // collection to join
      localField: "customerId",    // field in orders
      foreignField: "_id",         // field in customers
      as: "customerDetails"        // output array field name
    }
  }
])
```

---

### 📝 Output:

```json
{
  "_id": 1,
  "item": "Laptop",
  "customerId": 101,
  "customerDetails": [
    {
      "_id": 101,
      "name": "Alice",
      "city": "Bangalore"
    }
  ]
}
```

---

### 🔁 Optional: Flatten the joined data

If you want to remove the array and flatten the output:

```javascript
db.orders.aggregate([
  {
    $lookup: {
      from: "customers",
      localField: "customerId",
      foreignField: "_id",
      as: "customerDetails"
    }
  },
  { $unwind: "$customerDetails" }
])
```


