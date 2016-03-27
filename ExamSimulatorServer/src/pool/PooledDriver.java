/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author cmjd
 */
public class PooledDriver implements Driver {

    private static PooledDriver driver;
    private final String PREFIX;
    private ConnectionPool connectionPool;

    private PooledDriver(ConnectionPool connectionPool, String className) throws ClassNotFoundException, SQLException {
        PREFIX = "jdbc:pool";
        Class.forName(className);
        DriverManager.registerDriver(this);
        this.connectionPool = connectionPool;

    }

    public static PooledDriver initializeDriver(String url, String user, String password, String className) throws ClassNotFoundException, SQLException {
        if (driver == null) {
            driver = new PooledDriver(new ConnectionPool(url, user, password), className);

        }
        return driver;
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (acceptsURL(url)) {
            return connectionPool.getConnection();
        }
       // throw new IllegalArgumentException("Invalid Url :" + url);
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        if (url.startsWith(PREFIX)) {
            return true;
        }
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1) throws SQLException {
        return new DriverPropertyInfo[]{};
    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger("PooledDriver");
    }
    
    public  void releaseConnection(Connection connection){
        connectionPool.releaseConnection((PooledConnection)connection);
    }
}
