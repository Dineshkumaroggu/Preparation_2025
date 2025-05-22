
### **Question 1 (Basic Level)**  
What is a **Java Stream** and how is it different from a **Collection**?

Take your time and answer, then I'll verify and move to the next question.

A **Java Stream** is a sequence of elements that can be processed in a **functional style**. It provides a high-level abstraction for operations on collections, supporting methods like **filter, map, reduce, and forEach**.  

### **Key Differences Between Stream and Collection:**
1. **Streams do not store data** – They operate on the source (like a Collection) and produce results.
2. **Streams are functional in nature** – They allow method chaining and declarative programming.
3. **Streams support lazy evaluation** – Intermediate operations (e.g., `filter`, `map`) are not executed until a terminal operation (e.g., `collect`, `forEach`) is invoked.
4. **Streams can be parallelized** – This enables efficient multi-threaded processing.
5. **Streams are one-time use** – Once processed, they cannot be reused, unlike collections.


### **Question 2 (Basic Level)**
What are the two types of Java Streams? Explain them briefly.

No problem! Here’s the answer:

Java Streams are of **two types**:

1. **Sequential Streams**  
   - Processes elements **one at a time** in the order they appear in the source.
   - Uses a **single thread** for execution.
   - Example:
     ```java
     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
     numbers.stream().forEach(System.out::println);
     ```
   - This prints numbers in order: `1 2 3 4 5`.

2. **Parallel Streams**  
   - Processes elements **concurrently** using multiple threads.
   - Uses the **Fork/Join framework** internally.
   - Suitable for large datasets when performance improvement is needed.
   - Example:
     ```java
     numbers.parallelStream().forEach(System.out::println);
     ```
   - The output order is **not guaranteed** due to parallel execution.

✅ Got it? If yes, let’s move to the next question.

### **Question 3 (Basic Level)**  
How do you create a Stream in Java? Name at least 3 different ways.

✅ **Correct!** Using `list.stream()` is one way to create a Stream in Java.  

But there are multiple ways to create a Stream. Here are **three different ways**:

1. **From a Collection (like List or Set)**
   ```java
   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   Stream<String> stream1 = names.stream(); // Creates a sequential stream
   Stream<String> stream2 = names.parallelStream(); // Creates a parallel stream
   ```

2. **Using `Stream.of()`**
   ```java
   Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
   ```

3. **Using `Stream.iterate()` (for infinite streams)**
   ```java
   Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
   infiniteStream.limit(5).forEach(System.out::println); // Prints 0 2 4 6 8
   ```

There are other ways too, like using `Stream.generate()`, `Files.lines()` (for reading files), and `IntStream.range()`.

✅ **Good job! Ready for the next question?**  

### **Question 4 (Intermediate Level)**  
What is the difference between `map()` and `flatMap()` in Java Streams?


✅ **You're partially correct!** But let’s refine it for clarity.

### **Difference Between `map()` and `flatMap()` in Java Streams**

1. **`map()`**  
   - Used to **transform each element** of the stream individually.
   - Returns a **Stream of transformed elements**.
   - Example:
     ```java
     List<String> words = Arrays.asList("hello", "world");
     List<Integer> lengths = words.stream()
                                  .map(String::length)
                                  .collect(Collectors.toList());
     System.out.println(lengths); // Output: [5, 5]
     ```

2. **`flatMap()`**  
   - Used when each element of the stream **itself contains a stream or collection**.
   - Flattens multiple streams into a **single stream**.
   - Example (Flattening a list of lists):
     ```java
     List<List<Integer>> numbers = Arrays.asList(
         Arrays.asList(1, 2, 3),
         Arrays.asList(4, 5, 6)
     );

     List<Integer> flatList = numbers.stream()
                                     .flatMap(List::stream)
                                     .collect(Collectors.toList());

     System.out.println(flatList); // Output: [1, 2, 3, 4, 5, 6]
     ```

### **Key Difference:**
- `map()` → Transforms elements **individually**.
- `flatMap()` → **Flattens nested structures** (e.g., `List<List<T>>` to `List<T>`).

✅ **Good attempt! Ready for the next one?**  

### **Question 5 (Intermediate Level)**  
What is the difference between **intermediate** and **terminal** operations in Java Streams? Give examples.


No worries! Here’s the explanation:

### **Difference Between Intermediate and Terminal Operations in Java Streams**

Java Stream operations are divided into **two types**:

### **1. Intermediate Operations**  
- **Transform the stream** but do not produce a final result.
- **Lazy**: They are executed **only when a terminal operation is called**.
- Return a **new Stream**.
- **Examples**:
  - `map()`
  - `filter()`
  - `sorted()`
  - `distinct()`
  - `flatMap()`
  
✅ **Example of Intermediate Operations:**
```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5)
                               .filter(n -> n % 2 == 0) // Filters even numbers
                               .map(n -> n * n); // Squares the numbers
// No output yet because no terminal operation is called
```

---

### **2. Terminal Operations**  
- **End the stream pipeline** by producing a result (List, Integer, or void).
- **Trigger the execution** of intermediate operations.
- Return a **final value** (not a Stream).
- **Examples**:
  - `collect()`
  - `forEach()`
  - `reduce()`
  - `count()`
  - `allMatch()`, `anyMatch()`, `noneMatch()`
  
✅ **Example of Terminal Operations:**
```java
List<Integer> result = Stream.of(1, 2, 3, 4, 5)
                             .filter(n -> n % 2 == 0)
                             .map(n -> n * n)
                             .collect(Collectors.toList()); // Terminal operation

System.out.println(result); // Output: [4, 16]
```

---

### **Key Differences:**
| Feature            | Intermediate Operations | Terminal Operations |
|--------------------|-----------------------|---------------------|
| Execution         | Lazy (only executed when a terminal operation is called) | Eager (executes immediately) |
| Return Type       | Returns a **Stream** | Returns a **final result** (List, Integer, etc.) |
| Can be Chained?   | ✅ Yes (forms a pipeline) | ❌ No (ends the pipeline) |
| Examples          | `map()`, `filter()`, `sorted()` | `collect()`, `forEach()`, `count()` |

