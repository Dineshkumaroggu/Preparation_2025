The **Factory Design Pattern** is a **creational pattern** that provides an interface for creating objects **without specifying the exact class** of object that will be created.

---

### ✅ Use Case:

Use the **Factory Pattern** when:

* You want to **decouple object creation** from the client code.
* You have a **superclass/interface** and multiple subclasses implementing it.
* You need to create objects based on input, conditions, or configuration.

---

### 🏗️ Structure:

```text
        Client
           |
           v
     [Factory Class]
       /     |     \
   ObjectA ObjectB ObjectC
```

---

### ✅ Example: Factory Pattern in Java

Let's say we have an application that handles **shapes** like `Circle`, `Rectangle`, and `Square`.

#### 1. **Step 1: Create the Interface**

```java
public interface Shape {
    void draw();
}
```

#### 2. **Step 2: Create Implementing Classes**

```java
public class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}
```

#### 3. **Step 3: Create the Factory Class**

```java
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
```

#### 4. **Step 4: Use Factory in Client Code**

```java
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape s1 = shapeFactory.getShape("Circle");
        s1.draw(); // Output: Drawing Circle

        Shape s2 = shapeFactory.getShape("Rectangle");
        s2.draw(); // Output: Drawing Rectangle

        Shape s3 = shapeFactory.getShape("Square");
        s3.draw(); // Output: Drawing Square
    }
}
```

---

### 🧠 Benefits of Factory Pattern:

| Benefit                           | Description                                           |
| --------------------------------- | ----------------------------------------------------- |
| ✅ **Loose Coupling**              | Client does not need to know the class being used     |
| ✅ **Centralized Object Creation** | Easy to manage and extend in one place                |
| ✅ **Open/Closed Principle**       | You can add new shapes without changing existing code |

---

### 🔄 Real-World Examples:

* `java.util.Calendar.getInstance()` – returns a `Calendar` object
* `java.text.NumberFormat.getInstance()` – returns a subclass based on locale
* `javax.xml.parsers.DocumentBuilderFactory` – returns a parser based on input

