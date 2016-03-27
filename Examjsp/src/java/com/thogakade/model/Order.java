/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thogakade.model;

/**
 *
 * @author Demo
 */
public class Order {
    private String orderId;
    private String orderDate;
    private String cutomerId;

    public Order() {
    }

    public Order(String orderId, String orderDate, String cutomerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cutomerId = cutomerId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the cutomerId
     */
    public String getCutomerId() {
        return cutomerId;
    }

    /**
     * @param cutomerId the cutomerId to set
     */
    public void setCutomerId(String cutomerId) {
        this.cutomerId = cutomerId;
    }
    
    
}
