package org.example;
//"1. Design a class for a simple bank account. The class should have the following features:
//        - Instance variables for the account holder's name, account number, and balance.
//        - A constructor that allows the user to create an account with a given name, account number, and balance.
//        - A method that allows the user to make a deposit to the account.
//        - A method that allows the user to make a withdrawal from the account.
//        - A method that returns the current balance of the account."
import java.util.Scanner;
import java.util.logging.Logger;

class Bank {
    String accountHolderName;
    int accountHolderNumber;
    double accountHolderBalance;

    Logger l=Logger.getLogger("com.api.jar");
    Bank(String name, int number, double amount) {
        // constructor for allow user to create
        this.accountHolderName = name;
        this.accountHolderNumber = number;
        this.accountHolderBalance = amount;
    }

    public void display() {
        l.info("Name : " + this.accountHolderName);
        l.info("Account Number :" + this.accountHolderNumber);
        l.info("Your Current Balance :" + this.accountHolderBalance);
    }

    public void deposit(double depositAmount) {
        this.accountHolderBalance += depositAmount;
        display();
    }

    public void withDraw(double withDrawAmount) {
        if (this.accountHolderBalance - withDrawAmount <= 1000) {
            l.info(this.accountHolderName);
            l.info("WithDraw Failed ! \n Your minimum Balance is Low");
        } else {
            this.accountHolderBalance -= withDrawAmount;
            System.out.println("WithDraw Successful !");
            display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger l= Logger.getLogger("com.api.jar");
        String name;
        int number;
        double amount;
        double depositAmount;
        double withDrawAmount;
        l.info("Enter the Name :");
        name = sc.nextLine();
        l.info("\nEnter the Account Number :");
        number = sc.nextInt();
        l.info("\nEnter the Balance :");
        amount = sc.nextDouble();

        Bank s = new Bank(name, number, amount);

        l.info("Welcome TO The Bank");

        int choice;
        do {

            l.info("1.Deposit \n 2.Withdraw \n 3.Show");
            l.info("Enter the Choice :");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    l.info("Deposit :");
                    l.info(" Enter the Amount To Deposit :");
                    depositAmount = sc.nextDouble();
                    s.deposit(depositAmount);
                }
                case 2 -> {
                    l.info("WithDraw :");
                    l.info("Enter the Amount To Withdraw :");
                    withDrawAmount = sc.nextDouble();
                    s.withDraw(withDrawAmount);
                }
                case 3 -> {
                    l.info("Show Details :");
                    s.display();
                }
                default -> l.info("Enter the Correct Choice !");

            }
        } while (choice >= 3);
    }


}