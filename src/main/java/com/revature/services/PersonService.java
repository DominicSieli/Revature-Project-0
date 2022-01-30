package com.revature.services;

import java.util.List;
import java.util.Locale;
import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.daos.PersonDao;
import com.revature.daos.PersonDaoImplementation;

public class PersonService {
        private PersonDao personDao = new PersonDaoImplementation();

        public boolean create(Type type, String firstName, String lastName, String password) {
                String email = firstName + "." + lastName + "@gmail.com";
                email = email.toLowerCase();
                Person person = new Person(type, firstName, lastName, email, password);

                return personDao.create(person);
        }

        public boolean create(Person person) {
                String email = person.getFirstName() + "." + person.getLastName() + "@gmail.com";
                email = email.toLowerCase();
                person.setEmail(email);

                return personDao.create(person);
        }

        public List<Person> getAll() {
                return personDao.getAll();
        }

        public boolean changePassword(String oldPassword, String newPassword, int id) {
                Person person = personDao.getByID(id);

                if(person.getPassword().equals(oldPassword)) {
                        person.setPassword(newPassword);
                        boolean updateSuccess = personDao.update(person);

                        return updateSuccess;
                }

                return false;
        }

        public Person getByID(int id) {
                return personDao.getByID(id);
        }

        public boolean update(Person person) {
                return personDao.update(person);
        }

        public Person getByEmailAndPassword(String email, String password) {
                return personDao.getByEmailAndPassword(email, password);
        }
}