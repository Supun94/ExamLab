/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import controller.StudentController;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Demo
 */
public class StudentReservation {

    private Map<String, StudentController> studentResv = new HashMap<>();

    public boolean reserveCustomer(String id, StudentController controller) {

        if (studentResv.containsKey(id)) {
            if (studentResv.get(id) == controller) {
                return true;
            } else {
                return false;
            }
        } else {
            studentResv.put(id, controller);
            return true;
        }
    }

    public boolean releaseCustomer(String id, StudentController controller) {
        if (studentResv.get(id) == controller) {
            studentResv.remove(id);
            return true;
        } else {
            return false;
        }
    }

}
