/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import view.ExamRegistrationForm;
import view.LogIn;
import view.QuestionLab;

/**
 *
 * @author Supun
 */
public class StudentObserverImpl extends UnicastRemoteObject implements StudentObserverController{

    QuestionLab questionLab ;
    LogIn logIn;
    
    public StudentObserverImpl(QuestionLab questionLab) throws RemoteException{
        this.questionLab=questionLab;
    }
    
    public StudentObserverImpl(LogIn logIn) throws RemoteException{
        this.logIn=logIn;
    }
    
    
    @Override
    public void update(String message) throws RemoteException {
        System.out.println("5");
        if (questionLab != null) {
            System.out.println("update");
            questionLab.setMessage(message);
        }
        
    }

    @Override
    public void setMessage(String message) throws RemoteException {
        if(questionLab!=null){
            questionLab.displayMessage(message);
        }
    }
    
}
