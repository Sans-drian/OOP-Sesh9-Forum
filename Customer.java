package com.company;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    //constructor method
    public Customer(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    //getters methods to get first name, last name, and account
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Account getAccount() {
        return this.account;
    }

    //setters method to set the account
    public void setAccount(Account account) {
        this.account = account;
    }

}