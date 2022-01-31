package com.revature.daos;

import java.util.List;

import com.revature.models.Type;
import com.revature.models.Person;
import com.revature.models.AccountApplication;
import com.revature.utilities.ConnectionUtility;
import org.checkerframework.checker.units.qual.A;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class AccountApplicationDaoImplementation implements AccountApplicationDao {
    @Override
    public AccountApplication getApplicationByNumber(int applicationNumber) {
        try(Connection connection = ConnectionUtility.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from {oj application left join person on person.id = application.customer where application.number = ?}");
            preparedStatement.setInt(1, applicationNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                AccountApplication accountApplication = new AccountApplication();
                accountApplication.setApplicationNumber(resultSet.getInt("applicationNumber"));
                int customerID = resultSet.getInt("customerID");

                if(customerID != 0) {
                    Person customer = new Person();
                    customer.setId(resultSet.getInt("customer"));
                    customer.setType(Type.values()[resultSet.getInt("type")]);
                    customer.setFirstName(resultSet.getString("firstName"));
                    customer.setLastName(resultSet.getString("lastName"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPassword(resultSet.getString("password"));
                    accountApplication.setCustomer(customer);
                }

                accountApplication.setCustomerID(resultSet.getInt("customerID"));
                accountApplication.setApproved(resultSet.getBoolean("approved"));
                accountApplication.setApprovalDate(resultSet.getDate("approvalDate"));
                accountApplication.setApplicationDate(resultSet.getDate("applicationDate"));
                accountApplication.setApplicationNumber(resultSet.getInt("applicationNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}