package workspace;

import java.net.ConnectException;
import java.sql.*;

public class CardDatabase {
    private static Connection databaseConnection = null;
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/flashcarddatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    String insertQuestionAndAnswerQuery = "INSERT INTO carddata (question, answer) VALUES (?, ?)";

    private void setUpDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }
    }

    private void setUpConnection() {
        try {
            databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }  
    }
    

    public void insertQuestionAndAnswer(String question, String answer) throws SQLException {
        try {		 
            Class.forName(DRIVER);
            Connection databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement connectionStatement = databaseConnection.createStatement();     
            System.out.println("Inserting records into the table...");          
            String sqlQueryString = "INSERT INTO carddata VALUES (null, question, answer)";
            connectionStatement.executeUpdate(sqlQueryString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }

    public String retrieveQuestionString(int ID) {
        String questionString = null;
        try {		 
            Class.forName(DRIVER);
            Connection databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement connectionStatement = databaseConnection.createStatement();     
            System.out.println("Inserting records into the table...");          
            String sqlQueryString = "SELECT question FROM carddata" +
            " WHERE id >=" + ID;
            ResultSet queryResultSet = connectionStatement.executeQuery(sqlQueryString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
        return questionString;
    }

    public String retrieveAnswerString(int ID) {
        String answerString = null;
        return answerString;
    }
}