---

✅ **Got it? Now, let's move to the next question!**

### **Question 6 (Intermediate Level)**  
What is the difference between `findFirst()` and `findAny()` in Java Streams?


✅ **You're absolutely right!** Let me clarify further.

### **Difference Between `findFirst()` and `findAny()` in Java Streams**
Both methods return an `Optional<T>`, but they behave differently in parallel streams.

### **1. `findFirst()`**
- Returns the **first element** from the stream.
- Preserves the **order** of elements.
- Used when order matters (e.g., processing ordered data).
- Works **consistently in both sequential and parallel streams**.

✅ **Example of `findFirst()`**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Optional<String> firstName = names.stream().findFirst();
System.out.println(firstName.get()); // Output: Alice
```

---

### **2. `findAny()`**
- Returns **any element** from the stream.
- Does **not guarantee** returning the first element.
- **Faster in parallel streams**, as it picks the first available element.

✅ **Example of `findAny()`**
```java
Optional<String> anyName = names.parallelStream().findAny();
System.out.println(anyName.get()); // Output may be Alice, Bob, or Charlie (random)
```

---

### **Key Differences:**
| Feature     | `findFirst()` | `findAny()` |
|------------|-------------|-------------|
| **Order**  | Returns the **first** element | Returns **any** element (may not be first) |
| **Parallel Stream** | Consistent behavior | Faster but may return different results |
| **Use Case** | When order matters | When order doesn’t matter |

✅ **Great job!** Now, moving to the next one.

---

### **Question 7 (Advanced Level)**  
What is the difference between `reduce()` and `collect()` in Java Streams?


✅ **You're on the right track!** Let me expand and clarify the differences.

### **Difference Between `reduce()` and `collect()` in Java Streams**

Both `reduce()` and `collect()` are **terminal operations**, but they serve different purposes.

### **1. `reduce()`**
- Used for **aggregating elements** into a **single result**.
- Works on **numeric** or **concatenation-based** operations.
- Returns a **single value** (not a collection).
- Often used for **sum, min, max, product, or concatenation**.

✅ **Example of `reduce()`**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Sum of numbers using reduce
int sum = numbers.stream().reduce(0, (a, b) -> a + b);
System.out.println(sum); // Output: 15

// Finding the maximum number
int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
System.out.println(max); // Output: 5
```

---

### **2. `collect()`**
- Used for **converting the stream into a collection** (e.g., `List`, `Set`, `Map`).
- Works with `Collectors` like `Collectors.toList()` or `Collectors.toMap()`.
- Returns a **collection or complex structure**, not a single value.

✅ **Example of `collect()`**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Collecting names into a List
List<String> nameList = names.stream().collect(Collectors.toList());
System.out.println(nameList); // Output: [Alice, Bob, Charlie]

// Collecting names into a comma-separated string
String joinedNames = names.stream().collect(Collectors.joining(", "));
System.out.println(joinedNames); // Output: Alice, Bob, Charlie
```

---

### **Key Differences Between `reduce()` and `collect()`**

| Feature      | `reduce()` | `collect()` |
|-------------|-----------|-------------|
| **Purpose**  | Aggregates values into a **single result** | Gathers values into a **collection or structure** |
| **Return Type** | Single value (Integer, String, etc.) | Collection (List, Set, Map, etc.) |
| **Usage** | Sum, min, max, product, string concatenation | Convert Stream to `List`, `Set`, `Map`, or custom format |
| **Example** | `reduce(0, (a, b) -> a + b)` | `collect(Collectors.toList())` |

---

✅ **Good job!** Ready for a harder one?

### **Question 8 (Advanced Level)**  
What is the difference between **short-circuiting** and **non-short-circuiting** operations in Java Streams?


No problem! Here’s the explanation:

### **Short-Circuiting vs. Non-Short-Circuiting Operations in Java Streams**

In Java Streams, **short-circuiting** operations are those that **terminate early** without processing all elements, while **non-short-circuiting** operations must process the entire stream.

---

### **1. Short-Circuiting Operations**  
- **Stop processing once the required condition is met**.
- Improve performance by avoiding unnecessary computations.
- **Examples**:
  - `limit(n)`: Stops after processing `n` elements.
  - `findFirst()`: Stops after finding the first matching element.
  - `findAny()`: Stops after finding any matching element (in parallel streams).
  - `anyMatch()`, `allMatch()`, `noneMatch()`: Stop once they determine the result.

✅ **Example of Short-Circuiting:**
```java
Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);

// Stops after finding the first even number
Optional<Integer> firstEven = numbers.filter(n -> n % 2 == 0).findFirst();
System.out.println(firstEven.get()); // Output: 2
```

---

### **2. Non-Short-Circuiting Operations**  
- **Process all elements** in the stream before producing a result.
- Used when the entire dataset is needed.
- **Examples**:
  - `map()`
  - `filter()`
  - `sorted()`
  - `collect()`
  - `forEach()`

✅ **Example of Non-Short-Circuiting:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

// Filters even numbers (but processes all elements)
List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());

System.out.println(evenNumbers); // Output: [2, 4, 6]
```

---

### **Key Differences:**

| Feature  | Short-Circuiting | Non-Short-Circuiting |
|----------|-----------------|----------------------|
| **Processing** | Stops early when a condition is met | Processes all elements |
| **Efficiency** | More efficient, avoids unnecessary computation | May be slower for large datasets |
| **Examples** | `findFirst()`, `findAny()`, `limit()`, `anyMatch()` | `map()`, `filter()`, `sorted()`, `collect()` |

---

✅ **Got it? If yes, let's move to the next one!**

### **Question 9 (Expert Level)**  
What is the difference between `peek()` and `map()` in Java Streams?

