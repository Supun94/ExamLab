/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.servlet.item;

import com.thogakade.controller.ItemController;
import com.thogakade.controllerImpl.CustomerControllerImpl;
import com.thogakade.controllerImpl.ItemControllerImpl;
import com.thogakade.dao.DAOFactory;
import com.thogakade.model.Customer;
import com.thogakade.model.Item;
import com.thogakade.servlet.customer.ManageCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Demo
 */
public class ManageItem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageItem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageItem at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //processRequest(request, response);
        //get parameter from request 
        String code = request.getParameter("itemCode");

        //get Customer controller from  controller factory 
        ItemController controller = (ItemController) DAOFactory.getDAO(1);

        //if user search a customer using id
        if (code != null) {
            try {
                Item searchItem = controller.searchItem(code, (Connection) request.getAttribute("connection"));
                if (searchItem != null) {
                    out.print("<item>");
                    out.print("<detail>");
                    out.print("<code>" + searchItem.getItemCode() + "</code>");
                    out.print("<description>" + searchItem.getDescription() + "</description>");
                    out.print("<qty>" + searchItem.getQtyOnHand() + "</qty>");
                    out.print("<unitPrice>" + searchItem.getUnitPrice() + "</unitPrice>");
                    out.print("</detail>");
                    out.print("</item>");
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //send all customer 
            try {
                ArrayList<Item> getAllItem = controller.getAllItem((Connection) request.getAttribute("connection"));
                if (getAllItem != null) {
                    out.print("<item>");
                    for (Item allItem : getAllItem) {

                        out.print("<detail>");
                        out.print("<code>" + allItem.getItemCode() + "</code>");
                        out.print("<description>" + allItem.getDescription() + "</description>");
                        out.print("<qty>" + allItem.getQtyOnHand() + "</qty>");
                        out.print("<unitPrice>" + allItem.getUnitPrice() + "</unitPrice>");
                        out.print("</detail>");

                    }
                    out.print("</item>");
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String itemCode = request.getParameter("itemCode");
            String desc = request.getParameter("description");
            double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
            int qty = Integer.parseInt(request.getParameter("qty"));
            HttpSession session = request.getSession();
          //  if (session.getAttribute("loggedUser") != null) {
                try {

                    ItemController controller = (ItemController) DAOFactory.getDAO(1);

                    if (controller.addItem(new Item(itemCode, desc, unitPrice, qty), (Connection) request.getAttribute("connection"))) {
                        out.print(1);
                    } else {
                        out.print(0);
                    }
                } catch (ClassNotFoundException ex) {
                    request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                    Logger.getLogger(ManageItem.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                    Logger.getLogger(ManageItem.class.getName()).log(Level.SEVERE, null, ex);
                }
          //  } else {
               // out.print("Pleace Login to continue");
          //  }

        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();
           // if (session.getAttribute("loggedUser") != null) {
                String itemCode = request.getParameter("itemCode");
                ItemControllerImpl controller = (ItemControllerImpl) DAOFactory.getDAO(1);

                try {
                    boolean deleteItem = controller.deleteItem(itemCode, (Connection) request.getAttribute("connection"));
                    if (deleteItem) {
                        out.print(1);

                    } else {
                        out.print(0);
                    }

                } catch (ClassNotFoundException ex) {
                    request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                    Logger.getLogger(ManageItem.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                    Logger.getLogger(ManageItem.class.getName()).log(Level.SEVERE, null, ex);
                }

          //  } else {
          //      out.print("Please Login to continue");
           // }
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
          //  if (session.getAttribute("loggedUser") != null) {

                String desc = request.getParameter("description");
                double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
                int qty = Integer.parseInt(request.getParameter("qty"));
                String itemCode = request.getParameter("itemCode");

                try {
                    ItemControllerImpl controller = (ItemControllerImpl) DAOFactory.getDAO(1);
                    boolean updateItem = controller.updateItem(new Item(itemCode, desc, unitPrice, qty), (Connection) request.getAttribute("connection"));
                    if (updateItem) {

                        out.print(1);
                    } else {
                        out.print(0);
                    }
                } catch (ClassNotFoundException ex) {
                    request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                    Logger.getLogger(ManageItem.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                    Logger.getLogger(ManageItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                
          // } else {
           //     out.print("Please Login to continue");
         //   }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
