package practice;

import java.util.Scanner;

public class MainDiagnalsum {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter size");
	int n= sc.nextInt();
	int[][] matrix=new int[n][n];
	System.out.println("enter your elements");
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			matrix[i][j]=sc.nextInt();
		}
	}
	int diagsum=0;
	for(int i=0;i<n;i++) {
		diagsum+=matrix[i][i];
	}
	System.out.println(diagsum);
	
}
}
