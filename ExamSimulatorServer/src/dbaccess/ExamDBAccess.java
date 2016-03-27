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
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import model.Exam;

/**
 *
 * @author Supun
 */
public class ExamDBAccess {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public boolean addMarks(Exam exam) throws ClassNotFoundException, SQLException, RemoteException {
//        System.out.println("nic"+exam.getNic());
//        System.out.println("date"+exam.getDate());
//        System.out.println("marks"+exam.getMarks());
//        Connection conn = DBConnection.getConnection();
//        try {
//            lock.writeLock().lock();
//
//            Statement stm = conn.createStatement();
//            String sql = "Insert into Exam values(?,?,?)";
//            ResultSet rst = stm.executeQuery(sql);
//            Exam exam = null;
//            if (rst.next()) {
//               exam = new Exam(rst.getString("Nic"),rst.getString("ExamDate"),rst.getDouble("Marks"));
//
//            }
//            return exam;
//        } finally {
//            DBConnection.releaseConnection(conn);
//            lock.writeLock().unlock();
//        }
        
                Connection conn = DBConnection.getConnection();
        try {
            lock.writeLock().lock();

            PreparedStatement stm = conn.prepareStatement("Insert into Exam values(?,?,?)");
            Object[] studentData = {exam.getNic(), exam.getDate(), exam.getMarks()};
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
        
    
    public  ArrayList<Exam> getPreviousMarks(String nic) throws ClassNotFoundException, SQLException, RemoteException {


        Connection conn = DBConnection.getConnection();
        try {
            //lock.writeLock().lock();
            lock.writeLock().lock();
            String query = "select date,marks from Exam where nic='" + nic + "'";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(query);
            ArrayList<Exam> arrayList = new ArrayList<>();

            while (rst.next()) {
                Exam exam = new Exam(rst.getDate("Date"), rst.getInt("Marks"));
                arrayList.add(exam);
            }
            return arrayList;
        } finally {
            DBConnection.releaseConnection(conn);
            lock.writeLock().unlock();
        }
    }
        
}
