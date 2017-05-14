package edu.liberty.bemccandless.csis505.finalproject.tuneup.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles database connections.
 * 
 * @author bemccandless
 */
public final class DbConfig {
    
    private static final String USERNAME = "tuneup";
    private static final String PASSWORD = "tuneup";
    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/TuneUp";
    
    private static Connection dbConnection;
    
    /**
     * Gets a new connection to the database,
     * 
     * @return
     * @throws SQLException 
     */
    public static Connection getDbConnection() throws SQLException {
        return dbConnection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
    
    /**
     * Closes an existing connection to the database.
     * 
     * @throws SQLException 
     */
    public static void close() throws SQLException {
        dbConnection.close();
    }

}
