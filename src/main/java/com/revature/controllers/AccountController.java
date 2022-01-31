package com.revature.controllers;

import io.javalin.http.Context;

import com.revature.models.Account;
import com.revature.services.AccountService;

public class AccountController {
    private AccountService accountService = new AccountService();

    public void handleGetOne(Context context) {
        String accountNumberParameter = context.pathParam("account_number");
        int accountNumber = Integer.parseInt(accountNumberParameter);
        Account account = accountService.getAccountByNumber(accountNumber);

        if(account != null) {
            context.json(account);
        } else {
            context.status(404);
        }
    }
}