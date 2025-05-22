Making a class **immutable** in Java means creating objects that **cannot be changed** after they are created. Immutable classes are especially useful in **multi-threaded environments**, caching, and functional programming.

---

### ✅ Steps to Make a Class Immutable

To make a class immutable, follow these best practices:

| Rule | Description                                                                                  |
| ---- | -------------------------------------------------------------------------------------------- |
| 1️⃣  | Declare the class as `final` (to prevent subclassing)                                        |
| 2️⃣  | Make all fields `private` and `final`                                                        |
| 3️⃣  | Do not provide **setters**                                                                   |
| 4️⃣  | Initialize all fields via a **constructor**                                                  |
| 5️⃣  | If fields are mutable objects (e.g., `List`, `Date`), return **defensive copies** in getters |

---

### 🧪 Example: Immutable `Student` Class

```java
import java.util.*;

public final class Student {
    private final int id;
    private final String name;
    private final List<String> subjects;

    public Student(int id, String name, List<String> subjects) {
        this.id = id;
        this.name = name;
        // Defensive copy to prevent external mutation
        this.subjects = new ArrayList<>(subjects);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        // Return a defensive copy
        return new ArrayList<>(subjects);
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Subjects: " + subjects + ")";
    }
}
```

---

### 🧠 Why Defensive Copy?

If you return the original list (or mutable object), external code could change the internal state of your supposedly "immutable" class. Defensive copies **protect immutability**.

```java
List<String> subjects = new ArrayList<>();
subjects.add("Math");
Student s = new Student(1, "Alice", subjects);

// Trying to modify original list
subjects.add("Science");  // Won't affect internal state of `s`

// Trying to modify via getter
s.getSubjects().add("Physics");  // Still won't affect the original `subjects` list
```

---

### ✅ Benefits of Immutability

* **Thread-safe** (no need for synchronization)
* **Safe to cache**
* **Easier to reason about**
* **HashCode and equals implementations remain stable**

------------------------------------------------------------------------------------------------------------

