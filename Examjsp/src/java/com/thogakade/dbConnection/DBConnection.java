/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thogakade.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Demo
 */
public class DBConnection {
 static DBConnection bConnection;
 private Connection connection;

    private DBConnection(String url,String name,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,name,password);
    }

    public static DBConnection getInstence(String url,String name,String password) throws ClassNotFoundException, SQLException {
   
        bConnection= new DBConnection(url,name,password);
       
        return  bConnection;
    }
    
    public Connection getConnection(){
        System.out.print("Connection Locked");
        return  connection;
    }
    
 
 
}
