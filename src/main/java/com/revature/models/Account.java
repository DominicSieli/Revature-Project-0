package com.revature.models;

public class Account {
    private int balance;
    private int accountNumber;
    private Person customer;
    private String userName;
    private String password;

    public Account() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean deposit(int amount) {
        if(amount > 0) {
            this.balance += amount;
            return true;
        }

        return false;
    }

    public boolean withdraw(int amount) {
        if(amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", customer=" + customer +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}