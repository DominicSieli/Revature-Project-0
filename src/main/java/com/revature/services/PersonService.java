package com.revature.services;

import com.revature.models.Type;
import com.revature.models.Person;

public class PersonService
{
    public Person createPerson(int id, Type type, String firstName, String lastName, String email, String password)
    {
        Person person = new Person(id, type, firstName, lastName, email, password);

        return person;
    }
}