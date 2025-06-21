
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
