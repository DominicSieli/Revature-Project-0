package com.revature.daos;

import java.util.List;
import com.revature.models.Person;

public interface PersonDao {
    public List<Person> getAll();
    public Person getByID(int id);
    public boolean create(Person person);
    public boolean update(Person person);
    public Person getByEmailAndPassword(String email, String password);
}