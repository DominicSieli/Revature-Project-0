package com.revature.daos;

import com.revature.models.Account;

public interface AccountDao {
    public Account getAccountByNumber(int number);
}