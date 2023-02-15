package workspace;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CardReaderController {

    @FXML
    public void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    //TODO: Implement function that moves to next question by index in the table and show the appropriate the question based on that. Also make sure that by the time the index is at the last available index in the table and the question is moved, the index would move to the very first index (1)
    public void moveToNextQuestion(ActionEvent e) {

    }

    //TODO: Implement function that moves to last question by index in the table and show the appropriate the question based on that. Also make sure that by the time the index is at the first index in the table and the question is moved, the index would move to the very last index 
    public void moveToLastQuestion(ActionEvent e) {

    }

    //TODO: Function for the show button; showing the answer for the specific question
    public void showAnswer(ActionEvent e) throws IOException {

    }
}

