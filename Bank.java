package com.company;

import java.util.LinkedList;

public class Bank {
    private LinkedList<Customer> customer;
    private String bankName;
    int numberOfCustomers = 0;

    //constructor method
    public Bank(String bankName) {
        this.customer = new LinkedList<Customer>(); //create new linked list
        this.bankName = bankName; //set the bank name to parameter
    }

    //method to add a customer
    public void addCustomer(String firstName, String lastName) { //takes first and last name string
        numberOfCustomers += 1; //add 1 to the amount of customers
        Main.printSeparator(2);
        System.out.println("This account is registered under: " + getNumOfCustomers()); //print to the account number associated with the account they had just created
        System.out.println("Customer(s) registered: " + getNumOfCustomers()); //print to user how many customers there are
        Customer customer = new Customer(firstName, lastName); //create new customer object
        this.customer.add(customer); //add and store value associated to customer to linked list
    }

    //getter method to get num of customers
    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    //method to fetch the specific customer from linked list
    public Customer getCustomerInteger(int index) {
        return this.customer.get(index);
    }
}