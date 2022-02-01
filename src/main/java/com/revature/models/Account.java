package com.revature.models;

public class Account {
    private Person customer;
    private int balance;
    private int accountNumber;

    public Account() {
    }

    public Account(Person customer, int balance, int accountNumber) {
        this.customer = customer;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
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

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}