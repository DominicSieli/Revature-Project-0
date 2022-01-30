package com.revature.services;

import java.sql.Date;

import com.revature.models.Person;
import com.revature.models.Account;

import com.revature.daos.AccountDao;
import com.revature.daos.AccountDaoImplementation;

import org.checkerframework.checker.units.qual.A;

public class AccountService {
    private AccountDao accountDao = new AccountDaoImplementation();
        public Account getAccountByAccountNumber(int accountNumber) {
            return accountDao.getAccountByAccountNumber(accountNumber);
        }
}