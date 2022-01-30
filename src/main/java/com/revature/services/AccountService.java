package com.revature.services;

import com.revature.models.Person;
import com.revature.models.Account;

import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImplementation;

import org.checkerframework.checker.units.qual.A;

public class AccountService {
    private AccountDao accountDao = new AccountDaoImplementation();

        public boolean deposit(int accountNumber, int amount) {
            Account account = accountDao.getAccountByAccountNumber(accountNumber);

            if(amount > 0) {
                account.setBalance(account.getBalance() + amount);
                return true;
            }

            return false;
        }

        public boolean withdraw(int accountNumber, int amount) {
            Account account = accountDao.getAccountByAccountNumber(accountNumber);

            if(amount > 0 && account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return true;
            }

            return false;
        }

        public Account getAccountByAccountNumber(int accountNumber) {
            return accountDao.getAccountByAccountNumber(accountNumber);
        }
}