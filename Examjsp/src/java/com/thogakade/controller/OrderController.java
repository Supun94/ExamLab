/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thogakade.controller;

import com.thogakade.dao.BaseDAO;
import com.thogakade.model.Order;
import com.thogakade.model.OrderDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Demo
 */
public interface OrderController extends BaseDAO{
     public String generateOrderId(Connection connection) throws ClassNotFoundException, SQLException;
     public boolean addOrder(Order order, ArrayList<OrderDetail> details,Connection connection) throws ClassNotFoundException, SQLException;
}
