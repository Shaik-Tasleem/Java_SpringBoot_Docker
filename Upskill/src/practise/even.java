package practise;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

 class main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(isEven)
                                           .collect(Collectors.toList());

      
        System.out.println("Even numbers: " + evenNumbers);
    }
}