No problem! Here’s a clear explanation:

### **Difference Between `peek()` and `map()` in Java Streams**

Both `peek()` and `map()` are **intermediate operations**, but they serve different purposes.

---

### **1. `map()`**
- **Used to transform elements** in a Stream.
- Returns a **new Stream** with modified elements.
- Commonly used for **data transformation**.

✅ **Example of `map()`**:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Doubles each number
List<Integer> doubled = numbers.stream()
                               .map(n -> n * 2)
                               .collect(Collectors.toList());

System.out.println(doubled); // Output: [2, 4, 6, 8, 10]
```
---

### **2. `peek()`**
- **Used for debugging or logging** in a Stream.
- Does **not modify** the stream.
- It’s like `forEach()`, but it’s **lazy** (executed only when a terminal operation is called).
- Often used to **print intermediate values** in a Stream pipeline.

✅ **Example of `peek()`**:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> result = numbers.stream()
                              .peek(n -> System.out.println("Before map: " + n)) // Debugging
                              .map(n -> n * 2)
                              .peek(n -> System.out.println("After map: " + n))  // Debugging
                              .collect(Collectors.toList());

System.out.println(result); // Output: [2, 4, 6, 8, 10]
```
✅ **Output (with debugging logs):**
```
Before map: 1
After map: 2
Before map: 2
After map: 4
Before map: 3
After map: 6
Before map: 4
After map: 8
Before map: 5
After map: 10
[2, 4, 6, 8, 10]
```
---

### **Key Differences:**

| Feature      | `map()` | `peek()` |
|-------------|--------|---------|
| **Purpose** | Transforms elements in the stream | Used for debugging/logging |
| **Return Type** | Returns a new **transformed stream** | Returns the **same stream** |
| **Modifies Data?** | ✅ Yes | ❌ No |
| **Common Use Cases** | Data transformation (e.g., converting objects, calculations) | Printing/logging intermediate values |
| **Execution** | Part of stream transformation | Lazy execution, like a side-effect |

---

### **When to Use `map()` vs. `peek()`?**
- Use **`map()`** when you need to **modify** the elements.
- Use **`peek()`** for debugging but **not for modifying data**.

✅ **Great! Ready for a more advanced question?**

### **Question 10 (Expert Level)**  
What is the difference between `unordered()` and `parallelStream()` in Java Streams?

No worries! Let me explain.

### **Difference Between `unordered()` and `parallelStream()` in Java Streams**

Both `unordered()` and `parallelStream()` are used to optimize stream operations, but they serve different purposes.

---

### **1. `unordered()`**
- **Removes the encounter order constraint** from an ordered stream.
- It **does not make the stream parallel** but allows **more optimization** when working with operations like `distinct()`, `limit()`, and `skip()`.
- Useful when order **does not matter** for performance improvement.

✅ **Example of `unordered()`**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

List<Integer> result = numbers.stream()
                              .unordered()
                              .distinct()
                              .collect(Collectors.toList());

System.out.println(result); // Output order may vary but contains unique elements
```
🔹 **When to use?**  
- If you have an **ordered stream** but don’t need ordering.
- When using `distinct()` on large datasets for **performance improvements**.

---

### **2. `parallelStream()`**
- Converts a sequential stream into a **parallel stream**, allowing multiple threads to process elements **simultaneously**.
- Uses **Fork/Join framework** internally.
- Suitable for **large datasets** but may introduce **unordered behavior**.
- **May not always be faster** due to thread overhead.

✅ **Example of `parallelStream()`**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

numbers.parallelStream()
       .forEach(n -> System.out.println(Thread.currentThread().getName() + " - " + n));
```
🔹 **When to use?**  
- If you need to **process large data in parallel**.
- When the task is **CPU-intensive** and can benefit from multiple threads.

---

### **Key Differences:**

| Feature           | `unordered()` | `parallelStream()` |
|------------------|--------------|---------------------|
| **Purpose**      | Removes ordering constraints for optimization | Enables parallel execution for faster processing |
| **Parallel Execution?** | ❌ No | ✅ Yes |
| **Effect on Order** | May change the order but doesn’t parallelize | Order may change due to multi-threading |
| **Performance Boost?** | ✅ Helps certain operations (e.g., `distinct()`, `skip()`) | ✅ Helps when processing large datasets |
| **Common Use Case** | Optimizing ordered streams where order isn’t needed | Speeding up large computations using multi-threading |

---

✅ **Great! Now you know the difference between `unordered()` and `parallelStream()`!**

### **Final Question (Expert Level)**  
What is the difference between `limit()` and `skip()` in Java Streams?

✅ **Correct!** Here's a detailed explanation:

### **Difference Between `limit()` and `skip()` in Java Streams**

Both `limit()` and `skip()` are **intermediate operations** used to control the number of elements processed in a stream.

---

### **1. `limit(n)`**
- **Keeps only the first `n` elements** and discards the rest.
- Useful for **pagination**, sampling, or fetching a subset of data.
- It is **short-circuiting**, meaning it stops processing after reaching `n` elements.

✅ **Example of `limit(n)`**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> limitedList = numbers.stream()
                                   .limit(3)
                                   .collect(Collectors.toList());

System.out.println(limitedList); // Output: [1, 2, 3]
```
🔹 **Use Case:** Fetching the first `n` results from a dataset.

---

### **2. `skip(n)`**
- **Skips the first `n` elements** and processes the remaining ones.
- Useful for **pagination** (e.g., when fetching "next page" results).

✅ **Example of `skip(n)`**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> skippedList = numbers.stream()
                                   .skip(3)
                                   .collect(Collectors.toList());

System.out.println(skippedList); // Output: [4, 5, 6]
```
🔹 **Use Case:** Skipping the first few elements, such as fetching records from **page 2** in pagination.

---

