Your answer is on the right track but needs more clarity. Let me refine it:  

A **Java Stream** is a sequence of elements that can be processed in a **functional style**. It provides a high-level abstraction for operations on collections, supporting methods like **filter, map, reduce, and forEach**.  

### **Key Differences Between Stream and Collection:**
1. **Streams do not store data** – They operate on the source (like a Collection) and produce results.
2. **Streams are functional in nature** – They allow method chaining and declarative programming.
3. **Streams support lazy evaluation** – Intermediate operations (e.g., `filter`, `map`) are not executed until a terminal operation (e.g., `collect`, `forEach`) is invoked.
4. **Streams can be parallelized** – This enables efficient multi-threaded processing.
5. **Streams are one-time use** – Once processed, they cannot be reused, unlike collections.

✅ **Your answer was close!** Now, let’s move to the next question.

### **Question 2 (Basic Level)**
What are the two types of Java Streams? Explain them briefly.

