package com.revature.controllers;

import io.javalin.http.Context;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.UnauthorizedResponse;

import com.revature.models.Person;
import com.revature.services.PersonService;

public class AuthorizationController {
    private PersonService personService = new PersonService();

    public void authenticateLogin(Context context) {
        String userName = context.formParam("userName");
        String password = context.formParam("password");

        Person person = personService.getByEmailAndPassword(userName, password);

        if(person == null) {
            throw new UnauthorizedResponse("Incorrect credentials");
        } else {
            String token = person.getType() + "-TOKEN";
            context.status(200);
        }
    }

    public void authorizedCustomerToken(Context context) {
        String authorizationHeader = context.header("Authorization");

        if(authorizationHeader != null) {
            if(authorizationHeader.equals("CUSTOMER-TOKEN")) {
                return;
            } else if (!authorizationHeader.equals("CUSTOMER-TOKEN")) {
                throw new ForbiddenResponse("Only customers are allowed access");
            }
        }
        throw new UnauthorizedResponse("Try to login again");
    }
}