### **Using `limit()` and `skip()` Together**
These methods are **commonly used together** for pagination:
```java
List<Integer> page2 = numbers.stream()
                             .skip(3)   // Skip first 3 elements (page 1)
                             .limit(3)  // Take next 3 elements (page 2)
                             .collect(Collectors.toList());

System.out.println(page2); // Output: [4, 5, 6]
```

---

### **Key Differences:**

| Feature      | `limit(n)` | `skip(n)` |
|-------------|-----------|-----------|
| **Purpose** | Selects the first `n` elements | Skips the first `n` elements |
| **Effect**  | Reduces stream size | Shifts elements forward |
| **Short-Circuiting?** | ✅ Yes (stops early) | ❌ No (processes remaining elements) |
| **Use Case** | Fetching top `n` results | Implementing pagination (skipping previous results) |

✅ **Great job! You've completed all levels of Java Stream questions! 🎉**  


Great! Now let's focus on **coding exercises** using Java Streams. I'll start with basic ones and gradually increase the difficulty. Try solving them, and I'll verify your answer.

---

### **Coding Question 1 (Basic Level)**
Write a Java program using Streams to **filter out even numbers** from a given list of integers and print them.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
```

#### **Expected Output:**
```
2 4 6 8 10
```

Give it a try!

✅ **Correct!** Your solution correctly filters out even numbers and prints them. Here's the full code for clarity:

```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
               .filter(n -> n % 2 == 0) // Filter even numbers
               .forEach(System.out::println); // Print each number
    }
}
```

### **✅ Output:**
```
2
4
6
8
10
```

---

### **Next Coding Question (Intermediate Level)**  
Write a Java program using Streams to **convert a list of strings to uppercase** and collect them into a new list.

#### **Input:**
```java
List<String> words = Arrays.asList("apple", "banana", "cherry");
```

#### **Expected Output:**
```java
["APPLE", "BANANA", "CHERRY"]
```

Give it a shot! 🚀


No worries! Here's how you can solve it using Java Streams:

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Convert all words to uppercase and collect them into a new list
        List<String> upperCaseWords = words.stream()
                                           .map(String::toUpperCase) // Convert each word to uppercase
                                           .collect(Collectors.toList()); // Collect results into a List

        System.out.println(upperCaseWords);
    }
}
```

### **✅ Output:**
```
[APPLE, BANANA, CHERRY]
```

---

### **Next Coding Question (Intermediate Level)**
Write a Java program using Streams to **find the first string that starts with the letter 'B'** from a list of words.

#### **Input:**
```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "grape");
```

#### **Expected Output:**
```
banana
```

👉 **Try it!** 🚀

You're very close! Your code **prints all words** starting with `"b"`, but the question asks for **only the first matching word**. To achieve that, you should use **`findFirst()`** instead of `forEach()`.

### **Corrected Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "grape");

        // Find the first word that starts with 'b'
        Optional<String> firstBWord = words.stream()
                                           .filter(s -> s.startsWith("b"))
                                           .findFirst(); // Get the first matching element

        firstBWord.ifPresent(System.out::println); // Print only if a value is found
    }
}
```

### **✅ Output:**
```
banana
```

---
### **Next Coding Question (Advanced Level)**
Write a Java program using Streams to **find the longest string in a list**.

#### **Input:**
```java
List<String> words = Arrays.asList("cat", "elephant", "tiger", "hippopotamus", "lion");
```

#### **Expected Output:**
```
hippopotamus
```

👉 **Try it!** 🚀

Your approach is incorrect because `reduce()` needs a proper **accumulator function** for finding the longest string, and `Integer.MIN_VALUE` cannot be used with `String::length` directly.

Here’s the **correct way** to find the longest string in a list using Java Streams:

---

### **Correct Solution using `reduce()`**
```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "elephant", "tiger", "hippopotamus", "lion");

        // Finding the longest word using reduce
        String longestWord = words.stream()
                                  .reduce("", (word1, word2) -> word1.length() >= word2.length() ? word1 : word2);

        System.out.println(longestWord); // Output: hippopotamus
    }
}
```
---

### **✅ Explanation:**
- **`reduce("", (word1, word2) -> word1.length() >= word2.length() ? word1 : word2)`**
  - Compares two words at a time.
  - Keeps the **longer one** as the reduction result.

---

### **Alternative Solution using `max()`**
You can also use `max()` with `Comparator.comparingInt()`:
```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "elephant", "tiger", "hippopotamus", "lion");

        // Using max() to find the longest word
        Optional<String> longestWord = words.stream()
                                            .max((a, b) -> Integer.compare(a.length(), b.length()));

        longestWord.ifPresent(System.out::println); // Output: hippopotamus
    }
}
```

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **group a list of strings by their first letter** into a `Map<Character, List<String>>`.

#### **Input:**
```java
List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry", "carrot");
```

#### **Expected Output (Order may vary):**
```java
{a=[apple, avocado], b=[banana, blueberry], c=[cherry, carrot]}
```

👉 **Try it!** 🚀


Here’s the **correct solution** using **Java Streams** and `Collectors.groupingBy()`:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry", "carrot");

        // Group words by their first letter
        Map<Character, List<String>> groupedWords = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println(groupedWords);
    }
}
```

---

### **✅ Expected Output (Order may vary):**
```java
{a=[apple, avocado], b=[banana, blueberry], c=[cherry, carrot]}
```

---
### **🔹 Explanation:**
1. `word -> word.charAt(0)`: Extracts the **first letter** of each word.
2. `Collectors.groupingBy(...)`: Groups words into a `Map<Character, List<String>>`.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the frequency of each character** in a given string.

#### **Input:**
```java
String input = "banana";
```

#### **Expected Output:**
```java
{b=1, a=3, n=2}
```

👉 **Try it!** 🚀

