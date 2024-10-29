package com.practice.java.atm.transaction;

public interface ATMProvidedServices {
	
	public void userDetails(int c_id,String pwd);
	public void balanceEnquiry();
	public void deposit(double amount);
	public void withdrawal(double amount);
	public void viewMiniStatement();

}
