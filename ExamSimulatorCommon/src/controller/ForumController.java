/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import models.Question;
import observer.ForumAnswerObserverController;

/**
 *
 * @author Supun
 */
public interface ForumController extends Remote{
    public List<String> getSections() throws RemoteException, ClassNotFoundException, SQLException; 
    public List<String> getCategories(String section) throws RemoteException, ClassNotFoundException, SQLException; 
    public List<String> getQuestionTopics(String section,String category) throws RemoteException, ClassNotFoundException, SQLException; 
    public Question getQuestion(String section,String category,String topic)throws RemoteException, ClassNotFoundException, SQLException; 
    public void save(Question question,String section,String category) throws RemoteException, ClassNotFoundException, SQLException; 
    public void addObserve(ForumAnswerObserverController controller) throws RemoteException;
    public void removeObserve(ForumAnswerObserverController controller) throws RemoteException;  
    public void notifyObserve(String name,String message,String desc,String topic) throws RemoteException;  
    public void notifyNewQuestionObserve(String name,String topic,String desc) throws RemoteException;  
}