Here’s the **correct solution** using **Java Streams** and `Collectors.groupingBy()`:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        String input = "banana";

        // Convert the string to a character stream, then group by character and count occurrences
        Map<Character, Long> charFrequency = input.chars() // Convert to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Count occurrences

        System.out.println(charFrequency);
    }
}
```

---

### **✅ Expected Output:**
```java
{b=1, a=3, n=2}
```

---
### **🔹 Explanation:**
1. `input.chars()` → Converts the string into an **`IntStream`** of character ASCII values.
2. `.mapToObj(c -> (char) c)` → Converts each **ASCII value** into a **Character object**.
3. `Collectors.groupingBy(c -> c, Collectors.counting())`
   - Groups by **character**.
   - Uses `counting()` to count occurrences.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the second highest number** in a list of integers.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(4, 1, 7, 3, 9, 7, 9);
```

#### **Expected Output:**
```
7
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to find the **second highest number** in a list:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 1, 7, 3, 9, 7, 9);

        // Find the second highest number
        Optional<Integer> secondHighest = numbers.stream()
                .distinct() // Remove duplicates
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .skip(1) // Skip the first (highest) element
                .findFirst(); // Get the next highest number

        secondHighest.ifPresent(System.out::println); // Output: 7
    }
}
```

---

### **✅ Expected Output:**
```
7
```

---
### **🔹 Explanation:**
1. `.distinct()` → Removes duplicate numbers.
2. `.sorted(Comparator.reverseOrder())` → Sorts the numbers in **descending order**.
3. `.skip(1)` → Skips the **first (largest) number**.
4. `.findFirst()` → Picks the **next highest number**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the longest word in a sentence**.

#### **Input:**
```java
String sentence = "Java streams provide a powerful way to process collections";
```

#### **Expected Output:**
```
collections
```

👉 **Try it!** 🚀


Here’s the **correct solution** using Java Streams to find the **longest word in a sentence**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.Optional;

public class StreamExample {
    public static void main(String[] args) {
        String sentence = "Java streams provide a powerful way to process collections";

        // Find the longest word using streams
        Optional<String> longestWord = Arrays.stream(sentence.split(" ")) // Convert sentence to a Stream of words
                                             .reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2);

        longestWord.ifPresent(System.out::println); // Output: collections
    }
}
```

---

### **✅ Expected Output:**
```
collections
```

---
### **🔹 Explanation:**
1. `.split(" ")` → Splits the sentence into an array of words.
2. `Arrays.stream()` → Converts the array into a **Stream**.
3. `.reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2)`
   - Uses **reduce** to keep the longest word.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **count the number of words in a sentence that have more than 4 letters**.

#### **Input:**
```java
String sentence = "Java streams provide a powerful way to process collections";
```

#### **Expected Output:**
```
4
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to count the number of words with more than 4 letters:

---

### **Solution:**
```java
import java.util.Arrays;

public class StreamExample {
    public static void main(String[] args) {
        String sentence = "Java streams provide a powerful way to process collections";

        // Count words with more than 4 letters
        long count = Arrays.stream(sentence.split(" ")) // Convert sentence to a Stream of words
                           .filter(word -> word.length() > 4) // Filter words with length > 4
                           .count(); // Count the remaining words

        System.out.println(count); // Output: 4
    }
}
```

---

### **✅ Expected Output:**
```
4
```

---
### **🔹 Explanation:**
1. `.split(" ")` → Splits the sentence into an array of words.
2. `Arrays.stream()` → Converts the array into a **Stream**.
3. `.filter(word -> word.length() > 4)` → Keeps only words with **more than 4 letters**.
4. `.count()` → Counts the filtered words.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the most frequent character in a string**.

#### **Input:**
```java
String input = "success";
```

#### **Expected Output:**
```
s
```

👉 **Try it!** 🚀



Here’s the **correct solution** using Java Streams to find the **most frequent character** in a string:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        String input = "success";

        // Find the most frequent character
        Optional<Character> mostFrequentChar = input.chars() // Convert to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())) // Count occurrences
                .entrySet().stream() // Convert Map to Stream
                .max(Map.Entry.comparingByValue()) // Get the entry with the highest value (max count)
                .map(Map.Entry::getKey); // Extract the character

        mostFrequentChar.ifPresent(System.out::println); // Output: s
    }
}
```

---

### **✅ Expected Output:**
```
s
```

---
### **🔹 Explanation:**
1. `.chars()` → Converts the string into an **IntStream** of ASCII values.
2. `.mapToObj(c -> (char) c)` → Converts ASCII values into **Character objects**.
3. `.collect(Collectors.groupingBy(c -> c, Collectors.counting()))`
   - Groups characters and counts their occurrences.
4. `.entrySet().stream().max(Map.Entry.comparingByValue())`
   - Finds the **character with the highest frequency**.
5. `.map(Map.Entry::getKey)` → Extracts the character.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **sort a list of strings by their length in ascending order**.

#### **Input:**
```java
List<String> words = Arrays.asList("banana", "apple", "cherry", "kiwi", "grape");
```

#### **Expected Output:**
```java
[kiwi, apple, grape, banana, cherry]
```

👉 **Try it!** 🚀


Here’s the **correct solution** using Java Streams to sort a list of strings by their length in ascending order:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "kiwi", "grape");

        // Sort words by their length in ascending order
        List<String> sortedWords = words.stream()
                .sorted(Comparator.comparingInt(String::length)) // Compare by string length
                .collect(Collectors.toList()); // Collect into a list

        System.out.println(sortedWords);
    }
}
```

---

### **✅ Expected Output:**
```java
[kiwi, apple, grape, banana, cherry]
```

