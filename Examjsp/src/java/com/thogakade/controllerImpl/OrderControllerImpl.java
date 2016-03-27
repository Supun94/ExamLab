/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.controllerImpl;

import com.thogakade.controller.OrderController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.thogakade.dbConnection.DBConnection;
import com.thogakade.model.Order;
import com.thogakade.model.OrderDetail;
import java.util.ArrayList;

/**
 *
 * @author Demo
 */
public class OrderControllerImpl implements OrderController {

    @Override
    public String generateOrderId(Connection connection) throws ClassNotFoundException, SQLException {
        Statement stm = connection.createStatement();
        String query = "select orderId from Orders order by 1 desc limit 1";
        ResultSet rst = stm.executeQuery(query);
        int value = 0;
        String orderId = null;
        if (rst.next()) {
            orderId = rst.getString(1);
            value = Integer.parseInt(orderId.substring(2)) + 1;
            if (value < 10) {
                orderId = "OD00" + value;

            } else if (value < 100) {
                orderId = "OD0" + value;

            } else if (value < 1000) {
                orderId = "OD" + value;

            }
        } else {

            orderId = "OD-000001";
        }

        return orderId;

    }

    @Override
    public boolean addOrder(Order order, ArrayList<OrderDetail> details, Connection connection) throws ClassNotFoundException, SQLException {
        boolean isSuccess = false;
        Statement createStatement = connection.createStatement();
        connection.setAutoCommit(false);
        if (createStatement.executeUpdate("insert into Orders values('" + order.getOrderId() + "','" + order.getOrderDate() + "','" + order.getCutomerId() + "')") > 0) {
            if (new OrderDetailController(connection).addDetail(details)) {
                connection.commit();
                isSuccess = true;
            } else {
                connection.rollback();
            }
        } else {
            connection.rollback();
        }
        return isSuccess;
    }

}
