package com.driver;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a CurrentAccount instance
            CurrentAccount currentAccount = new CurrentAccount("John Doe", 7000, "ABCDE123");

            // Validate the trade license ID
            currentAccount.validateLicenseId();

            System.out.println("Trade License ID: " + currentAccount.tradeLicenseId);

            // Create a SavingsAccount instance
            SavingsAccount savingsAccount = new SavingsAccount("Jane Smith", 10000, 5000, 0.05);

            // Withdraw from the SavingsAccount
            savingsAccount.withdraw(3000);

            System.out.println("Savings Account Balance: " + savingsAccount.getBalance());

            // Create a StudentAccount instance
            StudentAccount studentAccount = new StudentAccount("Alice Johnson", 2000, "XYZ University");

            // Generate an account number
            String accountNumber = studentAccount.generateAccountNumber(6, 21);

            System.out.println("Generated Account Number: " + accountNumber);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}