package com.revature.services;

import com.revature.models.Type;
import com.revature.models.Person;

public class PersonService
{
    public Person createPerson(int id, Type type, String userName, String email, String password)
    {
        return new Person(id, type, userName, email, password);
    }
}