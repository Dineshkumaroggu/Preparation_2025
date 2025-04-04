Here’s a concise yet complete set of answers to all your Spring and Spring MVC-related questions:

---

### 🔹 Difference between `@Primary` and `@Qualifier` annotation, when to use which?

- **@Primary**: Marks a bean as the default when multiple candidates are available.
- **@Qualifier**: Used to specify exactly which bean to autowire when multiple beans of the same type exist.

**Use `@Primary`** when one bean should be preferred by default.  
**Use `@Qualifier`** when you want to be explicit about which bean to use.

---

### 🔹 Difference between `@Controller` and `@Component`, can we use them interchangeably?

- **@Component**: Generic stereotype for any Spring-managed component.
- **@Controller**: Specialized `@Component` for web MVC controllers that handles HTTP requests.

**Not interchangeable.** `@Controller` enables additional features (e.g., request mapping).

---

### 🔹 Difference between `BeanFactory` and `ApplicationContext`?

- **BeanFactory**: Basic container, lazy initialization, no support for annotations, AOP, etc.
- **ApplicationContext**: Advanced, eager initialization, supports internationalization, event propagation, AOP, etc.

---

### 🔹 What Are `DispatcherServlet` and `ContextLoaderListener`?

- **DispatcherServlet**: Front controller in Spring MVC that routes requests to controllers.
- **ContextLoaderListener**: Loads the root application context and ties it to the servlet context.

---

### 🔹 What are Spring MVC interceptors?

- They allow pre- and post-processing of HTTP requests.
- Implement `HandlerInterceptor` and override methods like `preHandle()`, `postHandle()`, and `afterCompletion()`.

---

### 🔹 What Is an Init Binder?

- Annotated method with `@InitBinder` in controller.
- Used to customize binding of request parameters to model attributes (e.g., date formatting).

---

### 🔹 Can you create a controller without using `@Controller` or `@RestController` annotations?

- Yes, using `@Component` and manual handler mapping, but it's **not recommended**. You lose benefits of annotation-based request mapping.

---

### 🔹 In Spring, by default beans are singleton. Does that mean they are thread-safe?

- **No.** Singleton beans are **not thread-safe by default**. Thread safety must be ensured explicitly.

---

### 🔹 How is the root application context in Spring MVC loaded?

- Loaded by `ContextLoaderListener`, defined in `web.xml` or `ServletContextInitializer`.

---

### 🔹 Limitation of `@Autowired` annotation?

- Cannot resolve ambiguity without `@Qualifier`.
- May fail silently if `required = false`.
- Doesn’t work with static fields.
- Can lead to **NullPointerException** if the bean is not managed by Spring.

---

### 🔹 How does `@SpringBootApplication` annotation work?

It is a combination of:
- `@Configuration` – marks the class as a source of bean definitions.
- `@EnableAutoConfiguration` – auto-configures beans based on classpath and properties.
- `@ComponentScan` – scans the package for components.

---

### 🔹 Name the exceptions thrown by the Spring DAO classes.

- `DataAccessException` (base class)
  - `DuplicateKeyException`
  - `EmptyResultDataAccessException`
  - `DataIntegrityViolationException`
  - `IncorrectResultSizeDataAccessException`, etc.

---

### 🔹 What do you mean by Aspect?

- A **module** that encapsulates cross-cutting concerns (e.g., logging, security).
- In AOP, aspects are implemented using advice and pointcuts.

---

### 🔹 What is an Advice?

- Code that is executed at a **certain join point** in the program (e.g., before or after a method call).

---

### 🔹 What are the different types of Advices?

1. **Before Advice**
2. **After Returning Advice**
3. **After Throwing Advice**
4. **After (Finally) Advice**
5. **Around Advice**

---

### 🔹 What are the different AOP implementations?

- **Spring AOP** – proxy-based, method-level, limited to Spring-managed beans.
- **AspectJ** – powerful, compile-time and load-time weaving.

---

### 🔹 What do you mean by Proxy in Spring Framework?

- A **proxy** is a wrapper for another object. In Spring, proxies enable AOP by intercepting method calls.

---

### 🔹 Explain Spring bean lifecycle?

1. Instantiate bean
2. Populate properties
3. Set bean name and context (via `BeanNameAware`, `ApplicationContextAware`)
4. Call `@PostConstruct` / `afterPropertiesSet()`
5. Bean is ready to use
6. On shutdown, call `@PreDestroy` / `destroy()`

---

### 🔹 What is Spring MVC and Spring?

- **Spring**: Core framework for Java applications (DI, AOP, etc.)
- **Spring MVC**: Module in Spring for building web apps using MVC architecture.

---

### 🔹 Explain DispatcherServlet in detail?

- Core component of Spring MVC
- Acts as **Front Controller**
- Steps:
  1. Receives HTTP request
  2. Delegates to `HandlerMapping`
  3. Invokes controller method
  4. Returns `ModelAndView`
  5. Uses `ViewResolver` to render view
  6. Sends response to client

