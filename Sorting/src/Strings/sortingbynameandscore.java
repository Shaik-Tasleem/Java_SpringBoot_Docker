package Strings;

import java.util.Arrays;
import java.util.Comparator;

class student{
	private String name;
	private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", score=" + score + "]";
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
public class sortingbynameandscore {
public static void main(String[] args) {
	student[] string= {
			new student("John",10),
			new student("John", 15),
			new student("beige", 11),
			new student("shaw",20)
	};
	Arrays.sort(string,Comparator.comparingInt(student::getScore).reversed().thenComparing(student::getName));
	System.out.println(Arrays.toString(string));
}
}
