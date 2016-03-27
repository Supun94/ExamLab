/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Supun
 */
public interface RemoteFactory extends Remote{
    
    QuestionController getQuestionController() throws RemoteException;
    QuestionController getNextQuestion() throws RemoteException;
    StudentController getStudentController() throws RemoteException;
    ForumController getForumController() throws RemoteException;
    ExamController getExamController() throws RemoteException;

    
}
