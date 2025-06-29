
---

#### ✅ **1. First Snippet**

```java
class A {
    public void m1() {
        System.out.println("A m1");
    }
}

public class B extends A {
    private static String name;

    public static void main(String[] args) {
        A b = new B();
        b.m1();
    }
}
```

🟩 **Output:**

```
A m1
```

---

#### ✅ **2. Second Snippet**

```java
class A {
    public void m1() {
        System.out.println("A m1");
        m2();
    }

    public void m2() {
        System.out.println("A m2");
    }
}

public class B extends A {
    String name;

    @Override
    public void m2() {
        System.out.println("B m2");
    }

    public static void main(String[] args) {
        A b = new B();
        b.m1();
    }
}
```

🟩 **Output:**

```
A m1
B m2
```

---

#### ✅ **3. Third Snippet**

```java
class A {
    public void m1() {
        System.out.println("A m1");
    }
}

public class B extends A {
    private String name;

    public B(String name) {
        this.name = name;
    }

    @Override
    public void m1() {
        System.out.println("B m1");
    }

    public static void main(String[] args) {
        B b = new B("Sumit");
        b.m1();
    }
}
```

🟩 **Output:**

```
B m1
```

---

### ✅ **Immutability Example — Employee Class**

#### 🔴 Problem in Your Code:

```java
pravite String name,
```

* Typo: `private`, not `pravite`
* `doj` should be final or deeply immutable.
* `super()` usage is wrong
* Cannot assign to `super()` that way.

---

#### ✅ Corrected Immutable `Employee` Class

```java
import java.util.Date;

public final class Employee {
    private final String name;
    private final Date doj;

    public Employee(String name, Date doj) {
        this.name = name;
        this.doj = new Date(doj.getTime()); // defensive copy
    }

    public String getName() {
        return name;
    }

    public Date getDoj() {
        return new Date(doj.getTime()); // defensive copy
    }
}
```

* `final` class: prevents subclassing
* fields are `private final`
* no setters
* **defensive copies** used for mutable fields (`Date`)

---

### 🟡 What if `Employee` is NOT `final`?

If class is not marked `final`, someone can **extend** and potentially **mutate internal state** (e.g., via reflection, or new fields).

#### ✅ Example of Bad Subclassing (Anti-pattern):

```java
public class EmployeeDetails extends Employee {
    public EmployeeDetails(String name, Date doj) {
        super(name, doj);
    }

    // Someone could try to add mutable state here and break immutability
}
```

➡️ This **breaks immutability** since subclass can add mutable fields and methods.

---

### ✅ Best Practice to Make Class Immutable

1. Make class `final`
2. All fields `private final`
3. No setters
4. Deep copies for mutable fields (`Date`, `List`, etc.)
5. Return copies (not internal references)

---

### ✅ Main Class Example:

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("30-06-2025");

        Employee employee = new Employee("Dinesh", date);

        System.out.println(employee.getName());         // Dinesh
        System.out.println(employee.getDoj());          // Mon Jun 30 00:00:00 IST 2025
    }
}
```

---
