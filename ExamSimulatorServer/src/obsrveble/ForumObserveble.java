/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package obsrveble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.ForumAnswerObserverController;


/**
 *
 * @author Supun
 */
public class ForumObserveble {
    static ArrayList<ForumAnswerObserverController> observeControllers = new ArrayList<>();
    private int onlineStu=0;
    public void addObserve(ForumAnswerObserverController controller){
        observeControllers.add(controller);
    }
    
    public void removeObserve(ForumAnswerObserverController controller){
        observeControllers.remove(controller);
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
    
    
    
    public void notifyObserve(String name,String message,String desc,String topic) throws RemoteException{
        for (ForumAnswerObserverController forumAnswerObserverController : observeControllers) {
            new UpdateObserves(forumAnswerObserverController, name, message,desc,topic).start();
        }
        
    }

    public void notifyNewQuestionObserve(String name, String topic, String desc) {
        for (ForumAnswerObserverController forumAnswerObserverController : observeControllers) {
            new UpdateQuestionObserves(forumAnswerObserverController, name, topic,desc).start();
        }
    }
    
    
    
    
//    public static void setCustomerId(String id) throws RemoteException{
//        for (StudentObserverController customerObserveController : observeControllers) {
//            customerObserveController.setCustomerId(id);
//        }
//    }
    
    
    
    private class UpdateObserves extends Thread{
        private ForumAnswerObserverController controller;
        private String message;
        private String name;
        private String topic;
        private String desc;

        public UpdateObserves() {
        }

        public UpdateObserves(ForumAnswerObserverController controller, String message,String name) {
            this.controller = controller;
            this.name = name;
            this.message = message;
        }
        
        public UpdateObserves(ForumAnswerObserverController controller, String name,String message,String topic,String desc) {
            this.controller = controller;
            this.name = name;
            this.message=message;
            this.topic = topic;
            this.desc = desc;
        }

        @Override
        public void run() {
            try {
                controller.setMessage(name,message,desc,topic);
                System.out.println("mess"+message);
                System.out.println("mess"+name);
                //controller.setQustionMessage(name,topic,desc);
            } catch (RemoteException ex) {
                Logger.getLogger(StudentObserveble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    ////////////////////////////////////////////////////////////
    
    
       private class UpdateQuestionObserves extends Thread{
        private ForumAnswerObserverController controller;
        private String name;
        private String topic;
        private String desc;

        public UpdateQuestionObserves() {
        }

    
        
        public UpdateQuestionObserves(ForumAnswerObserverController controller, String name,String topic,String desc) {
            this.controller = controller;
            this.name = name;
            this.topic = topic;
            this.desc = desc;
        }

        @Override
        public void run() {
            try {
               
                controller.setQustionMessage(name,topic,desc);
            } catch (RemoteException ex) {
                Logger.getLogger(StudentObserveble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