---
### **🔹 Explanation:**
1. `.stream()` → Converts the list into a **Stream**.
2. `.sorted(Comparator.comparingInt(String::length))` → Sorts by **string length** in ascending order.
3. `.collect(Collectors.toList())` → Converts the sorted stream back to a **List**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the sum of all even numbers in a list**.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
```

#### **Expected Output:**
```java
30
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to find the sum of all even numbers in a list:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculate sum of even numbers
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum(); // Sum all values

        System.out.println(sumOfEvens); // Output: 30
    }
}
```

---

### **✅ Expected Output:**
```
30
```

---
### **🔹 Explanation:**
1. `.filter(n -> n % 2 == 0)` → Filters **only even numbers**.
2. `.mapToInt(Integer::intValue)` → Converts `Integer` objects to primitive `int` (for efficiency).
3. `.sum()` → Computes the **sum of the filtered numbers**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the second smallest number** in a list of integers.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(4, 1, 7, 3, 9, 7, 9, 2);
```

#### **Expected Output:**
```java
2
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to find the **second smallest number** in a list:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 1, 7, 3, 9, 7, 9, 2);

        // Find the second smallest number
        Optional<Integer> secondSmallest = numbers.stream()
                .distinct() // Remove duplicates
                .sorted() // Sort in ascending order
                .skip(1) // Skip the first (smallest) element
                .findFirst(); // Get the second smallest element

        secondSmallest.ifPresent(System.out::println); // Output: 2
    }
}
```

---

### **✅ Expected Output:**
```
2
```

---
### **🔹 Explanation:**
1. `.distinct()` → Removes **duplicates** from the list.
2. `.sorted()` → Sorts the numbers in **ascending order**.
3. `.skip(1)` → Skips the **first (smallest) element**.
4. `.findFirst()` → Retrieves the **second smallest** element.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **reverse each string in a list**.

#### **Input:**
```java
List<String> words = Arrays.asList("java", "stream", "example");
```

#### **Expected Output:**
```java
[avaj, maerts, elpmaxe]
```

👉 **Try it!** 🚀


Here’s the **correct solution** using Java Streams to **reverse each string in a list**:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "example");

        // Reverse each word in the list
        List<String> reversedWords = words.stream()
                .map(word -> new StringBuilder(word).reverse().toString()) // Reverse each word
                .collect(Collectors.toList()); // Collect into a List

        System.out.println(reversedWords);
    }
}
```

---

### **✅ Expected Output:**
```java
[avaj, maerts, elpmaxe]
```

---
### **🔹 Explanation:**
1. `.map(word -> new StringBuilder(word).reverse().toString())`
   - Converts each word into a `StringBuilder`, reverses it, and converts it back to a string.
2. `.collect(Collectors.toList())` → Collects the transformed words into a **List**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the sum of squares of all odd numbers in a list**.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
```

#### **Expected Output:**
```
165
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find the sum of squares of all odd numbers** in a list:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Calculate sum of squares of odd numbers
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 != 0) // Keep only odd numbers
                .map(n -> n * n) // Square each number
                .reduce(0, Integer::sum); // Sum up all squared values

        System.out.println(sumOfSquares); // Output: 165
    }
}
```

---

### **✅ Expected Output:**
```
165
```

---
### **🔹 Explanation:**
1. `.filter(n -> n % 2 != 0)` → Keeps only **odd numbers**.
2. `.map(n -> n * n)` → Squares each **odd number**.
3. `.reduce(0, Integer::sum)` → Computes the **sum of squared numbers**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the longest word in a list and return its length**.

#### **Input:**
```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "grape");
```

#### **Expected Output:**
```
9
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find the longest word in a list and return its length**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "grape");

        // Find the length of the longest word
        OptionalInt longestLength = words.stream()
                .mapToInt(String::length) // Convert words to their lengths
                .max(); // Find the maximum length

        longestLength.ifPresent(System.out::println); // Output: 9
    }
}
```

---

### **✅ Expected Output:**
```
9
```

---
### **🔹 Explanation:**
1. `.mapToInt(String::length)` → Converts each word into its **length**.
2. `.max()` → Finds the **maximum length** in the list.
3. `.ifPresent(System.out::println)` → Prints the result **only if it's present**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **concatenate all words in a list, separated by commas**.

#### **Input:**
```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "grape");
```

#### **Expected Output:**
```
apple, banana, cherry, blueberry, grape
```

👉 **Try it!** 🚀


Here’s the **correct solution** using Java Streams to **concatenate all words in a list, separated by commas**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "grape");

        // Concatenate words with commas
        String result = words.stream()
                .collect(Collectors.joining(", ")); // Join elements with a comma and space

        System.out.println(result); // Output: apple, banana, cherry, blueberry, grape
    }
}
```

---

### **✅ Expected Output:**
```
apple, banana, cherry, blueberry, grape
```

---
### **🔹 Explanation:**
1. `.stream()` → Converts the **List** into a **Stream**.
2. `.collect(Collectors.joining(", "))`
   - Joins all elements into a **single string**.
   - Uses `", "` as a **separator**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **count the number of vowels in a given string**.

#### **Input:**
```java
String input = "programming";
```

#### **Expected Output:**
```
3
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **count the number of vowels in a given string**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        String input = "programming";

        // Define vowels
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        // Count vowels in the string
        long vowelCount = input.chars() // Convert string to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .filter(c -> vowels.contains(c)) // Keep only vowels
                .count(); // Count remaining characters

        System.out.println(vowelCount); // Output: 3
    }
}
```

---

### **✅ Expected Output:**
```
3
```

---
### **🔹 Explanation:**
1. `.chars()` → Converts the string into an **IntStream** of character ASCII values.
2. `.mapToObj(c -> (char) c)` → Converts each **ASCII value** into a **Character object**.
3. `.filter(c -> vowels.contains(c))` → Filters **only vowels**.
4. `.count()` → Counts the **remaining vowels**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the product of all numbers in a list**.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
```

#### **Expected Output:**
```
120
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find the product of all numbers in a list**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // Calculate product of all numbers
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b); // Multiply each element

        System.out.println(product); // Output: 120
    }
}
```

---

### **✅ Expected Output:**
```
120
```

