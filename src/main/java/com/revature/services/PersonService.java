package com.revature.services;

import java.util.List;
import java.util.Locale;
import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.daos.PersonDao;
import com.revature.daos.PersonDaoImplementation;

public class PersonService {
        private PersonDao personDao = new PersonDaoImplementation();
}