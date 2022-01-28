package com.revature.models;

public class Person
{
    protected int id;
    protected Type type;
    protected String userName;
    protected String email;
    protected String password;

    public Person() {
    }

    public Person(int id, Type type, String userName, String email, String password) {
        this.id = id;
        this.type = type;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id: " + id +
                ", type: " + type +
                "userName" + userName +
                '\'' + ", email: " + email +
                '\'' + ", password: " + password +
                '\'' + '}';
    }
}