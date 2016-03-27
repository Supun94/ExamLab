/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.controllerImpl;

import com.thogakade.controller.ItemController;
import com.thogakade.model.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Demo
 */
public class ItemControllerImpl implements ItemController {


    @Override
    public boolean addItem(Item item,Connection connection) throws ClassNotFoundException, SQLException {

        Statement createStatement = connection.createStatement();
        return createStatement.executeUpdate("insert into Item values('" + item.getItemCode() + "','" + item.getDescription() + "','" + item.getUnitPrice() + "','" + item.getQtyOnHand() + "')") > 0;
    }

    @Override
    public boolean deleteItem(String itemCode,Connection connection) throws ClassNotFoundException, SQLException {

        Statement createStatement = connection.createStatement();
        return createStatement.executeUpdate("delete from Item where itemCode='" + itemCode + "'") > 0;

    }

    @Override
    public boolean updateItem(Item item , Connection connection) throws ClassNotFoundException, SQLException {
        Statement createStatement = connection.createStatement();
        return createStatement.executeUpdate("update Item set description='" + item.getDescription() + "',unitPrice= '" + item.getUnitPrice() + "', qtyOnHand='" + item.getQtyOnHand() + "' where itemCode='" + item.getItemCode() + "' ") > 0;

    }

    @Override
    public ArrayList<Item> getAllItem(Connection connection) throws ClassNotFoundException, SQLException {
        Statement createStatement = connection.createStatement();
        ResultSet executeQuery = createStatement.executeQuery("select * from Item");
        ArrayList<Item> items = new ArrayList<>();
        while (executeQuery.next()) {
            Item list = new Item(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getDouble(3), executeQuery.getInt(4));
            items.add(list);
        }
        return items;
    }

    @Override
    public Item searchItem(String itemCode,Connection connection) throws ClassNotFoundException, SQLException {
        Statement createStatement = connection.createStatement();
        ResultSet executeQuery = createStatement.executeQuery("select * from Item where itemCode='" + itemCode + "'");
        Item items = null;
        if (executeQuery.next()) {
            items = new Item(executeQuery.getString(1), executeQuery.getString(2), executeQuery.getDouble(3), executeQuery.getInt(4));

        }
        return items;
    }

    
   

}
