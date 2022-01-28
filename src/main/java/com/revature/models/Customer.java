package com.revature.models;

public class Customer extends Person{
    public Customer() {
    }

    public Customer(int id, Type type, String userName, String email, String password) {
        super(id, type, userName, email, password);
    }

    private Account account = new Account(this.id, this.userName, this.password);

    public void register(){
        account.register();
    }

    public void openJointAccount(){
        account.openJointAccount();
    }

    public void openSingleAccount(){
        account.openSingleAccount();
    }

    public void currentBalance(){
        account.currentBalance();
    }

    public void deposit(int amount){
        account.deposit(amount);
    }

    public void withdraw(int amount){
        account.withdraw(amount);
    }

    public void closeAccount(){
        account.closeAccount();
    }
}