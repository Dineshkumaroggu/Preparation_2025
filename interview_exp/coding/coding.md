
> **"You have a list of students with ID, firstname, and CGPA. Sort them by:**
>
> * **CGPA (descending)**
> * **Firstname (ascending)**
> * **ID (ascending, if needed)"**

You’ll get **two versions**:

1. ✅ **Normal sorting using `Collections.sort()`**
2. ✅ **Stream-based sorting using Java 8+ Streams**

---

### ✅ 1. Normal Sorting (Using `Collections.sort()` with Comparator)

```java
import java.util.*;

class Student {
    int id;
    String firstname;
    double cgpa;

    Student(int id, String firstname, double cgpa) {
        this.id = id;
        this.firstname = firstname;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return firstname + " - " + cgpa + " (ID: " + id + ")";
    }
}

public class SortStudentsNormal {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(33, "Tina", 3.68));
        students.add(new Student(85, "Louis", 3.85));
        students.add(new Student(56, "Samil", 3.75));
        students.add(new Student(19, "Samil", 3.75));
        students.add(new Student(22, "Ally", 3.85));

        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (s1.cgpa != s2.cgpa) {
                    return Double.compare(s2.cgpa, s1.cgpa); // Descending CGPA
                } else if (!s1.firstname.equals(s2.firstname)) {
                    return s1.firstname.compareTo(s2.firstname); // Ascending Firstname
                } else {
                    return Integer.compare(s1.id, s2.id); // Ascending ID
                }
            }
        });

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
```

---

### ✅ 2. Stream-based Sorting (Java 8+)

```java
import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String firstname;
    double cgpa;

    Student(int id, String firstname, double cgpa) {
        this.id = id;
        this.firstname = firstname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return firstname + " - " + cgpa + " (ID: " + id + ")";
    }
}

public class SortStudentsStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(33, "Tina", 3.68),
            new Student(85, "Louis", 3.85),
            new Student(56, "Samil", 3.75),
            new Student(19, "Samil", 3.75),
            new Student(22, "Ally", 3.85)
        );

        List<Student> sorted = students.stream()
            .sorted(Comparator.comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getFirstname)
                .thenComparingInt(Student::getId))
            .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }
}
```

---

### 🧪 Sample Output (Both Versions):

```
Ally - 3.85 (ID: 22)
Louis - 3.85 (ID: 85)
Samil - 3.75 (ID: 19)
Samil - 3.75 (ID: 56)
Tina - 3.68 (ID: 33)
```

---



Here are some **Java coding questions** based on splitting a string like `s = "10,sdd,$20,60"` by commas, with various logic you might be asked to implement in interviews or tests:

---

## 🔹 Sample Input:

```java
String s = "10,sdd,$20,60";
```

## 🔧 1. **Split the string by comma and print all parts**

```java
String[] parts = s.split(",");
for (String part : parts) {
    System.out.println(part);
}
```

---

## ✅ Java Coding Questions on This:

### 1. **Print only numeric values**

```java
// Output: 10, 60
for (String part : s.split(",")) {
    if (part.matches("\\d+")) {
        System.out.println(part);
    }
}
```

---

### 2. **Sum all numeric values**

```java
int sum = 0;
for (String part : s.split(",")) {
    if (part.matches("\\d+")) {
        sum += Integer.parseInt(part);
    }
}
System.out.println("Sum = " + sum); // Output: 70
```

---

### 3. **Print values starting with `$`**

```java
// Output: $20
for (String part : s.split(",")) {
    if (part.startsWith("$")) {
        System.out.println(part);
    }
}
```

---

### 4. **Count alphabetic strings only**

```java
int count = 0;
for (String part : s.split(",")) {
    if (part.matches("[a-zA-Z]+")) {
        count++;
    }
}
System.out.println("Alpha count = " + count); // Output: 1
```

---

### 5. **Convert numeric strings to integers and store in a list**

