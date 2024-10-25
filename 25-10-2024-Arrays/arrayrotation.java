package practice;

import java.util.Scanner;

public class Arrayrightrota {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("enter your array elements");
		for(int i=0;i<n;i++) {
		 arr[i]=sc.nextInt();
		}
		k=k%n;
		rotate(arr,k);
		for(int i:arr) {
			System.out.println("rotated array is :"+i +" ");
		}
	}
	public static void rotate(int[] arr,int k) {
		rev(arr,0,arr.length-1);
		rev(arr,0,k-1);
		rev(arr,k,arr.length-1);
	}
	public static void rev(int[] arr,int s,int e) {
		while(s<e) {
			int tem=arr[s];
			arr[s]=arr[e];
			arr[e]=tem;
			s++;
			e--;
		}
		
	}
}
