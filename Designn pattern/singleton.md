A **Singleton class** in Java is a design pattern that ensures **only one instance** of the class is ever created during the application’s lifetime. It’s commonly used for **logging**, **caching**, **configuration**, **thread pools**, **DB connections**, etc.

---

### ✅ Characteristics of a Singleton Class:

| Feature                  | Description                                        |
| ------------------------ | -------------------------------------------------- |
| Single Instance          | Only one object of the class is created            |
| Global Access Point      | The instance is accessible globally                |
| Controlled Instantiation | Constructor is private to prevent outside creation |

---

### 🔧 How to Implement Singleton in Java

#### ✅ 1. **Basic Thread-Safe Singleton (Lazy Initialization)**

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

> ✅ Thread-safe, but `synchronized` makes it **slower** for high-concurrency apps.

---

#### ✅ 2. **Bill Pugh Singleton (Best Practice)**

This is the **most efficient and thread-safe** way without synchronization overhead.

```java
public class Singleton {

    private Singleton() {
        // private constructor
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

> ✅ Thread-safe, lazy-loaded, and **efficient** — this is the **recommended way**.

---

#### ✅ 3. **Eager Initialization (Simple, but not Lazy)**

```java
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
```

> ✅ Simple, but the instance is created even if not used.

---

### ✅ Bonus: Singleton with Enum (Thread-Safe + Serialization-Proof)

```java
public enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing work...");
    }
}
```

> ✅ Recommended by **Effective Java (Joshua Bloch)**.
> Enum-based singletons are **thread-safe**, and **safe from reflection and serialization** issues.

---

### 🧠 Summary

| Type                    | Lazy | Thread-Safe | Efficient | Recommended                    |
| ----------------------- | ---- | ----------- | --------- | ------------------------------ |
| Synchronized method     | ✅    | ✅           | ❌         | ❌                              |
| Bill Pugh (Inner Class) | ✅    | ✅           | ✅         | ✅✅✅                            |
| Eager Initialization    | ❌    | ✅           | ✅         | ⚠️ (if instance always needed) |
| Enum Singleton          | ✅    | ✅           | ✅         | ✅✅✅                            |

