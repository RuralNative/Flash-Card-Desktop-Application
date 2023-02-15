package workspace;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CardReaderController {

    private CardDatabase database = new CardDatabase();
    private ArrayList<Integer> indexList = database.selectID();

    @FXML
    public void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    //TODO: Function for the show button; showing the answer for the specific question by means of identifying the index first then showing the question to that row
    @FXML
    public void showAnswer(ActionEvent e) throws IOException {

    }

    //TODO: Implement function that moves to next question by index in the table and show the appropriate the question based on that. Also make sure that by the time the index is at the last available index in the table and the question is moved, the index would move to the very first index (1)
    @FXML
    public void moveToNextQuestion(ActionEvent e) {

    }

    //TODO: Implement function that moves to last question by index in the table and show the appropriate the question based on that. Also make sure that by the time the index is at the first index in the table and the question is moved, the index would move to the very last index
    @FXML 
    public void moveToLastQuestion(ActionEvent e) {

    }

    //TODO: Implement the reusable question to show the question depending on the index of the row taken from the parameter
    public void showQuestion(int ID) {
        setText
    }
}