---

### 🔹 How to implement Custom Validator other than predefined?

1. **Create a validator class** that implements `ConstraintValidator`.
2. Annotate it with `@Constraint`.
3. Use it on model fields with custom annotation.

```java
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = MyCustomValidator.class)
public @interface ValidField {
   String message() default "Invalid!";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}
```

```java
public class MyCustomValidator implements ConstraintValidator<ValidField, String> {
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return value != null && value.matches("[A-Z]{3}\\d{4}");
   }
}
```

---

Here are the answers to your Spring Boot questions in a clear and structured format:

---

### 🔹 What is Spring Boot, and how is it different from the Spring Framework?

- **Spring Framework** is a comprehensive programming and configuration model for modern Java-based enterprise applications.
- **Spring Boot** is a framework built on top of Spring to simplify the process of setting up, configuring, and running Spring applications with **minimal boilerplate code**.

**Difference**:
| Feature | Spring Framework | Spring Boot |
|--------|------------------|-------------|
| Setup | Manual configuration | Auto-configuration |
| Server | External (Tomcat, Jetty, etc.) | Embedded servers |
| Deployment | WAR | WAR or executable JAR |
| Dependency Management | Manual | Starter dependencies |

---

### 🔹 What are the key features of Spring Boot?

1. **Auto-Configuration**: Automatically configures Spring app based on classpath.
2. **Starter Dependencies**: Predefined dependency sets to reduce config.
3. **Embedded Servers**: Run app as standalone JAR with embedded Tomcat/Jetty/Undertow.
4. **Actuator**: Built-in endpoints to monitor and manage apps.
5. **Spring Initializr**: Web tool to bootstrap projects.
6. **DevTools**: Enhances development experience (e.g., live reload).
7. **Minimal XML Configuration**: Uses annotations and `application.properties`/`application.yml`.

---

### 🔹 What are the advantages of using Spring Boot?

- **Faster Development** with auto-configuration
- **No Need for WAR Files** – executable JARs
- **Minimal Configuration**
- **Microservices Ready**
- **Built-in Monitoring** with Spring Boot Actuator
- **Reduced Boilerplate Code**
- **Easy Testing and Integration**

---

### 🔹 What is the role of the `@SpringBootApplication` annotation?

It is a **composite annotation** combining:
- `@Configuration`: Defines configuration class.
- `@EnableAutoConfiguration`: Enables auto-configuration.
- `@ComponentScan`: Scans for components in the current and sub-packages.

It’s the **main entry point** for a Spring Boot application.

---

### 🔹 How does Spring Boot simplify dependency management?

- Uses **starter dependencies** like `spring-boot-starter-web`, which internally includes all necessary libraries (e.g., Spring MVC, Jackson).
- **Managed versions** through `spring-boot-dependencies` BOM – no need to specify versions explicitly.

---

### 🔹 What is an embedded server in Spring Boot? Which servers does Spring Boot support?

An **embedded server** is a web server that runs **within** the application JAR/WAR, eliminating the need for external deployment.

**Supported Embedded Servers**:
- **Tomcat** (default)
- **Jetty**
- **Undertow**

---

### 🔹 How do you create a Spring Boot application?

