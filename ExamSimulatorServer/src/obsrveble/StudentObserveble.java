/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obsrveble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.StudentObserverController;


/**
 *
 * @author Supun
 */
public class StudentObserveble {
    static ArrayList<StudentObserverController> observeControllers = new ArrayList<>();
    private int onlineStu=0;
    public void addObserve(StudentObserverController controller){
        try {
            observeControllers.add(controller);
            setMessage(observeControllers.size()+"");
            System.out.println(observeControllers.size());
        } catch (RemoteException ex) {
            Logger.getLogger(StudentObserveble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeObserve(StudentObserverController controller){
        //observeControllers.remove(controller);
        try {
            observeControllers.remove(controller);
            setMessage(observeControllers.size()-1+"");
            System.out.println(observeControllers.size());
        } catch (RemoteException ex) {
            Logger.getLogger(StudentObserveble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void setMessage(String message) throws RemoteException{
//        for (StudentObserverController customerObserveController : observeControllers) {
//            new UpdateObserves(customerObserveController, message).start();
//        }
//    }
//    
////    public static void setCustomerId(String id) throws RemoteException{
////        for (StudentObserverController customerObserveController : observeControllers) {
////            customerObserveController.set(id);
////        }
////    }
//    
//    
//    
//    private class UpdateObserves extends Thread{
//        private StudentObserverController controller;
//        private String message;
//
//        public UpdateObserves() {
//        }
//
//        public UpdateObserves(StudentObserverController controller, String message) {
//            this.controller = controller;
//            this.message = message;
//        }
//
//        @Override
//        public void run() {
//            try {
//                controller.update(message);
//            } catch (RemoteException ex) {
//                Logger.getLogger(StudentObserveble.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//    }
    
    public void setMessage(String message) throws RemoteException{
        int count=observeControllers.size()-1;
        for (StudentObserverController customerObserveController : observeControllers) {
            new UpdateObserves(customerObserveController, count+"").start();
        }
    }
    
    
    
//    public static void setCustomerId(String id) throws RemoteException{
//        for (StudentObserverController customerObserveController : observeControllers) {
//            customerObserveController.setCustomerId(id);
//        }
//    }
    
    
    
    private class UpdateObserves extends Thread{
        private StudentObserverController controller;
        private String message;

        public UpdateObserves() {
        }

        public UpdateObserves(StudentObserverController controller, String message) {
            this.controller = controller;
            this.message = message;
        }

        @Override
        public void run() {
            try {
                controller.setMessage(message);
            } catch (RemoteException ex) {
                Logger.getLogger(StudentObserveble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
