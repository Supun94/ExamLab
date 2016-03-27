/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Supun
 */
public class RemoteFactoryImpl extends UnicastRemoteObject implements RemoteFactory{
    
    public RemoteFactoryImpl() throws RemoteException{
        
    }

    @Override
    public QuestionController getQuestionController() throws RemoteException {
        return new QuestionControllerImpl();
    }

    @Override
    public QuestionController getNextQuestion() throws RemoteException {
        return new QuestionControllerImpl();
    }

    @Override
    public StudentController getStudentController() throws RemoteException {
        return new StudentControllerImpl();
    }

    @Override
    public ForumController getForumController() throws RemoteException {
        return new ForumControllerImpl();
    }

    @Override
    public ExamController getExamController() throws RemoteException {
        return new ExamControllerImpl();
    }
    
    
    
    
}
