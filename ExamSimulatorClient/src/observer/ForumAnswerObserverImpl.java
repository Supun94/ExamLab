/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import view.forum.CollectionForum;
import view.forum.ExceptionForum;
import view.forum.FileIoForum;
import view.forum.FundamentalsForum;
import view.forum.InterfaceForum;
import view.forum.ObjectOpForum;
import view.forum.OthersForum;
import view.forum.ThreadsForum;

/**
 *
 * @author Supun
 */
public class ForumAnswerObserverImpl extends UnicastRemoteObject implements ForumAnswerObserverController {

    FundamentalsForum fundamentalsForum;
    ObjectOpForum objectOpForum;
    CollectionForum collectionForum;
    ExceptionForum exceptionForum;
    FileIoForum fileIoForum;
    InterfaceForum interfaceForum;
    OthersForum othersForum;
    ThreadsForum threadsForum;

    public ForumAnswerObserverImpl(FundamentalsForum fundamentalsForum) throws RemoteException {
        this.fundamentalsForum = fundamentalsForum;

    }

    public ForumAnswerObserverImpl(ObjectOpForum objectOpForum) throws RemoteException {
        this.objectOpForum = objectOpForum;
    }

    public ForumAnswerObserverImpl(CollectionForum collectionForum) throws RemoteException {
        this.collectionForum = collectionForum;

    }

    public ForumAnswerObserverImpl(ExceptionForum exceptionForum) throws RemoteException {
        this.exceptionForum = exceptionForum;
    }

    public ForumAnswerObserverImpl(FileIoForum fileIoForum) throws RemoteException {
        this.fileIoForum = fileIoForum;

    }

    public ForumAnswerObserverImpl(InterfaceForum interfaceForum) throws RemoteException {
        this.interfaceForum = interfaceForum;
    }

    public ForumAnswerObserverImpl(OthersForum othersForum) throws RemoteException {
        this.othersForum = othersForum;

    }

    public ForumAnswerObserverImpl(ThreadsForum threadsForum) throws RemoteException {
        this.threadsForum = threadsForum;
    }

    @Override
    public void setMessage(String name, String message, String desc, String topic) throws RemoteException {
        System.out.println("maaaa"+message);
        System.out.println("maaaa"+name);
        if (fundamentalsForum != null) {
            fundamentalsForum.displayMessage(name, message, desc, topic);
        }
        if (objectOpForum != null) {
            objectOpForum.displayMessage(name, message, desc, topic);
        }
        if (collectionForum != null) {
            collectionForum.displayMessage(name, message, desc, topic);
        }
        if (exceptionForum != null) {
            exceptionForum.displayMessage(name, message, desc, topic);
        }
        if (fileIoForum != null) {
            fileIoForum.displayMessage(name, message, desc, topic);
        }
        if (interfaceForum != null) {
            interfaceForum.displayMessage(name, message, desc, topic);
        }
        if (othersForum != null) {
            othersForum.displayMessage(name, message, desc, topic);
        }
        if (threadsForum != null) {
            threadsForum.displayMessage(name, message, desc, topic);
        }
    }

    @Override
    public void setQustionMessage(String name, String topic, String desc) throws RemoteException {
        if (fundamentalsForum != null) {
            fundamentalsForum.displayQuestionMessage(name, topic, desc);
        }
        if (objectOpForum != null) {
            objectOpForum.displayQuestionMessage(name, topic, desc);
        }
        if (collectionForum != null) {
            collectionForum.displayQuestionMessage(name, topic, desc);
        }
        if (exceptionForum != null) {
            exceptionForum.displayQuestionMessage(name, topic, desc);
        }
        if (fileIoForum != null) {
            fileIoForum.displayQuestionMessage(name, topic, desc);
        }
        if (interfaceForum != null) {
            interfaceForum.displayQuestionMessage(name, topic, desc);
        }
        if (othersForum != null) {
            othersForum.displayQuestionMessage(name, topic, desc);
        }
        if (threadsForum != null) {
            threadsForum.displayQuestionMessage(name, topic, desc);
        }
    }

}
