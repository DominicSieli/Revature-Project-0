package com.revature.daos;

import java.util.List;

import com.revature.models.Person;
import com.revature.models.AccountApplication;

public interface AccountApplicationDao {
    public AccountApplication getApplicationByNumber(int applicationNumber);
}