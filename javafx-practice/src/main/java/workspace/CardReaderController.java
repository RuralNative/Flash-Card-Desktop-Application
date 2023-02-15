package workspace;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CardReaderController {

    private CardDatabase database = new CardDatabase();
    private ArrayList<Integer> indexList = database.selectID();
    
    private int index = 0;
    private int lastID = indexList.get(indexList.size()-1);
    private int firstID = indexList.get(0);
    private int currentID = indexList.get(index);
    

    private TextField questionContainer = new TextField();
    private TextArea answerContainer = new TextArea();

    @FXML
    public void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    @FXML
    public void showAnswer(ActionEvent e) throws IOException {
        String answerString = database.selectAnswer(currentID);
        answerContainer.setText(answerString);
    }

    @FXML
    public void moveToNextQuestion(ActionEvent e) throws IOException {
        if (currentID == lastID) {
            index = 0;
            showQuestion(currentID);
        } else {
            ++index;
            showQuestion(currentID);
        }
    }

    @FXML 
    public void moveToLastQuestion(ActionEvent e) throws IOException {
        if (currentID == firstID) {
            index = lastID;
            showQuestion(currentID);
        } else {
            --index;
            showQuestion(currentID);
        }
    }

    public void showQuestion(int ID) throws IOException {
        String questionString = null;
        try {
            questionString = database.selectQuestion(currentID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        questionContainer.setText(questionString);
    }
}

