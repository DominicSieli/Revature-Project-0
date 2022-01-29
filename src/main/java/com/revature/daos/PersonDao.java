package com.revature.daos;

import java.util.List;
import com.revature.models.Person;

public interface PersonDao {
    public boolean createPerson(Person p);
    public List<Person> getAll();
    public Person getByID(int id);
    public boolean update(Person p);
    public Person getByEmailAndPassword(String email, String password);
}