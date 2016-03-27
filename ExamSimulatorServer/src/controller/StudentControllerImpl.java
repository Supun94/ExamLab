/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbaccess.StudentDBAccess;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import observer.StudentObserverController;
import obsrveble.StudentObserveble;
import reservation.StudentReservation;

/**
 *
 * @author Supun
 */
class StudentControllerImpl extends UnicastRemoteObject implements StudentController {

    private StudentDBAccess studentDBAccess = new StudentDBAccess();
    private static StudentReservation reservation = new StudentReservation();
    private static StudentObserveble observeble = new StudentObserveble();

    int count=0;
    StudentControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addStudent(Student student) throws RemoteException, ClassNotFoundException, SQLException {
        try {
            if (reservation.reserveCustomer(student.getNic(), this)) {
                boolean isAdd = studentDBAccess.addCustomer(student);
                if (isAdd) {
                    observeble.setMessage("New Student Added NIC " + student.getNic() + "Please Reload");
                }

                return isAdd;

            } else {
                return false;
            }
        } finally {
            reservation.releaseCustomer(student.getNic(), this);
        }
    }

    @Override
    public Student checkNic(String nic) throws RemoteException, ClassNotFoundException, SQLException {
    try{
        if (reservation.reserveCustomer(nic, this)) {
        System.out.println("run");
            return studentDBAccess.checkNic(nic);
            
        } else {
                return null;
            }
        } finally {
            reservation.releaseCustomer(nic, this);
        }
    }

    @Override
    public boolean checkUserName(Student student) throws RemoteException, ClassNotFoundException, SQLException {
        boolean checkUser = studentDBAccess.checkUserName(student);
        return true;
    }

    @Override
    public Student checkPassword(String nic, String password) throws RemoteException, ClassNotFoundException, SQLException {
        return studentDBAccess.checkPassword(nic, password);
    }

    /*public boolean updateCustomer(Customer customer) throws RemoteException, ClassNotFoundException, SQLException {
        try {
            if (reservation.reserveCustomer(customer.getCustId(), this)) {
                 boolean isUpdate = dbAccess.updateCustomer(customer);
                if (isUpdate) {
                    observeble.setMessage("Customer Updated ID " + customer.getCustId());
                }

                return isUpdate;


            } else {
                return false;
            }
        } finally {
            reservation.releaseCustomer(customer.getCustId(), this);
        }
    }*/
    
    @Override
    public boolean singInStudent(Student student) throws RemoteException, IOException {
        try {
            if (reservation.reserveCustomer(student.getNic(), this)) {

                System.out.println("2222222");
                System.out.println("nic is"+student.getNic());
                observeble.setMessage("New Student Added NIC " + student.getNic() + "Please Reload");

                return true;
            } else {
                System.out.println("3");
                return false;
            }
        } finally {
            reservation.releaseCustomer(student.getNic(), this);
        }

    }

    @Override
    public boolean releaseStudent(String nic) throws RemoteException {
        return reservation.releaseCustomer(nic, this);
    }

    @Override
    public void addObserve(StudentObserverController controller) throws RemoteException {
        observeble.addObserve(controller);
    
//        System.out.println("run"+count);
        
    }

    @Override
    public void removeObserve(StudentObserverController controller) throws RemoteException {
        observeble.removeObserve(controller);
        
    }

    @Override
    public boolean reserveStudent(String nic) throws RemoteException {
        return reservation.reserveCustomer(nic, this);
    }

    @Override
    public void onlineNow() throws RemoteException {
        observeble.setMessage("Now Online");
        
    }

    @Override
    public Student findName(String nic) throws RemoteException, ClassNotFoundException, SQLException {
        return studentDBAccess.findName(nic);
    }

}
