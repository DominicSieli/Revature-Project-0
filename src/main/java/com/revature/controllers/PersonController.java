package com.revature.controllers;

import java.util.List;
import io.javalin.http.Context;
import javax.naming.ldap.Control;
import com.revature.models.Person;
import com.revature.services.PersonService;
import org.checkerframework.checker.units.qual.C;

public class PersonController {
    PersonService personService = new PersonService();

    public void handleGetAll(Context context) {
        List<Person> people = personService.getAll();
        context.json(people);
    }

    public void handleGetOne(Context context) {
        String idParameter = context.pathParam("id");
        int id = Integer.parseInt(idParameter);
        Person person = personService.getByID(id);
        context.json(person);
    }

    public void handleUpdate(Context context) {
        String idParameter = context.pathParam("id");
        Person personToUpdate = context.bodyAsClass(Person.class);
        int idToUpdate = Integer.parseInt(idParameter);
        personToUpdate.setId(idToUpdate);

        boolean updateSuccess = personService.update(personToUpdate);

        if(updateSuccess) {
            context.status(200);
        } else {
            context.status(400);
        }
    }

    public void handleCreate(Context context) {
        Person person = context.bodyAsClass(Person.class);
        boolean createSuccess = personService.create(person);

        if(createSuccess) {
            context.status(201);
        } else {
            context.status(400);
        }
    }

    public void handleDelete(Context context) {
        context.status(405);
    }
}