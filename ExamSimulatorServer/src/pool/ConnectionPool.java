/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cmjd
 */
public class ConnectionPool {

    private List<PooledConnection> connectionsList;
    private String url;
    private String user;
    private String password;

    public ConnectionPool(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        connectionsList = new ArrayList<>(10);
        new ReapConnection().start();
    }

    public Connection getConnection() throws SQLException {
        for (PooledConnection pooledConnection : connectionsList) {
            if (pooledConnection.lease()) {
                return pooledConnection;
            }
        }
        Connection conn = DriverManager.getConnection(url, user, password);
        PooledConnection connection = new PooledConnection(conn);
        connectionsList.add(connection);
        connection.lease();
        return connection;
    }
    
    public void releaseConnection(PooledConnection pooledConnection){
        pooledConnection.stopLease();
    }
    
    public void removeConnection(PooledConnection connection){
        connectionsList.remove(connection);
    }
    
    class ReapConnection extends Thread{

        @Override
        public void run() {
            while(true){
                for (PooledConnection pooledConnection : connectionsList) {
                    if((pooledConnection.isValid()) && ((1000*60*60)<=System.currentTimeMillis()-pooledConnection.lastUsed)){
                        removeConnection(pooledConnection);
                    }
                }
                try{
                    Thread.sleep(1000*60*60);
                }catch(InterruptedException e){
                    Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            
        }
        
    }
}





























