package com.practice.java.atm.transaction;

import java.util.Scanner;

public class UserATMTransaction {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to ATM");

		System.out.print("Enter your customer id :");
		int customer_id = sc.nextInt();

		System.out.print("Enter Password : ");
		String password = sc.next();

		// ATMController ac = new ATMController(customer_id, password);

		ATMController ac = new ATMController();

		ac.setATMService(new ServiceImpl()); // Set the ATMService object

		ac.userVerification(customer_id, password);

		System.out.println();

		System.out.println("Please select from the below options:");
		System.out.println("1. To check the Balance");
		System.out.println("2. To Desposit into Account");
		System.out.println("3. To WithDraw the Amount");
		System.out.println("4. To print the mini statement");
		System.out.println("5. Transaction completed. Exit");

		System.out.print("Choose an Option: ");
		int option;

		System.out.println();
		do {
			
			option = sc.nextInt();
			
			switch (option) {

			case 1:
				ac.balanceInfo();
				System.out.print("Choose an Option: ");
				
				break;
			case 2:
				System.out.print("Enter the amount to be deposited: ");
				ac.cashDeposit(sc.nextDouble());
				System.out.print("Choose an Option: ");
				break;
			case 3:
				System.out.print("Enter the amount to be withdrawn: ");
				ac.withDrawCash(sc.nextDouble());
				System.out.print("Choose an Option: ");
				break;
			case 4:
				ac.viewMiniStatement();
				System.out.print("Choose an Option: ");
				break;
			case 5:
				System.out.println("Transaction is completed. Thank you for coming!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid option, please choose again.");

			}
		}while(option !=5);
		//sc.close();

	}

}