package workspace;

import java.sql.*;

public class CardDatabase {
    static final String DATABASE_URL = "jdbc:mysql://root/flashcarddatabase";
    static final String USER = "root";
    static final String PASSWORD = "123456789";
    Connection databaseConnection;
    PreparedStatement databaseStatement;

    public void insertQuestionData(String question, String answer) throws SQLException {
        try (
        databaseConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        databaseStatement = databaseConnection.prepareStatement(question);
        ) {
            String sql = "INSERT INTO carddata VALUES (null, question, answer)";
            databaseStatement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnection.close();
        }
    }
}