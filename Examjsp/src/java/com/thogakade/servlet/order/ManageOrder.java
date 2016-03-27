/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.servlet.order;

import com.thogakade.controller.OrderController;
import com.thogakade.dao.DAOFactory;
import com.thogakade.model.Order;
import com.thogakade.model.OrderDetail;
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
public class ManageOrder extends HttpServlet {

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
            out.println("<title>Servlet ManageOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageOrder at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //  processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String qtyList = request.getParameter("qty");
            String priceList = request.getParameter("unitPrice");
            String itemCodeList = request.getParameter("itemCode");
            String customerId = request.getParameter("customerId");
            String orderId = request.getParameter("orderId");
            String date = request.getParameter("date");
            ArrayList<OrderDetail> details = new ArrayList<>();
            String[] qty = qtyList.split("-");
            String[] itemCode = itemCodeList.split("-");
            String[] unitPrice = priceList.split("-");
            Order order = new Order(orderId, date, customerId);
            for (int i = 0; i < itemCode.length; i++) {
                OrderDetail orderDetail = new OrderDetail(orderId, itemCode[i], Double.parseDouble(unitPrice[i]), Integer.parseInt(qty[i]));
                details.add(orderDetail);
                //System.out.println(itemCode[i]+"..."+qty[i]+"..."+unitPrice[i]+"...OrderId"+orderId+"------"+customerId+"----"+date);
            }
            try {
                OrderController controller = (OrderController) DAOFactory.getDAO(2);
                if (controller.addOrder(order, details, (Connection) request.getAttribute("connection"))) {
                    out.print(1);
                } else {
                    out.print(1);
                }
            } catch (ClassNotFoundException ex) {
                request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                Logger.getLogger(AddOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                request.getRequestDispatcher("./ErrorPage.jsp?message=" + ex.getMessage()).forward(request, response);
                Logger.getLogger(AddOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
          //  out.print(request.getParameter("qtyList") + "   " + request.getParameter("itemCode").substring(0, request.getParameter("itemCode").length() - 1) + "  " + request.getParameter("customerId") + "  " + request.getParameter("orderId"));
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
