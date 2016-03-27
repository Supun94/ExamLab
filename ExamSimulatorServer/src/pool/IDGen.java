/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

/**
 *
 * @author cmjd
 */
public class IDGen {
    public static String nextId(String currentId){
        String nextId = null;
        int index = 0;
        for (int i = 0; i < currentId.length(); i++) {
            if (Character.isDigit(currentId.charAt(i))) {
                index = i;
                break;
            }
        }
        String prefix;
        int num;
 
        prefix = currentId.substring(0, index);
        num = Integer.parseInt(currentId.substring(index+1));
        num++;
        if (num < 10) {
            nextId = prefix + "000" + num;
        } else if (num < 100) {
            nextId = prefix + "00" + num;
        } else if (num < 1000) {
            nextId = prefix + "0" + num;
        } else if (num < 10000) {
            nextId = prefix + num;
        }
        return nextId;
    }
}
