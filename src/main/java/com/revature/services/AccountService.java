package com.revature.services;

import com.revature.models.Person;
import com.revature.models.Account;

import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImplementation;

import org.checkerframework.checker.units.qual.A;

public class AccountService {
    private AccountDao accountDao = new AccountDaoImplementation();

        public boolean register(String firstName, String lastName, String email, String password) {

            return false;
        }

        public boolean apply(Person person) {

            return false;
        }

        public boolean deposit(Person person, int accountNumber, int amount) {
            Account account = accountDao.getAccountByNumber(accountNumber);

            if(amount > 0) {
                account.setBalance(account.getBalance() + amount);
                return true;
            }

            return false;
        }

        public boolean withdraw(Person person, int accountNumber, int amount) {
            Account account = accountDao.getAccountByNumber(accountNumber);

            if(amount > 0 && account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return true;
            }

            return false;
        }

    public boolean transfer(Person person, int fromAccountNumber, int toAccountNumber, int amount) {
        Account fromAccount = accountDao.getAccountByNumber(fromAccountNumber);
        Account toAccount = accountDao.getAccountByNumber(toAccountNumber);

        if(amount > 0 && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            return true;
        }

        return false;
    }

        public Account getAccountByNumber(int accountNumber) {
            return accountDao.getAccountByNumber(accountNumber);
        }
}