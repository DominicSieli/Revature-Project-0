package com.revature.models;

public class Account {
    private int balance;
    private int accountNumber;
    private Person customer;

    public Account() {
    }

    public Account(int balance, int accountNumber, Person customer, String userName, String password) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", customer=" + customer +
                '}';
    }
}