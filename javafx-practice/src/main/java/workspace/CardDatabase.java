package workspace;

import java.sql.*;

public class CardDatabase {
    private static Connection databaseConnection = null;
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/flashcard";
    private static final String USER = "root";
    private static final String PASSWORD = "HP14-bs580TU";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static PreparedStatement preparedInsertStatement = null;
    private static Statement selectStatement;
    private static String insertQuestionAndAnswerQuery = "INSERT INTO flashcardtable (question, answer) VALUES (?, ?)";

    public void insertQuestionAndAnswer(String parsedQuestion, String parsedAnswer) {
        setUpDriver();
        setUpConnection();
        prepareInsertionStatement(parsedQuestion, parsedAnswer);
        try {
            preparedInsertStatement.executeUpdate();
            System.out.println("DATA SUCCESSFULLY SAVED");
        } catch (SQLException e) {
            System.out.println("DATA UNSUCCESSFULLY SAVED");
            e.printStackTrace();
        }
    }

    public String selectQuestion(int questionID) {
        String question = null;
        String selectQuestionQuery = "SELECT question FROM flashcardtable WHERE ID = ID";
        setUpDriver();
        setUpConnection();
        try {
            selectStatement = databaseConnection.createStatement();
            ResultSet selectResult = selectStatement.executeQuery(selectQuestionQuery);
            while (selectResult.next()) {
                question = selectResult.getString("question");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public String selectAnswer(int questionID) {
        String answer = null;
        String selectAnswerQuery = "SELECT answer FROM flashcardtable WHERE ID = ID";
        setUpDriver();
        setUpConnection();
        try {
            selectStatement = databaseConnection.createStatement();
            ResultSet selectResult = selectStatement.executeQuery(selectAnswerQuery);
            while (selectResult.next()) {
                answer = selectResult.getString("question");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    private void setUpDriver() {
        try {
            Class.forName(DRIVER);
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
    
    private void prepareInsertionStatement(String question, String answer) {
        try {
            preparedInsertStatement = databaseConnection.prepareStatement(insertQuestionAndAnswerQuery);
            preparedInsertStatement.setString(1, question);
            preparedInsertStatement.setString(2, answer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}