/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.dao;

import com.thogakade.controllerImpl.CustomerControllerImpl;
import com.thogakade.controllerImpl.ItemControllerImpl;
import com.thogakade.controllerImpl.OrderControllerImpl;

/**
 *
 * @author Demo
 */
public class DAOFactory {

    public static BaseDAO getDAO(int type) {
        BaseDAO baseDAO = null;
        switch (type) {
            case 1:
                baseDAO = new ItemControllerImpl();
                break;
            case 2: 
                baseDAO=new OrderControllerImpl();
                break;
            case 3:
                System.out.println("v");
                baseDAO=new CustomerControllerImpl();
        }
        return baseDAO;
    }
}
