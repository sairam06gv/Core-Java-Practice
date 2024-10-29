package com.practice.java.atm.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

// Service implementation class that provides ATM functionalities
public class ServiceImpl implements ATMProvidedServices {

    // Instance of ATM data object to manage balance and user details
    ATMDto atm = new ATMDto();

    // Stores a mini-statement of recent transactions with timestamps and amounts
    Map<String, Double> miniStatement = new HashMap<>();

    // Displays the current balance of the user's account
    @Override
    public void balanceEnquiry() {
        System.out.println("Current Balance : " + atm.getBalance());
    }

    // Deposits a specified amount to the user's account and records the transaction in the mini-statement
    @Override
    public void deposit(double amount) {
        atm.setBalance(atm.getBalance() + amount);
        System.out.println("Deposit is successful. Deposit Amount : " + amount);
        
        // Records transaction with current time and deposit amount
        String transactiontime = "Transaction time: " + getCurrentTime() + ". Deposit amount  -> ";
        miniStatement.put(transactiontime, amount);
        
        // Display updated balance
        balanceEnquiry();
    }

    // Displays a mini-statement showing recent transactions
    @Override
    public void viewMiniStatement() {
        for (Map.Entry<String, Double> entry : miniStatement.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // Withdraws a specified amount if sufficient balance is available, otherwise displays an error message
    @Override
    public void withdrawal(double amount) {
        if (atm.getBalance() >= amount) {
            // Records transaction with current time and withdrawal amount
            String transactiontime = "Transaction time: " + getCurrentTime() + ". Withdrawal amount-> ";
            miniStatement.put(transactiontime, amount);
            
            // Updates balance after withdrawal
            atm.setBalance(atm.getBalance() - amount);
            System.out.println(amount + " is withdrawn.");
            
            // Display updated balance
            balanceEnquiry();
        } else {
            System.out.println("Insufficient Balance");
            balanceEnquiry();
        }
    }

    // Helper method to get the current date and time as a formatted string
    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // Verifies user details by comparing input customer ID and password to stored values
    public void userDetails(int customer_id, String password) {
        int id = 123;  // Sample customer ID
        String pwd = "hello";  // Sample password

        // Checks if input credentials match stored credentials
        if (id == customer_id && pwd.equals(password)) {
            System.out.println("User verified");
        } else {
            System.out.println("Incorrect customer ID or password");
            System.exit(0);  // Exits program if credentials are incorrect
        }
    }
}
