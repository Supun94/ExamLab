/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cmjd
 */
public class ID implements Comparable<ID> {
    private String id;
    private long lastUsed;
    private boolean inUse;
    
    public ID(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    
    public boolean isInUse() {
        return inUse;
    }

    public long getLastUsed() {
        return lastUsed;
    }

    public boolean lease(){
        if (inUse) {
            return false;
        }
        inUse = true;
        lastUsed = System.currentTimeMillis();
        return true;
    }
    
    public void stopLease(){
        inUse = false;
    }

    @Override
    public int compareTo(ID arg0) {
       return id.compareTo(arg0.id);
    }
    
}
