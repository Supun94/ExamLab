/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import controller.ExamController;
import controller.ForumController;
import controller.QuestionController;
import controller.RemoteFactory;
import controller.StudentController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Supun
 */  
public class ServerConnector {

    private static ServerConnector connector;
    private static RemoteFactory remoteFactory;
    private static QuestionController questionController;
    private static StudentController studentController;
    private static ForumController forumController;
    private static ExamController examController;

    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (remoteFactory == null) {
            remoteFactory = (RemoteFactory) Naming.lookup("rmi://localhost:5051/QuestionServer");
        }
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (connector == null) {
            connector = new ServerConnector();
        }
        return connector;
    }

    public QuestionController getQuestionController() throws RemoteException {
        if (questionController == null) {
            questionController = remoteFactory.getQuestionController();
        }
        return questionController;

    }

    public StudentController getStudentController() throws RemoteException {
        if (studentController == null) {
            studentController = remoteFactory.getStudentController();
        }
        return studentController;

    }
    
    public ForumController getForumController() throws RemoteException {
        if (forumController == null) {
            forumController = remoteFactory.getForumController();
        }
        return forumController;

    }
    
        public ExamController getExamController() throws RemoteException {
        if (examController == null) {
            examController = remoteFactory.getExamController();
        }
        return examController;

    }

}
