package com.revature.application;

import io.javalin.Javalin;
import com.revature.utilities.LogUtility;
import com.revature.controllers.AccountController;

import org.checkerframework.checker.units.qual.A;

import com.revature.controllers.PersonController;
import com.revature.controllers.AppExceptionHandler;
import com.revature.controllers.AuthorizationController;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinApplication {
        final private LogUtility logUtility = new LogUtility();
        final private PersonController personController = new PersonController();
        final private AccountController accountController = new AccountController();
        final private AppExceptionHandler appExceptionHandler = new AppExceptionHandler();
        final private AuthorizationController authorizationController = new AuthorizationController();

        final private Javalin application = Javalin.create().routes(()->{
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