package org.example;
//"1. Design a class for a simple bank account. The class should have the following features:
//        - Instance variables for the account holder's name, account number, and balance.
//        - A constructor that allows the user to create an account with a given name, account number, and balance.
//        - A method that allows the user to make a deposit to the account.
//        - A method that allows the user to make a withdrawal from the account.
//        - A method that returns the current balance of the account."
import java.util.Scanner;
class Bank {
    String accountHolderName;
    int accountHolderNumber;
    double accountHolderBalance;


    Bank(String name, int number, double amount) {
        // constructor for allow user to create
        this.accountHolderName = name;
        this.accountHolderNumber = number;
        this.accountHolderBalance = amount;
    }

    public void display() {
        System.out.println("Name : " + this.accountHolderName);
        System.out.println("Account Number :" + this.accountHolderNumber);
        System.out.println("Your Current Balance :" + this.accountHolderBalance);
    }

    public void deposit(double depositAmount) {
        this.accountHolderBalance += depositAmount;
        display();
    }

    public void withDraw(double withDrawAmount) {
        if (this.accountHolderBalance - withDrawAmount <= 1000) {
            System.out.println(this.accountHolderName);
            System.out.println("WithDraw Failed ! \n Your minimum Balance is Low");
        } else {
            this.accountHolderBalance -= withDrawAmount;
            System.out.println("WithDraw Successful !");
            display();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int number;
        double amount;
        double depositAmount;
        double withDrawAmount;
        System.out.print("Enter the Name :");
        name = sc.nextLine();
        System.out.print("\nEnter the Account Number :");
        number = sc.nextInt();
        System.out.print("\nEnter the Balance :");
        amount = sc.nextDouble();

        Bank s = new Bank(name, number, amount);

        System.out.println("Welcome TO The Bank");

        int choice;
        do {

            System.out.println("1.Deposit \n 2.Withdraw \n 3.Show");
            System.out.print("Enter the Choice :");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Deposit :");
                    System.out.println(" Enter the Amount To Deposit :");
                    depositAmount = sc.nextDouble();
                    s.deposit(depositAmount);
                }
                case 2 -> {
                    System.out.println("WithDraw :");
                    System.out.println("Enter the Amount To Withdraw :");
                    withDrawAmount = sc.nextDouble();
                    s.withDraw(withDrawAmount);
                }
                case 3 -> {
                    System.out.println("Show Details :");
                    s.display();
                }
                default -> System.out.println("Enter the Correct Choice !");

            }
        } while (choice >= 3);
    }


}