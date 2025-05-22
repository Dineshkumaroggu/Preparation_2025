
## 🧱 **S.O.L.I.D Principles in Java**

---

### **S – Single Responsibility Principle (SRP)**  
> 👉 A class should have **only one reason to change**.

📌 **Meaning**: One class = One job.

✅ **Good Example**:
```java
class InvoicePrinter {
    public void print(Invoice invoice) {
        // Print invoice
    }
}

class InvoiceSaver {
    public void saveToFile(Invoice invoice) {
        // Save invoice to file
    }
}
```

🚫 **Bad**: Don’t mix print, save, and calculate in one class.

---

### **O – Open/Closed Principle (OCP)**  
> 👉 Classes should be **open for extension but closed for modification**.

📌 **Meaning**: You can extend behavior **without changing existing code**.

✅ **Good Example** (Using Polymorphism):
```java
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }
    double area() { return Math.PI * radius * radius; }
}
```

🚫 **Bad**: Don’t use `if-else` to handle types inside one class.

---

### **L – Liskov Substitution Principle (LSP)**  
> 👉 Subclasses should be **replaceable** with their parent classes **without breaking** the code.

📌 **Meaning**: Child class must not **violate** parent class behavior.

✅ **Good Example**:
```java
class Bird {
    void fly() {}
}

class Sparrow extends Bird {
    void fly() {
        System.out.println("Flying...");
    }
}
```

🚫 **Bad**: A `Penguin` class that can't fly shouldn't extend `Bird` if `Bird.fly()` is expected.

---

### **I – Interface Segregation Principle (ISP)**  
> 👉 Clients should not be forced to implement **unnecessary methods** they don’t use.

📌 **Meaning**: Prefer **smaller, focused interfaces**.

✅ **Good Example**:
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}
```

🚫 **Bad**:
```java
interface Machine {
    void print();
    void scan();
    void fax();
}
// Old printer doesn't support fax, but forced to implement it
```

---

### **D – Dependency Inversion Principle (DIP)**  
> 👉 Depend on **abstractions**, not concrete classes.

📌 **Meaning**: High-level modules shouldn’t depend on low-level modules. Both should depend on **interfaces**.

✅ **Good Example**:
```java
interface MessageService {
    void sendMessage(String msg);
}

class EmailService implements MessageService {
    public void sendMessage(String msg) {
        System.out.println("Email: " + msg);
    }
}

class Notification {
    MessageService service;
    Notification(MessageService service) {
        this.service = service;
    }

    void notifyUser() {
        service.sendMessage("Hello!");
    }
}
```

🚫 **Bad**: Creating `EmailService` directly inside `Notification`.

---

## 🧠 EASY WAY TO REMEMBER:

**S.O.L.I.D** =  
- **S** = Single job  
- **O** = Extend without change  
- **L** = Sub can replace super  
- **I** = Keep interfaces small  
- **D** = Use abstractions (interfaces)

---

Of course! Let's dive deeper into the last two SOLID principles with **clear explanations**, **real-world analogies**, and **Java-focused examples** to help you **understand and remember** them better.

---

## 🧩 **I – Interface Segregation Principle (ISP)**  
> ❗ **"Keep interfaces small and specific, not large and general."**

### 🔍 What It Means:
- **Clients (classes using the interface) should only know about methods that are relevant to them.**
- Don't force a class to implement methods it **doesn’t need**.

### 💡 Real-World Analogy:
Imagine an **old printer** that **only prints**. Now suppose there's an interface like:

```java
interface Machine {
    void print();
    void scan();
    void fax();
}
```
The old printer must still implement all three methods, even though it can't **scan or fax**. That’s bad design.

### ✅ Better Design:
Split the interface into **smaller, specific ones**:

```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}
```

Now, classes implement **only what they need**:

```java
class OldPrinter implements Printer {
    public void print() {
        System.out.println("Printed!");
    }
}

class ModernPrinter implements Printer, Scanner, Fax {
    public void print() { ... }
    public void scan() { ... }
    public void fax() { ... }
}
```

### 🚀 Benefits:
- **Flexibility**: Add new functionalities without affecting other classes.
- **Maintainability**: Easier to understand and test.
- **No unnecessary dependencies**.

---

## 🧱 **D – Dependency Inversion Principle (DIP)**  
> ❗ **"High-level modules should not depend on low-level modules. Both should depend on abstractions."**

### 🔍 What It Means:
- Instead of hardcoding concrete classes, **depend on interfaces (abstractions)**.
- This **decouples** your code and makes it easier to change or extend.

### 💡 Real-World Analogy:
Imagine a **light switch**. The switch doesn't care whether it's controlling a **bulb, a fan, or a heater**. It just sends a signal – that’s **abstraction**.

### ❌ Bad Example:
```java
class EmailService {
    public void send(String msg) {
        System.out.println("Sending email: " + msg);
    }
}

class Notification {
    EmailService emailService = new EmailService();

    public void notifyUser() {
        emailService.send("Hi user!");
    }
}
```
Here, `Notification` is **tightly coupled** to `EmailService`.

### ✅ Better DIP-based Design:
```java
interface MessageService {
    void send(String msg);
}

class EmailService implements MessageService {
    public void send(String msg) {
        System.out.println("Email: " + msg);
    }
}

class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service;
    }

    public void notifyUser() {
        service.send("Hello!");
    }
}
```

Now `Notification` is **independent of the concrete class**, and you can easily switch to `SMSService`, `SlackService`, etc.

### 💡 Bonus: Dependency Injection
- Frameworks like **Spring** help inject the correct dependency automatically.
- Example:
```java
@Autowired
MessageService messageService;
```

---

## 🧠 Easy Way to Remember

| Principle | Tip | Meaning |
|----------|------|---------|
| **I** | "Don’t force me!" | Keep interfaces focused, not fat |
| **D** | "Don’t depend on details!" | Use interfaces, not concrete classes |

---

