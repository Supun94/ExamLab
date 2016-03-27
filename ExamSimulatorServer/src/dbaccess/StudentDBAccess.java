   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import dbConnection.DBConnection;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import model.Student;

/**
 *
 * @author Supun
 */
public class StudentDBAccess {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public boolean addCustomer(Student student) throws ClassNotFoundException, SQLException, RemoteException {
        Connection conn = DBConnection.getConnection();
        try {
            lock.writeLock().lock();

            PreparedStatement stm = conn.prepareStatement("Insert into Student values(?,?,?,password(?),?,?,?)");
            Object[] studentData = {student.getNic(), student.getFullName(), student.getEmail(), student.getPassword(), student.getPhoneNo(), student.getAddress(), student.getRegDate()};
            for (int i = 0; i < studentData.length; i++) {
                stm.setObject(i + 1, studentData[i]);
            }
            boolean isSuccess = stm.executeUpdate() > 0;
//            if(isSuccess){
//                CustomerObserveble.setCustomerId(generateCustomerId());
//            }

            return isSuccess;
        } finally {
            DBConnection.releaseConnection(conn);
            lock.writeLock().unlock();
        }
    }
    /*        try {
     lock.readLock().lock();
     Connection conn = DBConnection.getConnection();
     Statement stm = conn.createStatement();
     String sql = "Select * From Customer Where id='" + id + "'"; 
     ResultSet rst = stm.executeQuery(sql);
     Customer customer = null;
     if (rst.next()) {
     customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
                
     }
     return customer;
     }finally{
     lock.readLock().unlock();
     }*/

    public Student checkNic(String Nic) throws ClassNotFoundException, SQLException, RemoteException {
        Connection conn = DBConnection.getConnection();
        try {
            lock.writeLock().lock();

            Statement stm = conn.createStatement();
            String sql = "Select Nic From Student Where Nic='" + Nic + "'";
            ResultSet rst = stm.executeQuery(sql);
            Student student = null;
            if (rst.next()) {
                student = new Student(rst.getString("Nic"));

            }
            return student;
        } finally {
            DBConnection.releaseConnection(conn);
            lock.writeLock().unlock();
        }
    }

    public boolean checkUserName(Student student) throws ClassNotFoundException, SQLException, RemoteException {
        Connection conn = DBConnection.getConnection();
        try {
            lock.writeLock().lock();

            PreparedStatement stm = conn.prepareStatement("Select Nic from Student");
            Object[] studentData = {student.getNic()};
            for (int i = 0; i < studentData.length; i++) {
                stm.setObject(i + 1, studentData[i]);
            }
            boolean isSuccess = stm.executeUpdate() > 0;
            System.out.println("true");
//            if(isSuccess){
//                CustomerObserveble.setCustomerId(generateCustomerId());
//            }

            return isSuccess;
        } finally {
            DBConnection.releaseConnection(conn);
            lock.writeLock().unlock();
        }
    }

    public Student checkPassword(String Nic, String password) throws ClassNotFoundException, SQLException, RemoteException {
        Connection conn = DBConnection.getConnection();
        try {
            lock.writeLock().lock();

            Statement stm = conn.createStatement();
            String sql = "Select Nic,password From Student Where Nic='" + Nic + "' and password=" + "password" + "('" + password + "')";
            ResultSet rst = stm.executeQuery(sql);
            Student student = null;
            if (rst.next()) {
                student = new Student(rst.getString("Nic"), rst.getString("password"));

            }
            return student;
        } finally {
            DBConnection.releaseConnection(conn);
            lock.writeLock().unlock();
        }
    }
    
        public Student findName(String Nic) throws ClassNotFoundException, SQLException, RemoteException {
        Connection conn = DBConnection.getConnection();
        try {
            lock.writeLock().lock();

            Statement stm = conn.createStatement();
            String sql = "Select FullName From Student Where Nic='" + Nic + "'";
            ResultSet rst = stm.executeQuery(sql);
            Student student = null;
            if (rst.next()) {
                student = new Student(rst.getString("Nic"), rst.getString("FullName"));

            }
            return student;
        } finally {
            DBConnection.releaseConnection(conn);
            lock.writeLock().unlock();
        }
    }

}
