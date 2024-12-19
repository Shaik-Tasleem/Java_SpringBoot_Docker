package enums;

import java.util.Scanner;

public class trafficlight{
	enum Trafficcolor{
		RED,GREEN,YELLOW
	}
	public static Trafficcolor getnext(Trafficcolor color) {
		switch (color) {
		case RED:
			return Trafficcolor.GREEN;
		case GREEN:
			return Trafficcolor.YELLOW;
		case YELLOW:
			return Trafficcolor.RED;
		default: 
			throw new IllegalArgumentException("unexpected value");
		}
	}
	public static void printcolor(Trafficcolor color) {
		switch (color) {
		case RED:
			System.out.println("RED");
			break;
		case GREEN:
			System.out.println("GREEN");
			break;
		case YELLOW:
			System.out.println("YELLOW");
			break;
			
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int iteration=sc.nextInt();
		for(int i=0;i<=iteration;i++) {
			System.out.println("enter your n value");
			int n=sc.nextInt();
			Trafficcolor color;
			if(n==1) {
				color=Trafficcolor.RED;
			}else if(n==2) {
				color=Trafficcolor.GREEN;
			}else {
				color=Trafficcolor.YELLOW;
			}
			color=getnext(color);
			printcolor(color);
		}
	}
}