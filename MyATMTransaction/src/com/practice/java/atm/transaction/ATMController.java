package com.practice.java.atm.transaction;

// Controller class that acts as an interface between the user and the ATM services
public class ATMController {

    // Reference to the ATM service interface to access various ATM functionalities
    private ATMProvidedServices ATMService;

    // Setter method to inject an implementation of ATMProvidedServices
    public void setATMService(ATMProvidedServices ATMService) {
        this.ATMService = ATMService;
    }

    /**
     * Verifies the user by delegating the request to the ATM service's userDetails method.
     * @param customer_id - The user's customer ID
     * @param password - The user's password
     */
    public void userVerification(int customer_id, String password) {
        ATMService.userDetails(customer_id, password);
    }

    // Retrieves and displays the user's current balance by calling the balanceEnquiry method
    public void balanceInfo() {
        ATMService.balanceEnquiry();
    }

    /**
     * Deposits a specified amount to the user's account by calling the deposit method.
     * @param amount - The amount to be deposited
     */
    public void cashDeposit(double amount) {
        ATMService.deposit(amount);
    }

    /**
     * Withdraws a specified amount from the user's account by calling the withdrawal method.
     * @param amount - The amount to be withdrawn
     */
    public void withDrawCash(double amount) {
        ATMService.withdrawal(amount);
    }

    // Displays the user's mini-statement by calling the viewMiniStatement method
    public void viewMiniStatement(){
        ATMService.viewMiniStatement();
    }
}
