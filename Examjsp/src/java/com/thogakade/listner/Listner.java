/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.listner;

import com.thogakade.dbConnection.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 *
 * @author Demo
 */
public class Listner implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        try {
            Connection connection = (Connection) sre.getServletRequest().getAttribute("connection");
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        try {
            System.out.println("a");
            String url = sre.getServletContext().getInitParameter("url");
            String name = (String) sre.getServletContext().getInitParameter("userName");
            String password = (String) sre.getServletContext().getInitParameter("password");
            Connection connection = DBConnection.getInstence(url, name, password).getConnection();
            sre.getServletRequest().setAttribute("connection", connection);
        } catch (ClassNotFoundException ex) {
            try {
                sre.getServletRequest().getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(sre.getServletRequest(), null);
            } catch (ServletException ex1) {
                Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            try {
                
                sre.getServletRequest().getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(sre.getServletRequest(), null);
            } catch (ServletException ex1) {
                Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
