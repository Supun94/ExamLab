/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pool.PooledDriver;

/**
 *
 * @author Demo
 */
public class DBConnection {

    private static PooledDriver driver;

    /**
     *
     * @return Connection reference
     * @throws ClassNotFoundException
     * @throws SQLException
     */
//    public static Connection getConnection() throws ClassNotFoundException, SQLException{
//    Class.forName("com.mysql.jdbc.Driver");
//    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ExamLab","root","mysql");
//    return conn;
//}

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        driver = PooledDriver.initializeDriver("jdbc:mysql://localhost/ExamLab", "root", "mysql", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:pool");
    }

    public static void releaseConnection(Connection connection) {
        driver.releaseConnection(connection);
    }

}