---
### **🔹 Explanation:**
1. `.reduce(1, (a, b) -> a * b)`
   - Uses **reduce** with `1` as the initial value.
   - Multiplies elements together to get the **product**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find all distinct characters in a given string**.

#### **Input:**
```java
String input = "mississippi";
```

#### **Expected Output:**
```java
[m, i, s, p]
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find all distinct characters in a given string**:

---

### **Solution:**
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        String input = "mississippi";

        // Find distinct characters in the string
        List<Character> distinctChars = input.chars() // Convert string to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .distinct() // Remove duplicates
                .collect(Collectors.toList()); // Collect into a list

        System.out.println(distinctChars); // Output: [m, i, s, p]
    }
}
```

---

### **✅ Expected Output:**
```java
[m, i, s, p]
```

---
### **🔹 Explanation:**
1. `.chars()` → Converts the string into an **IntStream** of character ASCII values.
2. `.mapToObj(c -> (char) c)` → Converts each **ASCII value** into a **Character object**.
3. `.distinct()` → Removes **duplicate characters**.
4. `.collect(Collectors.toList())` → Collects the distinct characters into a **List**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the average of all numbers in a list**.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
```

#### **Expected Output:**
```
30.0
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find the average of all numbers in a list**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Calculate the average of all numbers
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue) // Convert to IntStream
                .average(); // Compute the average

        // Print the result
        average.ifPresent(System.out::println); // Output: 30.0
    }
}
```

---

### **✅ Expected Output:**
```
30.0
```

---
### **🔹 Explanation:**
1. `.mapToInt(Integer::intValue)` → Converts the list to an **IntStream**.
2. `.average()` → Computes the **average value**.
3. `.ifPresent(System.out::println)` → Prints the result **only if present**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the first non-repeating character in a string**.

#### **Input:**
```java
String input = "swiss";
```

#### **Expected Output:**
```
w
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find the first non-repeating character in a string**:

---

### **Solution:**
```java
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class StreamExample {
    public static void main(String[] args) {
        String input = "swiss";

        // Find the first non-repeating character
        Optional<Character> firstNonRepeating = input.chars() // Convert string to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(LinkedHashMap::new, (map, ch) -> map.put(ch, map.getOrDefault(ch, 0) + 1), Map::putAll)
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Find characters that appear only once
                .map(Map.Entry::getKey) // Extract the character
                .findFirst(); // Get the first non-repeating character

        // Print the result
        firstNonRepeating.ifPresent(System.out::println); // Output: w
    }
}
```

---

### **✅ Expected Output:**
```
w
```

---
### **🔹 Explanation:**
1. `.chars()` → Converts the string into an **IntStream**.
2. `.mapToObj(c -> (char) c)` → Converts each ASCII value into a **Character object**.
3. `.collect(LinkedHashMap::new, (map, ch) -> map.put(ch, map.getOrDefault(ch, 0) + 1), Map::putAll)`
   - Stores character counts in a **LinkedHashMap** (preserves order).
4. `.entrySet().stream().filter(entry -> entry.getValue() == 1)`
   - Filters characters that **appear only once**.
5. `.map(Map.Entry::getKey).findFirst()`
   - Retrieves the **first non-repeating character**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **sort a list of numbers in descending order**.

#### **Input:**
```java
List<Integer> numbers = Arrays.asList(5, 1, 8, 3, 7, 2);
```

#### **Expected Output:**
```
[8, 7, 5, 3, 2, 1]
```

👉 **Try it!** 🚀

Here’s how you can use **Java Streams** to map a list of one object type to another using only the **required fields**.

---

### **Example Scenario:**
We have a list of **Employee** objects, but we only need to map certain fields (`name` and `salary`) to a new **EmployeeDTO** object.

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    // Constructor
    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

// Target DTO class with only required fields
class EmployeeDTO {
    private String name;
    private double salary;

    // Constructor
    public EmployeeDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // toString method for display
    @Override
    public String toString() {
        return "EmployeeDTO{name='" + name + "', salary=" + salary + "}";
    }
}

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000, "IT"),
                new Employee("Jane", 25, 60000, "HR"),
                new Employee("Alice", 28, 70000, "Finance")
        );

        // Map Employee to EmployeeDTO with only required fields
        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary())) // Extract required fields
                .collect(Collectors.toList());

        // Print the mapped DTO list
        employeeDTOs.forEach(System.out::println);
    }
}
```

---

### **✅ Expected Output:**
```
EmployeeDTO{name='John', salary=50000.0}
EmployeeDTO{name='Jane', salary=60000.0}
EmployeeDTO{name='Alice', salary=70000.0}
```

---
### **🔹 Explanation:**
1. `.stream()` → Converts `List<Employee>` to a Stream.
2. `.map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))`
   - Maps **only the required fields** to `EmployeeDTO`.
3. `.collect(Collectors.toList())` → Converts back to a **List**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **filter employees with salary greater than 60,000 and map them to EmployeeDTO**.

#### **Input:**
```java
List<Employee> employees = Arrays.asList(
    new Employee("John", 30, 50000, "IT"),
    new Employee("Jane", 25, 60000, "HR"),
    new Employee("Alice", 28, 70000, "Finance"),
    new Employee("Bob", 35, 80000, "Marketing")
);
```

#### **Expected Output:**
```
EmployeeDTO{name='Alice', salary=70000.0}
EmployeeDTO{name='Bob', salary=80000.0}
```

👉 **Try it!** 🚀


Here’s the **correct solution** using Java Streams to **filter employees with salary greater than 60,000 and map them to EmployeeDTO**:

---

### **Solution:**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    // Constructor
    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

// Target DTO class with only required fields
class EmployeeDTO {
    private String name;
    private double salary;

    // Constructor
    public EmployeeDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // toString method for display
    @Override
    public String toString() {
        return "EmployeeDTO{name='" + name + "', salary=" + salary + "}";
    }
}

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000, "IT"),
                new Employee("Jane", 25, 60000, "HR"),
                new Employee("Alice", 28, 70000, "Finance"),
                new Employee("Bob", 35, 80000, "Marketing")
        );

        // Filter employees with salary > 60,000 and map them to EmployeeDTO
        List<EmployeeDTO> filteredEmployees = employees.stream()
                .filter(emp -> emp.getSalary() > 60000) // Filter employees
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary())) // Map to DTO
                .collect(Collectors.toList());

        // Print the mapped DTO list
        filteredEmployees.forEach(System.out::println);
    }
}
```

