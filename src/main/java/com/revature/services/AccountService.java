package com.revature.services;

import com.revature.models.Account;
import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImplementation;

public class AccountService {
        private final AccountDao accountDao = new AccountDaoImplementation();

        public boolean deposit(int accountNumber, int amount) {
            Account account = accountDao.getAccountByNumber(accountNumber);

            if(amount > 0) {
                account.setBalance(account.getBalance() + amount);
                return true;
            }

            return false;
        }

        public boolean withdraw(int accountNumber, int amount) {
            Account account = accountDao.getAccountByNumber(accountNumber);

            if(amount > 0 && account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return true;
            }

            return false;
        }

    public boolean transfer(int fromAccountNumber, int toAccountNumber, int amount) {
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