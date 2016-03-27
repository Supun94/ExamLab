/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Exam;

/**
 *
 * @author Supun
 */
public interface ExamController extends Remote{
    public boolean addMarks(Exam exam) throws RemoteException, ClassNotFoundException, SQLException;
    public ArrayList<Exam> getPreviousMarks(String nic) throws RemoteException, ClassNotFoundException, SQLException;
}
