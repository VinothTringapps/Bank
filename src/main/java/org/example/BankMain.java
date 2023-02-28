package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger l= Logger.getLogger("Bank");
        String name;
        int number;
        double amount;
        double depositAmount;
        double withDrawAmount;
        try {
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
        catch(InputMismatchException e){
            l.info("Input Mismatched !");
        }
    }
}
