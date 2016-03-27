/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thogakade.controller;

import com.thogakade.dao.BaseDAO;
import com.thogakade.model.Item;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Demo
 */
public interface ItemController extends BaseDAO{
    public boolean addItem(Item item,Connection connection) throws ClassNotFoundException,SQLException;
    public boolean deleteItem(String itemCode,Connection connection) throws ClassNotFoundException,SQLException;
    public boolean updateItem(Item item,Connection connection) throws ClassNotFoundException,SQLException;
    public ArrayList<Item> getAllItem(Connection connection) throws ClassNotFoundException,SQLException;
    public Item searchItem(String itemCode,Connection connection) throws ClassNotFoundException,SQLException;
}
