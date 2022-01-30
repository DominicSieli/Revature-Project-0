package com.revature.application;

import com.revature.controllers.AccountController;
import io.javalin.Javalin;

import com.revature.utilities.LogUtility;

import org.checkerframework.checker.units.qual.A;

import com.revature.controllers.PersonController;
import com.revature.controllers.AppExceptionHandler;
import com.revature.controllers.AuthorizationController;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
    private LogUtility logUtility = new LogUtility();
    private PersonController personController = new PersonController();
    private AccountController accountController = new AccountController();
    private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();
    private AuthorizationController authorizationController = new AuthorizationController();

    private Javalin application = Javalin.create().routes(()->{
        path("people",()-> {
                    get(personController::handleGetAll);
                    post(personController::handleCreate);
                    delete(personController::handleDelete);

                    path("{id}", () -> {
                        get(personController::handleGetOne);
                        put(personController::handleUpdate);
                    });
                });

            path("accounts", ()->{
                before(authorizationController::authorizedCustomerToken);
                get("{account_number}", accountController::handleGetOne);
            });

            path("login",()->{
                post(authorizationController::authenticateLogin);
            });

            before("*", logUtility::logRequest);
        }).exception(NumberFormatException.class, appExceptionHandler::handleNumberFormatException);

    public void start(int port) {
        application.start(port);
    }
}