---

### **✅ Expected Output:**
```
EmployeeDTO{name='Alice', salary=70000.0}
EmployeeDTO{name='Bob', salary=80000.0}
```

---
### **🔹 Explanation:**
1. `.filter(emp -> emp.getSalary() > 60000)` → Filters employees **earning more than 60,000**.
2. `.map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))`
   - Converts filtered employees to `EmployeeDTO` with **only required fields**.
3. `.collect(Collectors.toList())` → Collects the results into a **List**.
4. `.forEach(System.out::println)` → Prints the final **filtered and mapped employees**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **group employees by department** and return a `Map<String, List<EmployeeDTO>>`.

#### **Input:**
```java
List<Employee> employees = Arrays.asList(
    new Employee("John", 30, 50000, "IT"),
    new Employee("Jane", 25, 60000, "HR"),
    new Employee("Alice", 28, 70000, "Finance"),
    new Employee("Bob", 35, 80000, "Marketing"),
    new Employee("Charlie", 40, 55000, "IT")
);
```

#### **Expected Output:**
```java
{IT=[EmployeeDTO{name='John', salary=50000.0}, EmployeeDTO{name='Charlie', salary=55000.0}], 
 HR=[EmployeeDTO{name='Jane', salary=60000.0}], 
 Finance=[EmployeeDTO{name='Alice', salary=70000.0}], 
 Marketing=[EmployeeDTO{name='Bob', salary=80000.0}]}
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **group employees by department and map them to EmployeeDTO**:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    // Constructor
    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
}

// Target DTO class with only required fields
class EmployeeDTO {
    private String name;
    private double salary;

    // Constructor
    public EmployeeDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // toString method for display
    @Override
    public String toString() {
        return "EmployeeDTO{name='" + name + "', salary=" + salary + "}";
    }
}

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000, "IT"),
                new Employee("Jane", 25, 60000, "HR"),
                new Employee("Alice", 28, 70000, "Finance"),
                new Employee("Bob", 35, 80000, "Marketing"),
                new Employee("Charlie", 40, 55000, "IT")
        );

        // Group employees by department and map them to EmployeeDTO
        Map<String, List<EmployeeDTO>> groupedEmployees = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Group by department
                        Collectors.mapping(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()), Collectors.toList()) // Convert to DTO
                ));

        // Print the grouped map
        System.out.println(groupedEmployees);
    }
}
```

---

### **✅ Expected Output:**
```java
{IT=[EmployeeDTO{name='John', salary=50000.0}, EmployeeDTO{name='Charlie', salary=55000.0}], 
 HR=[EmployeeDTO{name='Jane', salary=60000.0}], 
 Finance=[EmployeeDTO{name='Alice', salary=70000.0}], 
 Marketing=[EmployeeDTO{name='Bob', salary=80000.0}]}
```

---

### **🔹 Explanation:**
1. `.collect(Collectors.groupingBy(Employee::getDepartment, ...))`
   - Groups employees by **department**.
2. `.mapping(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()), Collectors.toList())`
   - Maps employees to **EmployeeDTO**.
3. **Result** → A `Map<String, List<EmployeeDTO>>` where:
   - **Key** = Department name.
   - **Value** = List of `EmployeeDTO` objects for that department.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **find the department with the highest average salary**.

#### **Input:**
```java
List<Employee> employees = Arrays.asList(
    new Employee("John", 30, 50000, "IT"),
    new Employee("Jane", 25, 60000, "HR"),
    new Employee("Alice", 28, 70000, "Finance"),
    new Employee("Bob", 35, 80000, "Marketing"),
    new Employee("Charlie", 40, 55000, "IT")
);
```

#### **Expected Output:**
```
Marketing
```

👉 **Try it!** 🚀

Here’s the **correct solution** using Java Streams to **find the department with the highest average salary**:

---

### **Solution:**
```java
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    // Constructor
    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
}

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, 50000, "IT"),
                new Employee("Jane", 25, 60000, "HR"),
                new Employee("Alice", 28, 70000, "Finance"),
                new Employee("Bob", 35, 80000, "Marketing"),
                new Employee("Charlie", 40, 55000, "IT")
        );

        // Find the department with the highest average salary
        String highestAvgSalaryDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, 
                        Collectors.averagingDouble(Employee::getSalary))) // Calculate avg salary per department
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Find department with max average salary
                .map(Map.Entry::getKey) // Extract department name
                .orElse("No department found");

        System.out.println(highestAvgSalaryDept); // Output: Marketing
    }
}
```

---

### **✅ Expected Output:**
```
Marketing
```

---

### **🔹 Explanation:**
1. `.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))`
   - Groups employees **by department** and **calculates the average salary**.
2. `.entrySet().stream().max(Map.Entry.comparingByValue())`
   - Finds the **department with the highest average salary**.
3. `.map(Map.Entry::getKey).orElse("No department found")`
   - Extracts the department name **or returns a default message**.

---

### **Next Coding Question (Expert Level)**
Write a Java program using Streams to **partition employees into two groups: those earning above 60,000 and those earning 60,000 or below**.

#### **Expected Output:**
```java
{
    true=[Employee{name='Alice', salary=70000.0}, Employee{name='Bob', salary=80000.0}], 
    false=[Employee{name='John', salary=50000.0}, Employee{name='Jane', salary=60000.0}, Employee{name='Charlie', salary=55000.0}]
}
```

👉 **Try it!** 🚀

