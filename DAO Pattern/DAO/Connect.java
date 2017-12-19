package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jorge Castillo
 */
public class Connect {
    
    //To use only in the DAO package
    protected Connection conn;
    
    //Necessary constants to connect to the database (MySQL)
    //JDBC Driver and URL:
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/sams";  //At the end of the string add the name of the database
    
        
    //User and Password from MySQL configuration:
    private final String USER = "JORGE";
    private final String PASS = "root";
    
    public boolean connect() throws SQLException, ClassNotFoundException {
        
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
            
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
        return conn != null;
    }
    
    public boolean closeConnection() throws SQLException {
        if(conn != null) {
            if(!conn.isClosed()) {
                conn.close();
                return true;
            }
        }
        return false;
    }
}