import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class streamsprep {

    public static void main(String[] args) {
        // filter out even
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // numbers.stream().filter(n->n%2==0).forEach(System.out::println);

        // convert to upercase
        List<String> words = Arrays.asList("apple", "bannana", "cat");

        List<String> capwords = words.stream().map(String::toUpperCase).collect(Collectors.toList());

        // System.out.println(capwords);

        // TO FIND OUT first string start with b
        List<String> words1 = Arrays.asList("apple", "bannana", "cat", "begerhhhh");

        Optional<String> res = words1.stream().filter(s -> s.startsWith("b")).findFirst();

        // res.ifPresent(System.out::println);

        // to finf the longest word in array
        String longest = words1.stream().reduce("", (word1, word2) -> word1.length() >= word2.length() ? word1 : word2);

        System.out.println(longest);

        // // Using max() to find the longest word
        // Optional<String> longestWord = words.stream()
        // .max((a, b) -> Integer.compare(a.length(), b.length()));

        // longestWord.ifPresent(System.out::println);

        // Write a Java program using Streams to group a list of strings by their first
        // letter into a Map<Character, List<String>>.
        List<String> mywords = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry", "carrot");

        // Group words by their first letter
        Map<Character, List<String>> groupedWords = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // System.out.println(groupedWords);

        // Write a Java program using Streams to find the frequency of each character in
        // a given string.

        String input = "banana";

        // Convert the string to a character stream, then group by character and count
        // occurrences
        Map<Character, Long> charFrequency = input.chars() // Convert to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Count occurrences

        // System.out.println(charFrequency);

        // Write a Java program using Streams to find the second highest number in a
        // list of integers.

        List<Integer> snumbers = Arrays.asList(4, 1, 7, 3, 9, 7, 9);

        // Find the second highest number
        Optional<Integer> secondHighest = snumbers.stream()
                .distinct() // Remove duplicates
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .skip(1) // Skip the first (highest) element
                .findFirst(); // Get the next highest number

        // secondHighest.ifPresent(System.out::println); // Output: 7

        // Write a Java program using Streams to find the longest word in a sentence.

        String sentence = "Java streams provide a powerful way to process collections";

        // Find the longest word using streams
        Optional<String> longestWord = Arrays.stream(sentence.split(" ")) // Convert sentence to a Stream of words
                .reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2);

        longestWord.ifPresent(System.out::println); // Output: collections

        // Write a Java program using Streams to count the number of words in a sentence
        // that have more than 4 letters.

        // Count words with more than 4 letters
        long count = Arrays.stream(sentence.split(" ")) // Convert sentence to a Stream of words
                .filter(word -> word.length() > 4) // Filter words with length > 4
                .count(); // Count the remaining words

        // System.out.println(count); // Output: 4

        // Write a Java program using Streams to find the most frequent character in a
        // string.

        String input2 = "success";

        // Find the most frequent character
        Optional<Character> mostFrequentChar = input2.chars() // Convert to IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())) // Count occurrences
                .entrySet().stream() // Convert Map to Stream
                .max(Map.Entry.comparingByValue()) // Get the entry with the highest value (max count)
                .map(Map.Entry::getKey); // Extract the character

        mostFrequentChar.ifPresent(System.out::println); // Output: s

        // Write a Java program using Streams to sort a list of strings by their length
        // in ascending order.

        List<String> words2 = Arrays.asList("banana", "apple", "cherry", "kiwi", "grape");

        // Sort words by their length in ascending order
        List<String> sortedWords = words2.stream()
                .sorted(Comparator.comparingInt(String::length)) // Compare by string length
                .collect(Collectors.toList()); // Collect into a list

        System.out.println(sortedWords);

        // Write a Java program using Streams to find the sum of all even numbers in a
        // list.

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Calculate sum of even numbers
        int sumOfEvens = numbers2.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum(); // Sum all values

        System.out.println(sumOfEvens); // Output: 30


        // Write a Java program using Streams to reverse each string in a list.

        List<String> words3 = Arrays.asList("java", "stream", "example");

        // Reverse each word in the list
        List<String> reversedWords = words3.stream()
                .map(word -> new StringBuilder(word).reverse().toString()) // Reverse each word
                .collect(Collectors.toList()); // Collect into a List

        System.out.println(reversedWords);



        // Write a Java program using Streams to find the sum of squares of all odd numbers in a list.

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Calculate sum of squares of odd numbers
        int sumOfSquares = numbers4.stream()
                .filter(n -> n % 2 != 0) // Keep only odd numbers
                .map(n -> n * n) // Square each number
                .reduce(0, Integer::sum); // Sum up all squared values

        System.out.println(sumOfSquares); // Output: 165



        






    }
}
