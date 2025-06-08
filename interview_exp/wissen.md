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

Can we make class as static ..?

In Java, yes, you can declare a class as static, but only if it is a nested class

------------------------------------------------------------------------------------------------------------
To find a file recursively in a directory (like `firelcty`, assuming it's a directory), use the `find` command in Linux:

```bash
find firelcty -type f -name "filename"
```

### Explanation:

* `firelcty`: the directory to search in
* `-type f`: search for regular files
* `-name "filename"`: match files with the exact name (replace `"filename"` with the actual name)

### Examples:

1. Find a file named `config.json`:

   ```bash
   find firelcty -type f -name "config.json"
   ```

2. Case-insensitive search:

   ```bash
   find firelcty -type f -iname "config.json"
   ```

3. Find all `.txt` files:

   ```bash
   find firelcty -type f -name "*.txt"
   ```

In Linux, `chmod 475` sets specific **permissions** on a file. To understand it, we need to break down what `475` means in the context of `chmod`.

### 🔧 Breakdown of `chmod 475`

`chmod 475` is **octal notation**, and it actually implies:

```
4   → Special bit (SetUID)
7   → Owner: read (4) + write (2) + execute (1) = 7
5   → Group: read (4) + execute (1) = 5
```

So:

| Octal                                                 | Who     | Meaning                           |
| ----------------------------------------------------- | ------- | --------------------------------- |
| `4`                                                   | Special | SetUID                            |
| `7`                                                   | Owner   | Read, write, and execute          |
| `5`                                                   | Group   | Read and execute                  |
| (no digit shown, so others have default 0 or inherit) | Others  | Typically read/execute or nothing |

---

### 🛡️ What is SetUID (`4`)?

SetUID (Set User ID) is a **special permission**:

* When a file with SetUID is executed, it **runs with the permissions of the file owner**, **not the user who runs it**.
* Commonly used on executables like `/usr/bin/passwd` so that normal users can change their passwords (which requires root access temporarily).

---

### ✅ Example:

```bash
chmod 475 my_script.sh
```

Means:

* The script will run with the **file owner's privileges**.
* Owner can read/write/execute.
* Group can read/execute.
* Others may have limited or inherited rights.

---

### 🔎 View it:

You can see it in `ls -l` as:

```bash
-rwsr-xr-x  1 root root ... my_script.sh
```

Note the **`s`** in `rws` — it means SetUID is active.

---
