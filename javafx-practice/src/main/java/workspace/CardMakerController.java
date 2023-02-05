package workspace;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CardMakerController {

    @FXML

    private void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    private void saveCard() {
        //TODO: Check if both Question and Answer meets minimum/maximum content; if true then parse question and answer, then save into database; else show a dialog telling user to check inputs
    }

    private String parseQuestion() {
        String cardQuestion = null;
        //TODO: Insert code for parsing String text from question text area
        return cardQuestion;
    }

    private String parseAnswer() {
        String cardAnswer = null;
        //TODO: Insert code for parsing String text from answer text area
        return cardAnswer;
    }

    private boolean checkIfQuestionAndAnswerMeetsConditions(int minChars, int maxChars) {
        boolean checkResult = false;
        //TODO: Insert code for checking if both question and answers meet the following conditions:(1) has content, (2) meets minimum characters, and (3) meets maximum characters
        return checkResult;
    }

    private void saveDataToDatabase() {
        //TODO: Save question and answer to a database
    }

    private void showDialogForUserReview() {
        //TODO: Show a dialog scene showing message for user to review content 
    }


}

