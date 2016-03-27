/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.servlet.customer;

import com.thogakade.controller.CustomerController;
import com.thogakade.controllerImpl.CustomerControllerImpl;
import com.thogakade.dao.DAOFactory;
import com.thogakade.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Demo
 */
public class ManageCustomer extends HttpServlet {

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
            out.println("<title>Servlet ManageCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageCustomer at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");

        //get Customer controller from  controller factory 
        CustomerController controller = (CustomerControllerImpl) DAOFactory.getDAO(3);

        //if user search a customer using id
        if (id != null) {
            try {
                Customer searchCustomer = controller.searchCustomer(id, (Connection) request.getAttribute("connection"));
                if (searchCustomer != null) {
                    out.print("<customer>");
                    out.print("<detail>");
                    out.print("<Nic>" + searchCustomer.getNic() + "</Nic>");
                    out.print("<FullName>" + searchCustomer.getFullName() + "</FullName>");
                    out.print("<Email>" + searchCustomer.getEmail() + "</Email>");
                    out.print("<Password>" + searchCustomer.getPassword() + "</Password>");
                    out.print("<phoneNo>" + searchCustomer.getPhoneNo() + "</phoneNo>");
                    out.print("<Address>" + searchCustomer.getAddress() + "</Address>");
                    out.print("<RegDate>" + searchCustomer.getRegDate() + "</RegDate>");
                    out.print("</detail>");
                    out.print("</customer>");
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //send all customer 
            try {
                ArrayList<Customer> allCustomer = controller.getAllCustomer((Connection) request.getAttribute("connection"));
                if (allCustomer != null) {
                    out.print("<customer>");
                    for (Customer customer : allCustomer) {

                        out.print("<detail>");
                        out.print("<Nic>" + customer.getNic() + "</Nic>");
                        out.print("<FullName>" + customer.getFullName() + "</FullName>");
                        out.print("<Email>" + customer.getEmail() + "</Email>");
                        out.print("<Password>" + customer.getPassword() + "</Password>");
                        out.print("<phoneNo>" + customer.getPhoneNo() + "</phoneNo>");
                        out.print("<Address>" + customer.getAddress() + "</Address>");
                        out.print("<RegDate>" + customer.getRegDate() + "</RegDate>");
                        out.print("</detail>");

                    }
                    out.print("</customer>");
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nic = request.getParameter("nic");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNo = request.getParameter("phoneNo");
            String address = request.getParameter("address");
            String regDate = request.getParameter("regDate");

            //get customer controller from controller factory
            CustomerController controller = (CustomerControllerImpl) DAOFactory.getDAO(3);

            //call add customer method 
            if (controller.addCustomer(new Customer(nic, fullName, email, password, phoneNo, address, regDate), (Connection) request.getAttribute("connection"))) {
                //return 1 whnen success the query
                System.out.println("d");
                out.print(1);
            } else {
                //return 0 whnen not success the query
                System.out.println("xx");
                out.print(0);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nic = request.getParameter("nic");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNo = request.getParameter("phoneNo");
            String address = request.getParameter("address");
            String regDate = request.getParameter("regDate");

            //get customer controller from controller factory
            CustomerController controller = (CustomerControllerImpl) DAOFactory.getDAO(3);

            if (controller.updateCustomer(new Customer(nic, fullName, email, password, phoneNo, address, regDate), (Connection) request.getAttribute("connection"))) {
                out.print(1);
            } else {
                out.print(0);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String custId = request.getParameter("Nic");

            //get customer controller from controller factory
            CustomerController controller = (CustomerControllerImpl) DAOFactory.getDAO(3);

            if (controller.deleteCustomer(custId, (Connection) request.getAttribute("connection"))) {
                out.print(1);
            } else {
                out.print(0);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
