package com.revature.daos;

import java.util.List;

import com.revature.models.Person;
import com.revature.models.Account;

public interface AccountDao {
    public Account getAccountByAccountNumber(int number);
}