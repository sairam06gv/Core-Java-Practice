package com.practice.java.atm.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ServiceImpl implements ATMProvidedServices {

	ATMDto atm = new ATMDto();

	Map<String, Double> miniStatement = new HashMap<>();
	

	@Override
	public void balanceEnquiry() {

		System.out.println("Current Balance : " + atm.getBalance());

	}

	@Override
	public void deposit(double amount) {

		atm.setBalance(atm.getBalance() + amount);
		System.out.println("Deposit is successful. Deposit Amount : " + amount);
		String transactiontime ="Transaction time: " + getCurrentTime() + ". Deposit amount  -> ";
		miniStatement.put(transactiontime, amount);                          
		balanceEnquiry();

	}
	
	@Override
	public void viewMiniStatement() {
		for (Map.Entry<String, Double> entry : miniStatement.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	@Override
	public void withdrawal(double amount) {

		if (atm.getBalance() >= amount) {
			
			String transactiontime ="Transaction time: " + getCurrentTime() + ". Withdrwal amount-> ";
			miniStatement.put(transactiontime, amount);
			atm.setBalance(atm.getBalance() - amount);
			System.out.println(amount + " is withdrawed.");
			balanceEnquiry();
		} else {
			System.out.println("Insufficient Balance");
			balanceEnquiry();
		}

	}
	
	private String getCurrentTime() {
	    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public void userDetails(int customer_id, String password) {
		int id = 123;
		String pwd = "hello";
		// System.out.println(customer_id+" "+password);

		if (id == customer_id && pwd.equals(password)) {
			System.out.println("User verified");
		} else {
			System.out.println("Incorrect customerid or password ");
			System.exit(0);
		}

	}
	
	

}
