package Strings;

import java.util.Arrays;
import java.util.Comparator;

public class Sortingbylength {
public static void main(String[] args) {
	String[] string= {"apple", "pie", "banana", "kiwi", "pear"};
	Arrays.sort(string,Comparator.comparingInt(String::length));
	System.out.println(Arrays.toString(string));
}
}
