package practice;

import java.net.ConnectException;
import java.sql.*;

public class CardDatabase {
    private static Connection databaseConnection = null;
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/flashcarddatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "HP14-bs580TU";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static PreparedStatement preparedInsertStatement = null;
    private static String insertQuestionAndAnswerQuery = "INSERT INTO carddata (question, answer) VALUES (?, ?)";

    public static void insertQuestionAndAnswer(String parsedQuestion, String parsedAnswer) {
        setUpDriver();
        setUpConnection();
        prepareInsertionStatement(parsedQuestion, parsedAnswer);
        executeQuery();
    }

    private static void setUpDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }
    }

    private static void setUpConnection() {
        try {
            databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }  
    }
    
    private static void prepareInsertionStatement(String question, String answer) {
        try {
            preparedInsertStatement = databaseConnection.prepareStatement(insertQuestionAndAnswerQuery);
            preparedInsertStatement.setString(1, question);
            preparedInsertStatement.setString(2, answer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery() {
        try {
            preparedInsertStatement.executeUpdate();
            System.out.println("DATA SUCCESSFULLY SAVED");
        } catch (SQLException e) {
            System.out.println("DATA UNSUCCESSFULLY SAVED");
            e.printStackTrace();
        }
    }
}