package com.revature.daos;

import java.util.List;

import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.models.Account;
import com.revature.utilities.ConnectionUtility;
import org.checkerframework.checker.units.qual.A;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class AccountDaoImplementation implements AccountDao {
    @Override
    public Account getAccountByAccountNumber(int number) {
        try(Connection connection = ConnectionUtility.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from {oj account left join person on person.id = account.customer where account.number = ?}");
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                Account account = new Account();
                account.setAccountNumber(resultSet.getInt("accountNumber"));
                int customerID = resultSet.getInt("customer");

                if(customerID != 0) {
                    Person customer = new Person();
                    customer.setId(resultSet.getInt("customer"));
                    customer.setType(Type.values()[resultSet.getInt("type")]);
                    customer.setFirstName(resultSet.getString("firstName"));
                    customer.setLastName(resultSet.getString("lastName"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPassword(resultSet.getString("password"));
                    account.setCustomer(customer);
                }

                account.setBalance(resultSet.getInt("balance"));
                account.setUserName(resultSet.getString("userName"));
                account.setPassword(resultSet.getString("password"));
                account.setAccountNumber(resultSet.getInt("accountNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}