package com.practice.java.atm.transaction;

// Interface defining the services provided by an ATM
public interface ATMProvidedServices {

    /**
     * Validates user details based on customer ID and password.
     * @param c_id - Customer ID of the user
     * @param pwd - Password of the user
     */
    public void userDetails(int c_id, String pwd);

    /**
     * Retrieves and displays the balance for the user.
     */
    public void balanceEnquiry();

    /**
     * Adds a specified amount to the user's account balance.
     * @param amount - The amount to deposit
     */
    public void deposit(double amount);

    /**
     * Withdraws a specified amount from the user's account balance, if sufficient funds are available.
     * @param amount - The amount to withdraw
     */
    public void withdrawal(double amount);

    /**
     * Displays a mini-statement of recent transactions for the user.
     */
    public void viewMiniStatement();
}
