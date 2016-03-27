/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.ID;

/**
 *
 * @author cmjd
 */
public class IdPool {

    private List<ID> idList;

    public IdPool() {
        idList = new ArrayList<>();
    }

    public ID getId() {
        for (ID id : idList) {
            if (id.lease()) {
                return id;
            }
        }

        if (idList.isEmpty()) {
            return null;
        }
        Collections.sort(idList);
        ID lastID = idList.get(idList.size() - 1);
        String nextId = IDGen.nextId(lastID.getId());
        ID newID = new ID(nextId);
        newID.lease();
        idList.add(newID);
        return newID;
    }

    public void releaseID(String id){
        for (ID i : idList) {
            if (i.getId().equals(id)) {
                i.stopLease();
                break;
            }
        }
    }
    
    public void removeID(String id){
        for (ID i : idList) {
            if (i.getId().equals(id)) {
                idList.remove(i);
                break;
            }
        }
    }
    
    public void addId(ID id) {
        id.lease();
        idList.add(id);
    }
}
