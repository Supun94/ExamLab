/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.controller;

import com.thogakade.dao.BaseDAO;
import com.thogakade.model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Demo
 */
public interface CustomerController extends BaseDAO {

    public boolean addCustomer(Customer customer, Connection connection) throws ClassNotFoundException, SQLException;

    public boolean deleteCustomer(String customerCode, Connection connection) throws ClassNotFoundException, SQLException;

    public boolean updateCustomer(Customer customer, Connection connection) throws ClassNotFoundException, SQLException;

    public ArrayList<Customer> getAllCustomer(Connection connection) throws ClassNotFoundException, SQLException;

    public Customer searchCustomer(String customerCode, Connection connection) throws ClassNotFoundException, SQLException;
}
