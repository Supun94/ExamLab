/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thogakade.controllerImpl;

import com.thogakade.controller.CustomerController;
import com.thogakade.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author Demo
 */
public class CustomerControllerImpl implements CustomerController{

    @Override
    public boolean addCustomer(Customer customer,Connection connection) throws ClassNotFoundException, SQLException {
        System.out.println("c");
        Statement createStatement = connection.createStatement();
        return createStatement.executeUpdate("insert into Student values('" + customer.getNic() + "','" + customer.getFullName() + "','" + customer.getEmail()+ "','" + customer.getPassword()+ "','" + customer.getPhoneNo()+ "','" + customer.getAddress()+ "','" + customer.getRegDate()+ "')") > 0;
    }

    @Override
    public boolean deleteCustomer(String customerCode,Connection connection) throws ClassNotFoundException, SQLException {

        Statement createStatement = connection.createStatement();
        return createStatement.executeUpdate("delete from Student where Nic='" + customerCode + "'") > 0;

    }

    @Override
    public boolean updateCustomer(Customer customer , Connection connection) throws ClassNotFoundException, SQLException {
        Statement createStatement = connection.createStatement();
        return createStatement.executeUpdate("update Student set FullName='" + customer.getFullName() + "','" + customer.getEmail()+ "','" + customer.getPassword()+ "','" + customer.getPhoneNo()+ "','" + customer.getAddress()+ "','" + customer.getRegDate()+ "' where Nic='" + customer.getNic()+ "' ") > 0;

    }

    @Override
    public ArrayList<Customer> getAllCustomer(Connection connection) throws ClassNotFoundException, SQLException {
        Statement createStatement = connection.createStatement();
        ResultSet executeQuery = createStatement.executeQuery("select * from Student");
        ArrayList<Customer> customers = new ArrayList<>();
        while (executeQuery.next()) {
            Customer list = new Customer(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4),executeQuery.getString(5),executeQuery.getString(6),executeQuery.getString(7));
            customers.add(list);
        }
        return customers;
    }

    @Override
    public Customer searchCustomer(String customerCode,Connection connection) throws ClassNotFoundException, SQLException {
        Statement createStatement = connection.createStatement();
        ResultSet executeQuery = createStatement.executeQuery("select * from Student where Nic='" + customerCode + "'");
        Customer customers = null;
        if (executeQuery.next()) {
            customers = new Customer(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getString(3), executeQuery.getString(4),executeQuery.getString(5),executeQuery.getString(6),executeQuery.getString(7));

        }
        return customers;
    }

}
