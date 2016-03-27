/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Supun
 */
public interface ForumAnswerObserverController extends Remote{
    public void setMessage(String name,String message,String desc,String topic)throws RemoteException;

    public void setQustionMessage(String name, String topic, String desc) throws RemoteException;
}
