package enums;

import java.util.Scanner;

public enum cards {
	CREDIT_CARD(2.0),
	DEBIT_CARD(1.5),
	CASH(0.0);
	private final double feepercentage;
	cards(double feepercentage) {
		this.feepercentage=feepercentage;
	}
	public double getFeePercentage() {
		return feepercentage;
	}
	public double total(double amount) {
		double fee=(feepercentage/100)* amount;
		return amount+fee;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your amount");
		double amount=sc.nextDouble();
		for(cards card:cards.values()) {
			System.out.printf("Payment Method: %s | Total Amount: %.2f | Fee Percentage: %.2f%%%n", 
	                  card, 
	                  card.total(amount), 
	                  card.getFeePercentage());		}
	}

}
