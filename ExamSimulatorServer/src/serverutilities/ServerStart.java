/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverutilities;


import controller.RemoteFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Supun
 */
public class ServerStart {
    public static void main(String[] args) {
        try {
            Registry thogakadeRegistry = LocateRegistry.createRegistry(5051);
            thogakadeRegistry.rebind("QuestionServer",new RemoteFactoryImpl());
            System.out.println("Server Start...");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
