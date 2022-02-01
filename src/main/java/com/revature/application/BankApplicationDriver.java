package com.revature.application;

import java.util.List;

import io.javalin.Javalin;
import io.javalin.http.Context;

import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.daos.PersonDao;
import com.revature.daos.PersonDaoImplementation;
import com.revature.services.PersonService;
import com.revature.controllers.PersonController;
import com.revature.controllers.AppExceptionHandler;

public class BankApplicationDriver {
    public static void main(String[] args){
        JavalinApplication application = new JavalinApplication();
        application.start(8080);
    }
}