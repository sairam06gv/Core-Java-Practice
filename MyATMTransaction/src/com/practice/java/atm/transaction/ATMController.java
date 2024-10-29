package com.practice.java.atm.transaction;

public class ATMController {

	/*
	 * private int customer_id; private String password;
	 */
	private ATMProvidedServices ATMService;
	/*
	 * public ATMController(int customer_id,String password) {
	 * 
	 * this.customer_id = customer_id; this.password = password; }
	 */

	public void setATMService(ATMProvidedServices ATMService) {
		this.ATMService = ATMService;
	}

	public void userVerification(int customer_id, String password) {
		/*
		 * if (ATMService != null) {
		 * System.out.println("Verifying user with ID: " + customer_id +
		 * " and Password: " + password); // Debug statement
		 * ATMService.userDetails(customer_id, password); } else {
		 * System.out.println("ATMService is not initialized."); }
		 */
		ATMService.userDetails(customer_id, password);
	}

	public void balanceInfo() {
		ATMService.balanceEnquiry();

	}

	public void cashDeposit(double amount) {
		ATMService.deposit(amount);
	}

	public void withDrawCash(double amount) {
		ATMService.withdrawal(amount);
	}
	
	public void viewMiniStatement(){
		ATMService.viewMiniStatement();
	}

}
