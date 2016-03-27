/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dbaccess.ExamDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Exam;

/**
 *
 * @author Supun
 */
public class ExamControllerImpl extends UnicastRemoteObject implements ExamController{

    private ExamDBAccess examDBAccess= new ExamDBAccess();
    
    
    ExamControllerImpl() throws RemoteException{
        
    }
    
    @Override
    public boolean addMarks(Exam exam) throws RemoteException, ClassNotFoundException, SQLException {
        return examDBAccess.addMarks(exam);
    }

    @Override
    public ArrayList<Exam> getPreviousMarks(String nic) throws RemoteException, ClassNotFoundException, SQLException {
        return examDBAccess.getPreviousMarks(nic);
    }    
}