```java
List<Integer> numbers = new ArrayList<>();
for (String part : s.split(",")) {
    if (part.matches("\\d+")) {
        numbers.add(Integer.parseInt(part));
    }
}
System.out.println(numbers); // Output: [10, 60]
```

---

### 6. **Separate values into numbers, words, and special tokens**

```java
List<String> digits = new ArrayList<>();
List<String> words = new ArrayList<>();
List<String> special = new ArrayList<>();

for (String part : s.split(",")) {
    if (part.matches("\\d+")) digits.add(part);
    else if (part.matches("[a-zA-Z]+")) words.add(part);
    else special.add(part);
}

System.out.println("Digits: " + digits);
System.out.println("Words: " + words);
System.out.println("Special: " + special);
```

---

### 7. **Replace `$` with nothing and sum the value**

```java
int sum = 0;
for (String part : s.split(",")) {
    if (part.startsWith("$")) {
        String num = part.substring(1);
        if (num.matches("\\d+")) {
            sum += Integer.parseInt(num);
        }
    }
}
System.out.println("Sum of $ values = " + sum); // Output: 20
```

---

Let me know if you'd like these turned into unit testable methods or more advanced challenges like stream-based processing or regex filtering.
To split a **string into individual characters** in Java, you can do it in several simple ways. Here's how:

---

## ✅ 1. **Using `toCharArray()`**

This is the **most efficient** and recommended way.

```java
String s = "abc123";
char[] chars = s.toCharArray();

for (char c : chars) {
    System.out.println(c);
}
```

---

## ✅ 2. **Using `split("")`**

This splits the string into an array of single-character strings.

```java
String s = "abc123";
String[] chars = s.split("");

for (String ch : chars) {
    System.out.println(ch);
}
```

> ⚠️ `split("")` adds an **empty string at the start** sometimes. So prefer `toCharArray()` for clean results.

---

## ✅ 3. **Using a Loop (Manual method)**

You can also iterate through the string using `charAt()`:

```java
String s = "abc123";

for (int i = 0; i < s.length(); i++) {
    System.out.println(s.charAt(i));
}
```

---

## 🎯 Output Example (for input `abc123`):

```
a
b
c
1
2
3
```

---

### 🔍 Want to identify character types too?

You can combine with `Character` utility methods:

```java
char ch = 'a';
Character.isDigit(ch);     // true if it's a digit
Character.isLetter(ch);    // true if it's a letter
Character.isLetterOrDigit(ch); // true if alphanumeric
Character.isUpperCase(ch);
Character.isLowerCase(ch);
```

Let me know if you want to split into a list, filter only digits, or convert to ASCII codes too!
Great! Let's solve **frequency of characters in a word** using:

1. ✅ **Traditional Map-based approach**
2. ✅ **Java 8 Streams approach**

---

### 🔠 Sample input:

```java
String input = "banana";
```

---

## ✅ 1. **Using Normal Map (Traditional way)**

```java
import java.util.*;

public class CharFrequencyMap {
    public static void main(String[] args) {
        String input = "banana";
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println(freqMap); // Output: {a=3, b=1, n=2}
    }
}
```

---

## ✅ 2. **Using Java 8 Streams**

```java
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFrequencyStream {
    public static void main(String[] args) {
        String input = "banana";

        Map<Character, Long> freqMap = input.chars() // IntStream of Unicode code points
            .mapToObj(c -> (char) c)                  // convert to Character
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));

        System.out.println(freqMap); // Output: {a=3, b=1, n=2}
    }
}
```

---

## 🧾 Output for `"banana"` in both:

```java
{a=3, b=1, n=2}
```

---

### ✅ Summary:

| Approach      | Output Type               | Notes                |
| ------------- | ------------------------- | -------------------- |
| Map Loop      | `Map<Character, Integer>` | Simple and efficient |
| Java 8 Stream | `Map<Character, Long>`    | Elegant and concise  |

Let me know if you'd like to sort the map by frequency or print the result in descending order!

