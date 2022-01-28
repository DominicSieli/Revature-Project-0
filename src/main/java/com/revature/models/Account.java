package com.revature.models;

public class Account {
    private int id;
    private int balance;
    private String userName;
    private String password;

    public Account(int id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public void register(){

    }

    public void openJointAccount(){

    }

    public void openSingleAccount(){

    }

    public void closeAccount(){

    }

    public void deposit(int amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public void withdraw(int amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
        }
    }

    public int currentBalance() {
        return balance;
    }
}