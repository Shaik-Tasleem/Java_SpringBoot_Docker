package practise;

import java.util.*;
import java.util.stream.Collectors;

class EmptyListException extends RuntimeException {
    public EmptyListException(String message) {
        super(message);
    }
}
public class scores {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, null, 3, 4, 5, 6, 7, 8, 9);
        try {
            Map<String, List<Integer>> categorizedNumbers = categorizeNumbers(numbers);
            System.out.println(categorizedNumbers);
        } catch (EmptyListException e) {
            System.err.println(e.getMessage());
        }
    }
    public static Map<String, List<Integer>> categorizeNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new EmptyListException("empty list");
        }
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num % 2 == 0 ? "Even" : "Odd"
                ));
    }
}
