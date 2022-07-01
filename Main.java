package com.company;

import java.util.Scanner;

public class Main {
    static Bank bank = new Bank("The Bank");
    static Scanner BANK = new Scanner(System.in);

    //method to print a separator in console with the amount in the parameter
    public static void printSeparator(int n) {
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String[] args){

        //loop to keep program running
        while(true) {
            //display the bank title and options
            printSeparator(40);
            System.out.print("The Bank - by Sandrian, from the help of friends.\n");
            printSeparator(40);
            System.out.print("(1) Create Account\n(2) Search Account\n(3) Display Accounts\n(4) Deposit to an Account\n(5) Withdraw from an Account\n(6) Exit\nSelect Input: ");
            int choice = BANK.nextInt(); //take user input of int

            //if user input is 1 / if user wants to create an account
            if (choice == 1) {
                printSeparator(2);
                Account acc = new Account(0); //create new account with the balance set to 0
                System.out.print("Enter your first name: "); //ask user
                String firstName = BANK.next(); //take the input user
                System.out.print("Enter your last name: ");
                String lastName = BANK.next();
                bank.addCustomer(firstName, lastName); //call method to add a customer
                bank.getCustomerInteger(bank.getNumOfCustomers() - 1).setAccount(acc); //set customer number to linked list and call set account method
                printSeparator(2);
            }

            //if user input is 2 / if user wants to search an account
            if (choice == 2) {
                printSeparator(2);
                System.out.print("Enter Registered User Number: "); //ask user
                int idx = BANK.nextInt(); //take input

                //display user info
                if (0 < idx && idx <= bank.getNumOfCustomers()) { //if the input is greater than 0 and user is less than or equal to the registered amount of users
                    //display info
                    printSeparator(2);
                    System.out.println("Search result of registered user " + idx + ":");
                    System.out.printf("First Name: %s \n", bank.getCustomerInteger(idx - 1).getFirstName());
                    System.out.printf("Last Name: %s \n", bank.getCustomerInteger(idx - 1).getLastName());
                    System.out.printf("Balance: $%f \n", bank.getCustomerInteger(idx - 1).getAccount().getBalance());
                } else {
                    System.out.print("Registered User Number Does Not Exist\n");
                }
                printSeparator(2);
            }

            //if user input is 3 / if user wants to display all accounts
            if (choice == 3) {
                if (bank.getNumOfCustomers() > 0) { //check if the number of users is greater than 0
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) { //for loop to print all of the registered users info
                        printSeparator(2);
                        System.out.println("Account number: " + (i + 1));
                        System.out.printf("First Name: %s \n", bank.getCustomerInteger(i).getFirstName());
                        System.out.printf("Last Name: %s \n", bank.getCustomerInteger(i).getLastName());
                        System.out.printf("Balance: %f \n", bank.getCustomerInteger(i).getAccount().getBalance());
                        printSeparator(2);
                    }
                } else {
                    printSeparator(2);
                    System.out.print("There are no registered accounts.\n");
                    printSeparator(2);
                }
            }

            //if user input is 4 / if user wants to deposit to account
            if (choice == 4) {
                printSeparator(2);
                System.out.print("Enter Registered User Number: "); //ask user
                int index = BANK.nextInt(); //take input

                if (0 < index && index <= bank.getNumOfCustomers()) { //check if the input is greater than 0 and if input is less than or equal to the registered amount of users
                    System.out.print("Insert deposit: "); //ask user
                    int amount = BANK.nextInt(); //take input
                    bank.getCustomerInteger(index - 1).getAccount().deposit(amount); //deposit the amount inputted into the specific account (via linked list))
                    System.out.printf("Current Balance: $%f \n", bank.getCustomerInteger(index - 1).getAccount().getBalance()); //display balance
                } else {
                    System.out.print("Registered User Number Does Not Exist\n");
                }
                printSeparator(2);
            }

            //if user input is 5 / if user wants to withdraw from account
            if (choice == 5) {
                printSeparator(2);
                System.out.print("Enter Registered User Number: "); //ask user
                int inx = BANK.nextInt(); //take input

                if (0 < inx && inx <= bank.getNumOfCustomers()) { //check if the input is greater than 0 and if input is less than or equal to the registered amount of users
                    System.out.print("Enter amount desired to withdraw: "); //ask user
                    int amount = BANK.nextInt(); //take input
                    bank.getCustomerInteger(inx - 1).getAccount().withdraw(amount); //withdraw the amount inputted from the specific account (via linked list))
                    System.out.printf("Current Balance: $%f \n", bank.getCustomerInteger(inx - 1).getAccount().getBalance()); //display balance
                } else {
                    System.out.print("Registered User Number Does Not Exist\n");
                }
                printSeparator(2);
            }

            //if user input is 6 / if user wants to exit
            if (choice == 6) {
                printSeparator(2);
                System.out.println("Thank you for using this bank.");
                printSeparator(2);
                break;
            }
        }
    }
}