package workspace;

import java.sql.*;

public class CardDatabase {
    static final String DATABASE_URL = "jdbc:mysql://root/flashcarddatabase";
    static final String USER = "root";
    static final String PASSWORD = "123456789";
    Connection databaseConnection;
    PreparedStatement databaseStatement;

    private void startConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("ERROR: DRIVER CLASS UNABLE TO LOAD");
            System.exit(1);
        }
        databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    private void prepareStatement() throws SQLException {
        try {
            databaseStatement = databaseConnection.prepareStatement();
        } catch (SQLException sqle) {
            System.out.println("ERROR: CONNECTION STATEMENT FAILED TO LOAD");
        }
    }
    
}