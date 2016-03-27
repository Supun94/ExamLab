/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Supun
 */
public class Exam implements Serializable {
    private String nic;
    private Date date;
    private double marks;

    public Exam() {
    }

    public Exam(String nic, Date date, double marks) {
        this.nic = nic;
        this.date = date;
        this.marks = marks;
    }

    public Exam(Date date, double marks) {
        this.date = date;
        this.marks = marks;
    }
    
    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the marks
     */
    public double getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }   
}