1. **Using Spring Initializr** (https://start.spring.io)
2. Add dependencies (e.g., Spring Web, JPA)
3. Create main class with `@SpringBootApplication`
4. Run using `main()` method

```java
@SpringBootApplication
public class MyApp {
   public static void main(String[] args) {
      SpringApplication.run(MyApp.class, args);
   }
}
```

---

### 🔹 What is the default embedded server in Spring Boot?

- **Apache Tomcat** is the **default embedded server** in Spring Boot.

---

### 🔹 How can you change the embedded server in Spring Boot?

- **Exclude Tomcat** and **add Jetty/Undertow** in `pom.xml` or `build.gradle`.

**For Jetty (Maven example)**:

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   <exclusions>
      <exclusion>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-tomcat</artifactId>
      </exclusion>
   </exclusions>
</dependency>

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

---

### 🔹 How do you run a Spring Boot application without an embedded server?

You can:
1. **Use `spring-boot-starter` (not `spring-boot-starter-web`)** for non-web apps.
2. **Disable web environment** in code:

```java
SpringApplication app = new SpringApplication(MyApp.class);
app.setWebApplicationType(WebApplicationType.NONE);
app.run(args);
```

---

Here’s a complete set of answers for your **Spring Boot Annotation-Based** questions, explained clearly and concisely:

---

### 🔹 Explain the purpose of the `@RestController` annotation.

- `@RestController` is a **specialized version** of `@Controller`.
- It combines `@Controller` and `@ResponseBody`, meaning **every method returns data** (usually JSON/XML) instead of rendering a view.
- Commonly used in RESTful APIs.

```java
@RestController
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

---

### 🔹 What is the difference between `@Controller` and `@RestController`?

| Feature         | `@Controller`         | `@RestController`           |
|----------------|-----------------------|------------------------------|
| Purpose        | Returns view templates | Returns data (JSON/XML)     |
| View Resolver  | Yes                   | No                           |
| `@ResponseBody`| Required on methods   | Implicit on all methods      |

---

### 🔹 What is the use of `@RequestMapping`?

- Used to **map HTTP requests to controller methods**.
- Can specify HTTP method, URL path, params, headers, etc.
- Works with `GET`, `POST`, `PUT`, `DELETE`, etc.

```java
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public String hello() {
    return "Hello";
}
```

---

### 🔹 How do `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping` work?

- These are **shortcut annotations** for `@RequestMapping(method = RequestMethod.X)`

```java
@GetMapping("/get")
@PostMapping("/post")
@PutMapping("/put")
@DeleteMapping("/delete")
```

They are used to handle specific HTTP methods directly and improve readability.

---

### 🔹 What is the purpose of `@Autowired`?

- Used for **automatic dependency injection**.
- Spring scans and injects the required bean automatically.

```java
@Autowired
private MyService myService;
```

It can be used on:
- Constructor
- Field
- Setter

---

### 🔹 Explain the difference between `@Component`, `@Service`, and `@Repository`.

| Annotation    | Purpose                           | Special Behavior                            |
|---------------|------------------------------------|----------------------------------------------|
| `@Component`  | Generic Spring-managed component   | None                                         |
| `@Service`    | Indicates a service class (business logic) | For better readability and semantic meaning |
| `@Repository` | Indicates DAO (Data Access Layer)  | Translates database exceptions into Spring's `DataAccessException` |

All are **stereotype annotations**, and functionally similar, but used to indicate different layers.

---

### 🔹 What is the use of `@Configuration` in Spring Boot?

- Marks a class as a **source of bean definitions**.
- Typically used with `@Bean` methods.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

---

### 🔹 How does `@Value` work in Spring Boot?

- Injects values from properties file or environment into fields, methods, or constructor parameters.

```java
@Value("${app.name}")
private String appName;
```

Supports:
- Default values: `@Value("${prop:defaultValue}")`
- Expression Language: `@Value("#{2 * T(Math).PI}")`

---

### 🔹 What is the use of `@Bean`?

- Defines a **Spring-managed bean** manually inside a `@Configuration` class.

```java
@Bean
public MyBean myBean() {
    return new MyBean();
}
```

Use `@Bean` when you need **explicit control** over object creation (e.g., third-party libraries).

---

### 🔹 What is `@Qualifier`, and why is it used?

- Used to **resolve ambiguity** when multiple beans of the same type exist.
- Works with `@Autowired` to specify which bean to inject.

```java
@Autowired
@Qualifier("mySpecialBean")
private MyService myService;
```

---

Here’s a complete and beginner-friendly set of answers to your **Java fundamentals** questions:

---

### 🔹 1. Describe Java in a single sentence

**Java is a high-level, object-oriented, platform-independent programming language used to build secure, scalable applications.**

---

### 🔹 2. What are the differences between primitive data types and objects in Java?

| Feature                | Primitive Data Types       | Objects / Reference Types       |
|------------------------|----------------------------|---------------------------------|
| Stored in              | Stack                      | Heap                            |
| Examples               | `int`, `char`, `boolean`   | `String`, `ArrayList`, custom classes |
| Value or Reference     | Store actual value         | Store reference to object       |
| Nullable               | No                         | Yes                             |
| Methods                | No                         | Yes (objects have methods)      |

---

### 🔹 3. What is the difference between `String`, `StringBuilder`, and `StringBuffer`?

| Feature       | `String`           | `StringBuilder`         | `StringBuffer`          |
|---------------|--------------------|--------------------------|--------------------------|
| Mutability    | Immutable           | Mutable                  | Mutable                  |
| Thread-safe   | Yes (immutable)     | No                       | Yes                     |
| Performance   | Slower for many changes | Fast (single-threaded) | Slower (due to sync)     |

---

### 🔹 4. How do you handle exceptions in Java?

Using **try-catch-finally** blocks:

```java
try {
   int a = 5 / 0;
} catch (ArithmeticException e) {
   System.out.println("Error: " + e.getMessage());
} finally {
   System.out.println("This always executes.");
}
```

You can also throw custom exceptions using `throw`.

---

### 🔹 5. What is the purpose of the `static` keyword in Java?

- Makes a **member belong to the class** rather than instances.
- Shared across all objects.
- Commonly used for utility methods and constants.

```java
static int count; // shared variable
static void print() { ... } // class method
```

---

### 🔹 6. Explain the concept of inheritance in Java through examples?

Inheritance allows a class to **acquire properties and methods** of another class.

```java
class Animal {
   void eat() { System.out.println("Eating..."); }
}

class Dog extends Animal {
   void bark() { System.out.println("Barking..."); }
}

Dog d = new Dog();
d.eat(); // inherited
d.bark(); // own method
```

---

### 🔹 7. What is the difference between `==` and `.equals()` when comparing strings?

- `==` checks **reference** (memory address).
- `.equals()` checks **content**.

```java
String a = new String("hello");
String b = new String("hello");

System.out.println(a == b);       // false
System.out.println(a.equals(b));  // true
```

---

### 🔹 8. What is the purpose of class constructors in Java?

- A **constructor** is used to **initialize** objects when they are created.
- Same name as class, no return type.

```java
class Car {
   Car() {
      System.out.println("Car created");
   }
}
```

---

### 🔹 9. What is method overloading in Java?

- Defining **multiple methods** with the same name but **different parameters**.

```java
void display(int a) { }
void display(String b) { } // Overloaded
```

---

### 🔹 10. How do you read user input from the console in Java?

Using `Scanner`:

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
String name = sc.nextLine();
int age = sc.nextInt();
```

---

### 🔹 11. What is the difference between `ArrayList` and `array`?

| Feature          | Array                          | ArrayList                   |
|------------------|--------------------------------|-----------------------------|
| Size             | Fixed                          | Dynamic                     |
| Type             | Can hold primitives            | Objects only                |
| Methods          | No built-in methods            | Has methods (add, remove)   |

---

### 🔹 12. How do you iterate through a collection in Java?

```java
// Using for-each loop
for(String s : list) {
   System.out.println(s);
}

// Using Iterator
Iterator<String> it = list.iterator();
while(it.hasNext()) {
   System.out.println(it.next());
}
```

---

### 🔹 13. What is the purpose of the `final` keyword when used with a variable?

- It makes the variable **constant** – cannot be reassigned after initialization.

```java
final int MAX = 100;
```

---

### 🔹 14. Explain the difference between `public`, `private`, and `protected` access modifiers.

| Modifier   | Same Class | Same Package | Subclass | Everywhere |
|------------|------------|--------------|----------|------------|
| `public`   | ✅         | ✅           | ✅       | ✅         |
| `protected`| ✅         | ✅           | ✅       | ❌         |
| `private`  | ✅         | ❌           | ❌       | ❌         |
| *default*  | ✅         | ✅           | ❌       | ❌         |

---

### 🔹 15. What is the purpose of the `this` keyword in Java?

- Refers to the **current object**.
- Useful for disambiguating variables, calling other constructors, or passing current object.

```java
this.name = name;
```

---

### 🔹 16. How do you convert a string to an integer in Java?

```java
String s = "123";
int num = Integer.parseInt(s);
```

---

### 🔹 17. What is the difference between `&&` and `&` operators?

| Operator | Type        | Description                     |
|----------|-------------|---------------------------------|
| `&&`     | Logical AND | Short-circuits if first is false |
| `&`      | Bitwise AND | Also works as logical AND but checks **both** sides |

```java
if (a != 0 && b / a > 1) // safe
if (a != 0 & b / a > 1)  // both sides evaluated
```

---

Here’s a clear and concise set of answers to your **Advanced Java & Java 8 features** questions – perfect for interviews or quick revision:

---

### 🔹 1. **Difference between Runnable and Callable interfaces in Java concurrency**

| Feature          | `Runnable`                     | `Callable<T>`                        |
|------------------|--------------------------------|---------------------------------------|
| Return Value     | Does not return a result       | Returns a result (`T`)               |
| Exception        | Cannot throw checked exceptions | Can throw checked exceptions         |
| Method           | `void run()`                   | `T call()`                           |
| Used With        | `Thread`, `ExecutorService`    | `ExecutorService.submit()`           |

---

### 🔹 2. **Differences between ArrayList and LinkedList? When to use which?**

| Feature            | `ArrayList`                | `LinkedList`                         |
|--------------------|----------------------------|--------------------------------------|
| Structure          | Dynamic array              | Doubly linked list                   |
| Access time        | Fast (O(1) for index)      | Slow (O(n) for index)                |
| Insert/Delete      | Slower (shifting needed)   | Faster at head/middle                |
| Memory             | Less overhead              | More memory due to node pointers     |

✅ **Use ArrayList** for frequent reads,  
✅ **Use LinkedList** for frequent inserts/deletes.

---

### 🔹 3. **Describe the Singleton pattern and provide a thread-safe example**

**Singleton** ensures only one instance of a class exists.

✅ **Thread-safe Singleton with Lazy Initialization (Double-checked locking):**

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
```

---

### 🔹 4. **Java Memory Model (JMM) and multithreading**

JMM defines **how threads interact through memory**, ensuring:
- **Visibility**: changes by one thread visible to others.
- **Ordering**: governs execution order of operations.
- Handles concepts like **volatile**, **synchronized**, and **happens-before** relationship.

---

### 🔹 5. **Differences between abstract classes and interfaces in Java 8+**

| Feature               | Abstract Class               | Interface (Java 8+)                |
|-----------------------|------------------------------|------------------------------------|
| Multiple Inheritance  | Not allowed                  | Allowed                            |
| Constructors          | Can have                     | Cannot have                        |
| State (fields)        | Can have state               | Only constants (public static final) |
| Default methods       | Supported (since always)     | Supported from Java 8              |
| Use case              | Common base class            | Capability-based multiple inheritance |

---

### 🔹 6. **`hashCode()` vs `equals()`**

- **equals()**: checks **object equality**.
- **hashCode()**: returns an **int hash** used in hash-based collections.

🔁 **Contract**:
- If `a.equals(b)` is `true`, then `a.hashCode() == b.hashCode()` **must** be true.
- Overriding one without the other breaks collections like `HashMap`, `HashSet`.

---

### 🔹 7. **Method References in Java 8**

Short-hand for lambda expressions that call existing methods.

**Syntax**:  
- `ClassName::staticMethod`
- `object::instanceMethod`
- `ClassName::new` (constructor ref)

**Examples**:
```java
list.forEach(System.out::println); // Print all elements
Function<String, Integer> func = Integer::parseInt;
```

---

### 🔹 8. **Purpose of `volatile` keyword**

- Ensures visibility of changes to variables **across threads**.
- Prevents **caching** or reordering by compiler or CPU.

```java
private volatile boolean running = true;
```

✅ Does **not** ensure atomicity.

---

### 🔹 9. **Differences between Comparable and Comparator**

| Feature         | `Comparable<T>`           | `Comparator<T>`                    |
|------------------|---------------------------|-------------------------------------|
| Belongs to       | Object (implemented by class) | External (separate class)       |
| Method           | `compareTo(T o)`          | `compare(T o1, T o2)`               |
| Use Case         | Natural ordering (e.g., by name) | Custom or multiple sort logic    |

---

### 🔹 10. **Purpose of `synchronized` keyword**

- Ensures **mutual exclusion**: only one thread accesses the block/method.
- Prevents race conditions.

```java
synchronized void update() {
   // thread-safe code
}
```

---

### 🔹 11. **Differences: HashMap vs LinkedHashMap vs TreeMap**

| Feature         | `HashMap`         | `LinkedHashMap`        | `TreeMap`                 |
|-----------------|-------------------|-------------------------|----------------------------|
| Order           | No guarantee       | Insertion order         | Sorted (natural/custom)    |
| Null keys/values| 1 null key allowed | 1 null key allowed      | No null keys allowed       |
| Performance     | Fastest            | Slightly slower         | Slower (due to sorting)    |

---

### 🔹 12. **Difference between method overloading and overriding**

| Feature           | Overloading                          | Overriding                          |
|-------------------|--------------------------------------|-------------------------------------|
| Definition        | Same method name, different params   | Subclass redefines parent method    |
| Class Relationship| Same class or subclass               | Requires inheritance                |
| Polymorphism      | Compile-time                         | Runtime                             |

---

### 🔹 13. **Purpose of default methods in interfaces (Java 8)**

- Allows **methods with implementation** in interfaces.
- Supports **backward compatibility** without breaking existing implementations.

```java
interface MyInterface {
    default void greet() {
        System.out.println("Hello!");
    }
}
```

---

### 🔹 14. **Checked vs Unchecked exceptions**

| Feature            | Checked Exception         | Unchecked Exception              |
|--------------------|---------------------------|----------------------------------|
| Inheritance        | `Exception` (except `RuntimeException`) | `RuntimeException` & subclasses |
| Handling           | Must handle (try/catch/throws) | Optional to handle             |
| Examples           | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |

---

### 🔹 15. **Purpose of `java.util.concurrent` package**

- Provides advanced concurrency utilities:
  - **Thread Pools** (`ExecutorService`)
  - **Atomic variables**
  - **Locks** (`ReentrantLock`)
  - **Concurrent collections** (`ConcurrentHashMap`)
  - **Synchronization utilities** (`CountDownLatch`, `Semaphore`)

---

### 🔹 16. **Functional interfaces and Lambda Expressions (Java 8)**

- A **functional interface** has only **one abstract method**.
- Enables use of **lambda expressions**.

```java
@FunctionalInterface
interface Greeting {
    void sayHello();
}

// Lambda
Greeting g = () -> System.out.println("Hi");
```

Examples: `Runnable`, `Callable`, `Comparator`, `Predicate`, `Function`

---

Here’s a complete and structured set of answers to your **Spring Boot Interview Questions** – ideal for quick learning or revision:

---

### 🔹 1. **What is Spring Boot, and why should I use it?**

**Spring Boot** is a framework built on top of Spring that **simplifies the development** of production-ready applications by offering **auto-configuration**, **embedded servers**, and **starter dependencies**, allowing developers to get started quickly without complex XML configurations.

✅ **Why use it?**
- Reduces boilerplate code  
- Auto-configures based on classpath  
- Quickly builds RESTful APIs and microservices  
- No need for external servlet containers  

---

### 🔹 2. **What are the main features of Spring Boot?**

- **Auto-configuration**
- **Starter dependencies**
- **Embedded servers** (Tomcat, Jetty, Undertow)
- **Spring Boot CLI**
- **Spring Boot Actuator**
- **Spring DevTools**
- **Minimal XML configuration**
- **Production-ready defaults**

---

### 🔹 3. **What is Spring Boot Starter?**

A **starter** is a **predefined dependency descriptor** that bundles common dependencies for a particular feature or module.

🧱 Examples:
- `spring-boot-starter-web` → for web + REST
- `spring-boot-starter-data-jpa` → for JPA
- `spring-boot-starter-security` → for Spring Security

---

### 🔹 4. **What is Dependency Injection in Spring Boot?**

**Dependency Injection (DI)** is a design pattern where Spring automatically provides required dependencies to a class at runtime, promoting **loose coupling** and **testability**.

✅ Achieved using:
- `@Autowired`
- Constructor injection
- Setter injection

---

### 🔹 5. **What are the steps in the Spring Bean Life Cycle?**

1. **Instantiation** – Bean is created.
2. **Populate Properties** – Dependencies are injected.
3. **`BeanNameAware`, `ApplicationContextAware`**, etc.
4. **`@PostConstruct`** or `afterPropertiesSet()` – Initialization.
5. **Bean is Ready**
6. **`@PreDestroy`** or `destroy()` – On shutdown.

---

### 🔹 6. **What are Spring Profiles and how do you use them?**

**Profiles** allow defining different configurations for **different environments** (dev, test, prod).

✅ Define with:
```yaml
spring:
  profiles:
    active: dev
```

✅ Use with annotations:
```java
@Profile("dev")
@Bean
public DataSource devDataSource() { ... }
```

---

### 🔹 7. **What is Spring Boot’s role in Microservices?**

Spring Boot simplifies building **microservices** by providing:
- **RESTful API support**
- **Embedded servers**
- **Lightweight deployment (JARs)**
- **Service discovery with Spring Cloud**
- **Centralized configuration and monitoring**

---

### 🔹 8. **What is the use of `@SpringBootApplication` annotation?**

It is a **meta-annotation** that combines:
- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

➡️ It marks the main class of a Spring Boot application and triggers auto-configuration and component scanning.

---

### 🔹 9. **How can you configure properties in a Spring Boot application?**

Use:
- `application.properties` or `application.yml`
- `@Value("${property.name}")` for injection
- `@ConfigurationProperties(prefix="...")` for mapping multiple properties

Example:
```properties
server.port=8081
```

```java
@Value("${server.port}")
private int port;
```

---

### 🔹 10. **How do you handle exceptions in Spring Boot?**

✅ Use:
- `@ControllerAdvice` + `@ExceptionHandler`
- Global handling using `ResponseEntityExceptionHandler`

Example:
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

---

### 🔹 11. **How can you configure a DataSource in Spring Boot?**

**Spring Boot auto-configures** a `DataSource` if it finds database properties in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=pass
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

---

### 🔹 12. **What is Spring Boot DevTools and how does it enhance development?**

✅ DevTools offers:
- **Auto-restart** on code change
- **Live reload** support in browser
- **Disables caching** for faster development
- **Better exception traces**

Include it as:
```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

---

### 🔹 13. **Differences between `@Component`, `@Service`, `@Repository`, and `@Controller`**

| Annotation   | Purpose                        | Special Behavior                    |
|--------------|---------------------------------|--------------------------------------|
| `@Component` | Generic bean                    | None                                 |
| `@Service`   | Business/service logic          | Better semantic clarity              |
| `@Repository`| Data access layer (DAO)         | Translates DB exceptions             |
| `@Controller`| Web MVC controller              | Returns views (unless `@ResponseBody`) |

---

### 🔹 14. **What is the purpose of `@Autowired`?**

Used for **automatic dependency injection**. Spring finds the matching bean and injects it into the field, constructor, or method.

```java
@Autowired
private MyService myService;
```

---

### 🔹 15. **How can you secure a Spring Boot application?**

✅ Use `spring-boot-starter-security`  
✅ Common features:
- Authentication & Authorization
- Role-based access
- CSRF protection
- JWT integration

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Use custom `SecurityConfig` by extending `WebSecurityConfigurerAdapter` or using `SecurityFilterChain` (newer approach).

---

### 🔹 16. **How can you handle different environments in a Spring Boot application?**

✅ Use **Spring Profiles**:
- `application-dev.yml`, `application-prod.yml`
- Activate using:
```properties
spring.profiles.active=prod
```

✅ Or with Maven/Gradle profiles and environment variables.

---

Here are in-depth and interview-ready answers to your **Java Interface & Spring Boot Microservices Design** questions, with real-world relevance and examples to help you relate them to your projects:

---

### 🔹 1. **How did you use interfaces to design your microservices architecture?**

In my microservices architecture, I used **interfaces** to:
- **Define contracts** for services and repositories.
- **Decouple implementation** from abstraction, which allowed for easier testing and future scalability.
- For example, I had an `OrderService` interface, with multiple implementations like `OnlineOrderService`, `InStoreOrderService`, injected using DI based on the business logic.

---

### 🔹 2. **What are default and static methods in interfaces? How did you use them in your project?**

- **Default methods** provide method implementations in interfaces (Java 8+).
- **Static methods** are utility methods accessible through the interface name.

🔧 I used `default` methods to provide base implementation for logging in shared service interfaces, and `static` methods to keep helper methods for validation and formatting reusable across services.

---

### 🔹 3. **Can an interface have private methods? Why would you use them?**

Yes, from **Java 9**, interfaces can have **private methods** to:
- Avoid code duplication inside `default` and `static` methods.
- Encapsulate reusable logic that shouldn't be exposed.

🛠 I used private methods to break down complex default logic in a helper interface used across payment modules.

---

### 🔹 4. **How does Spring handle multiple interface implementations in dependency injection?**

If multiple beans implement the same interface, Spring will throw a `NoUniqueBeanDefinitionException`.

✅ To resolve:
- Use `@Qualifier` to specify the desired bean.
- Or mark one with `@Primary`.

```java
@Autowired
@Qualifier("onlineOrderService")
private OrderService orderService;
```

---

### 🔹 5. **If two interfaces have the same default method, which one will be called? How did you resolve it in your project?**

Java doesn't allow ambiguity; you must **override** the conflicting method in the implementing class and specify which one to call using `InterfaceName.super.methodName()`.

🧩 I resolved this in my project by overriding the method and manually chaining the required default method logic.

---

### 🔹 6. **Can we declare variables inside an interface? How did you use interface constants in your project?**

Yes, variables in interfaces are implicitly:
- `public static final`

📌 I used constants in interface files like `AppConstants` to store API status codes, default limits, and error messages across microservices.

```java
public interface AppConstants {
   int MAX_RETRY = 3;
   String SERVICE_NAME = "InventoryService";
}
```

---

### 🔹 7. **Why do we use interfaces instead of abstract classes? Give an example from your project.**

✅ Interfaces support **multiple inheritance**, promote **loose coupling**, and can be used for **pluggable behavior**.

In my project, I preferred interfaces to:
- Implement `PaymentProcessor` with multiple strategies (e.g., Stripe, PayPal).
- Allow dynamic loading using Spring's DI without tight coupling.

---

### 🔹 8. **How did you implement dependency injection using interfaces in your Spring Boot microservices?**

I created interfaces for services and injected them via constructors.

```java
public interface NotificationService {
   void send(String message);
}

@Service
public class EmailNotificationService implements NotificationService {
   public void send(String message) { /* logic */ }
}

@Autowired
public NotificationController(NotificationService notificationService) {
   this.notificationService = notificationService;
}
```

This ensured **easy swapping**, **testing**, and **mocking**.

---

### 🔹 9. **Can an interface extend another interface? How did you use it in your project?**

Yes, interfaces can extend one or more interfaces.

🔄 In my project, I had:
```java
public interface BaseService {
   void audit();
}

public interface UserService extends BaseService {
   void registerUser();
}
```
This helped reuse `audit()` functionality across all service interfaces.

---

### 🔹 10. **Have you used the Strategy Pattern in your project? How did interfaces help in its implementation?**

Yes. The **Strategy Pattern** allows defining a family of algorithms, encapsulating each, and making them interchangeable.

🧠 I implemented it using interfaces for tax calculation:
```java
public interface TaxStrategy {
   double calculateTax(double amount);
}

@Component("gstStrategy")
public class GSTStrategy implements TaxStrategy { ... }

@Component("vatStrategy")
public class VATStrategy implements TaxStrategy { ... }
```

Then injected dynamically based on user location.

---

### 🔹 11. **How to implement multiple interfaces in a Spring Boot service class?**

Just separate them with commas:

```java
@Service
public class MyServiceImpl implements InterfaceA, InterfaceB {
   // implement both sets of methods
}
```

Spring handles the bean creation. You can inject the same service using either interface depending on the context.

---

### 🔹 12. **Have you ever used functional interfaces in your project? Give an example.**

Yes, especially for **cleaner lambda-based processing**.

Example:
```java
@FunctionalInterface
public interface Validator<T> {
   boolean validate(T input);
}
```

Used with lambdas:
```java
Validator<String> emailValidator = email -> email.contains("@");
```

Also used built-in ones like `Predicate`, `Function`, and `Consumer`.

---

### 🔹 13. **How did you use marker interfaces in your project?**

Marker interfaces have **no methods** but serve as **tags**.

🧪 I created a `Validatable` marker interface and used it for conditional validations during request processing:
```java
public interface Validatable {}
```

Then:
```java
if (request instanceof Validatable) {
   validate(request);
}
```

---

### 🔹 14. **How did you design an API contract using interfaces in your microservices project?**

I used interfaces to:
- Define shared contracts between producer and consumer services.
- Ensure consistent request/response models with Feign clients.

```java
@FeignClient("inventory-service")
public interface InventoryClient {
   @GetMapping("/api/inventory/{id}")
   InventoryResponse getInventory(@PathVariable String id);
}
```

This promotes **contract-first development** and **strong typing**.

---

### 🔹 15. **Can we create an object of an interface? How did you use anonymous classes in your project?**

You can’t instantiate an interface directly, but you can use:
- **Anonymous classes**
- **Lambdas** (if functional)

Example from my project:
```java
Runnable task = new Runnable() {
   public void run() {
      System.out.println("Async task running");
   }
};
```

Used it in background schedulers before migrating to `@Scheduled`.

---


Absolutely! Let’s compare **JDBC**, **Hibernate**, **JPA**, and **Spring Data JPA**—with **brief code examples** for each.

---

### 🔁 Quick Summary Table

| Feature / Aspect         | JDBC                          | Hibernate                             | JPA                              | Spring Data JPA                          |
|--------------------------|-------------------------------|----------------------------------------|----------------------------------|-------------------------------------------|
| **Type**                 | Low-level API                 | ORM Framework                          | Specification (interface)        | Abstraction over JPA (Spring integration) |
| **Boilerplate**          | High                          | Less                                   | Moderate                         | Minimal                                    |
| **Mapping**              | Manual                        | Auto via annotations                   | Auto via annotations             | Auto via annotations + repository magic   |
| **Query Language**       | SQL                           | HQL                                    | JPQL                             | JPQL / Method names / @Query               |
| **Transactions**         | Manual                        | Auto via config                        | Via `@Transactional`             | Declarative via Spring                    |
| **Caching**              | No                            | Yes (1st/2nd-level)                    | No (depends on implementation)   | Inherited from JPA provider (e.g., Hibernate) |
| **Use Case**             | When you need fine control    | Full ORM + caching + batch operations  | JPA Standard API                 | Rapid development in Spring Boot          |

---

## ✅ Examples

---

### 1. **JDBC Example**

```java
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE id = ?");
stmt.setInt(1, 1);
ResultSet rs = stmt.executeQuery();

while (rs.next()) {
    System.out.println(rs.getString("name"));
}

rs.close(); stmt.close(); conn.close();
```

---

### 2. **Hibernate Example**

```java
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    // getters and setters
}

// Fetching
Session session = sessionFactory.openSession();
Employee emp = session.get(Employee.class, 1);
System.out.println(emp.getName());
session.close();
```

---

### 3. **JPA Example (Without Spring)**

```java
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
}

EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
EntityManager em = emf.createEntityManager();

Employee emp = em.find(Employee.class, 1);
System.out.println(emp.getName());

em.close(); emf.close();
```

---

### 4. **Spring Data JPA Example**

```java
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
}

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);
}

// Usage
@Autowired
private EmployeeRepository repo;

List<Employee> emps = repo.findByName("John");
```

---

### ✅ When to Use What:

- ✅ **JDBC**: You need custom SQL or performance-tuned control.
- ✅ **Hibernate**: You want full ORM with caching and entity states.
- ✅ **JPA**: You want a standard ORM spec (used with Hibernate, EclipseLink).
- ✅ **Spring Data JPA**: You’re using Spring Boot and want fast dev with minimal code.


---

### 🧵 1. **Using the `Runnable` Interface** (Preferred way)

```java
// Define a class that implements Runnable
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running using Runnable!");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable obj = new MyRunnable();
        Thread t1 = new Thread(obj); // Pass the Runnable to Thread
        t1.start(); // Start the thread
    }
}
```

✅ **Why use Runnable?**
- Supports multiple inheritance (you can extend another class).
- Separates thread logic from thread creation.

---

### 🧵 2. **Using the `Thread` Class** (Direct subclass)

```java
// Extend the Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running using Thread class!");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Start the thread
    }
}
```

✅ **Why use Thread class?**
- Quick and simple.
- Good for small use cases where inheritance from Thread is okay.

---

### 🔁 Comparison:

| Feature         | `Runnable`                        | `Thread`                              |
|-----------------|-----------------------------------|----------------------------------------|
| Inheritance     | Can extend other classes          | Can't extend any other class           |
| Flexibility     | More flexible (recommended)       | Less flexible                          |
| Separation      | Separates task & thread           | Task and thread are tightly coupled    |

---

