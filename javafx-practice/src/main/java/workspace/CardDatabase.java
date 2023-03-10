package workspace;

import java.sql.*;
import java.util.ArrayList;

public class CardDatabase {
    private static Connection databaseConnection = null;
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/flashcard";
    private static final String USER = "root";
    private static final String PASSWORD = "HP14-bs580TU";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static PreparedStatement preparedInsertStatement = null;
    private static Statement selectStatement;
    private static String insertQuestionAndAnswerQuery = "INSERT INTO flashcardtable (question, answer) VALUES (?, ?)";

    public ArrayList<Integer> selectID() {
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        String selectQuestionQuery = "SELECT ID FROM flashcardtable";
        setUpDriver();
        setUpConnection();
        try {
            selectStatement = databaseConnection.createStatement();
            ResultSet selectResult = selectStatement.executeQuery(selectQuestionQuery);
            while (selectResult.next()) {
                indexList.add(selectResult.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return indexList;
    }

    public String selectQuestion(int questionID) throws SQLException{
        String question = null;
        String query = "SELECT question FROM flashcardtable WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        ResultSet selectResult = null;
        try {    
            setUpDriver();
            setUpConnection();
            preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setInt(1, questionID);
            selectResult = preparedStatement.executeQuery();;
            while (selectResult.next()) {
                question = selectResult.getString("question");      
            }
            selectResult.close();
            preparedStatement.close();
            databaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public String selectAnswer(int answerID) throws SQLException {
        String answer = null;
        String query = "SELECT answer FROM flashcardtable WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        ResultSet selectResult = null;
        try {    
            setUpDriver();
            setUpConnection();
            preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.setInt(1, answerID);
            selectResult = preparedStatement.executeQuery();;
            while (selectResult.next()) {
                answer = selectResult.getString("answer");      
            }
            selectResult.close();
            preparedStatement.close();
            databaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
    
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