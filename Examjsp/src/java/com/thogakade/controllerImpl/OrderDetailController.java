/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.controllerImpl;

import com.thogakade.model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Demo
 */
public class OrderDetailController {

    private final Connection connection;

    public OrderDetailController(Connection connection) {
        this.connection = connection;
    }

    boolean addDetail(ArrayList<OrderDetail> details) throws SQLException {
        boolean isSuccess= true;
        PreparedStatement prepareStatement = connection.prepareStatement("insert into orderDetail values(?,?,?,?)");
        for (OrderDetail orderDetail : details) {
            prepareStatement.setString(1, orderDetail.getOrderId());
            prepareStatement.setString(2, orderDetail.getItemCode());
            prepareStatement.setDouble(3, orderDetail.getUnitPrice());
            prepareStatement.setInt(4, orderDetail.getQty());
            prepareStatement.addBatch();
        }
        
        int[] executeBatch = prepareStatement.executeBatch();
        for (int i : executeBatch) {
           if(i==0){
               isSuccess=false;
           }
        }
        return  isSuccess;
    }

}
