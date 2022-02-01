package com.revature.services;

import java.util.List;

import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.daos.PersonDao;
import com.revature.utilities.Encryption;
import com.revature.daos.PersonDaoImplementation;

public class PersonService {
        private final PersonDao personDao = new PersonDaoImplementation();

        public boolean create(Type type, String firstName, String lastName, String password) {
                String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
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

        public boolean changePassword(int id, String oldPassword, String newPassword) {
                Person person = personDao.getByID(id);
                String hashedOldPassword = Encryption.hashString(person.getPassword());

                if(hashedOldPassword.equals(Encryption.hashString(oldPassword))) {
                        person.setPassword(newPassword);

                        return personDao.update(person);
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
                return personDao.getByEmailAndPassword(email, Encryption.hashString(password));
        }
}