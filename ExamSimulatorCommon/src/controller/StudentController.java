/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import model.Student;
import observer.StudentObserverController;


/**
 *
 * @author Supun
 */
public interface StudentController extends Remote{
    
    public boolean addStudent(Student student) throws RemoteException, ClassNotFoundException, SQLException;
    public Student checkNic(String nic) throws RemoteException, ClassNotFoundException, SQLException;
    public Student checkPassword(String nic,String password) throws RemoteException, ClassNotFoundException, SQLException;
    public Student findName(String nic) throws RemoteException, ClassNotFoundException, SQLException,NotBoundException;
    public boolean checkUserName(Student student) throws RemoteException, ClassNotFoundException, SQLException;
    boolean singInStudent(Student student) throws RemoteException, IOException;
    public boolean releaseStudent(String nic) throws RemoteException;
    public void addObserve(StudentObserverController controller) throws RemoteException;
    public void removeObserve(StudentObserverController controller) throws RemoteException;
    public boolean reserveStudent(String nic) throws RemoteException;
    public void onlineNow() throws RemoteException;
}
