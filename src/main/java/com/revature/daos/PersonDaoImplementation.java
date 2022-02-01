package com.revature.daos;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.utilities.Encryption;
import com.revature.utilities.ConnectionUtility;

public class PersonDaoImplementation implements PersonDao {
    @Override
    public boolean create(Person person) {
        String sql = "insert into person (type, first_name, last_name, email, password) values (?,?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, person.getType().ordinal());

            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, Encryption.hashString(person.getPassword()));

            int affectedRows = preparedStatement.executeUpdate();

            if(affectedRows == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Person> getAll() {
        String sql = "select * from person";
        List<Person> people = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                Person person = new Person();
                int id = resultSet.getInt("id");
                person.setId(id);

                Type[] types = Type.values();
                int typeOrdinal = resultSet.getInt("type");

                person.setType(types[typeOrdinal]);
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  people;
    }

    @Override
    public Person getByID(int id) {
        String sql = "select * from person where id = ?";

        try (Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                Person person = new Person();
                person.setId(id);

                Type[] types = Type.values();
                int typeOrdinal = resultSet.getInt("type");
                person.setType(types[typeOrdinal]);

                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));

                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Person person) {
        String sql = "update person set type = ?, first_name = ?, last_name = ?, email = ?, password = ? where id = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, person.getType().ordinal());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, Encryption.hashString(person.getPassword()));
            preparedStatement.setInt(6, person.getId());

            int affectedRows = preparedStatement.executeUpdate();

            if(affectedRows == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Person getByEmailAndPassword(String email, String password) {
        String sql = "select * from person where email = ? and password = ?";

        try(Connection connection = ConnectionUtility.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "email");
            preparedStatement.setString(2, "password");

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                Person person = new Person();
                Type[] types = Type.values();
                person.setId(resultSet.getInt("id"));
                int typeOrdinal = resultSet.getInt("type");
                person.setType(types[typeOrdinal]);

                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setEmail(resultSet.getString("email"));
                person.setPassword(resultSet.getString("password"));

                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}