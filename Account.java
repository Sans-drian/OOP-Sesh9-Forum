package com.company;

public class Account {
    private double balance;

    //constructor method
    public Account(double balance) {
        this.balance = balance;
    }

    //getter method to get balance
    public double getBalance() {
        return this.balance;
    }

    //method to add to deposit
    public boolean deposit(double amount) {
        if(amount > 0) { //if the amount inputted is greater than zero
            this.balance += amount; //add that amount to the balance variable
            return true;
        }
        return false;
    }

    //method to withdraw deposit
    public boolean withdraw(double amount) {
        if(amount > 0 && this.balance > amount) { //if the amount is greater than 0 and the balance amount is greater than input amount
            this.balance -= amount;
            return true;
        }
        return false;
    }
}