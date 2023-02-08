package workspace;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CardMakerController {

    @FXML

    TextField questionContainer = new TextField();
    TextArea answerContainer = new TextArea();
    Button saveButton = new Button();

    private void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    private void saveCard() {
        //TODO: Check if both Question and Answer meets minimum/maximum content; if true then parse question and answer, then save into database; else show a dialog telling user to check inputs
        if (checkIfQuestionAndAnswerMeetsConditions() ==  true) {
            saveDataToDatabase();
        } else {}
    }

    private String parseQuestion() {
        String cardQuestion = questionContainer.getText();
        return cardQuestion;
    }

    private String parseAnswer() {
        String cardAnswer = answerContainer.getText();
        return cardAnswer;
    }

    private boolean checkIfQuestionAndAnswerMeetsConditions() {
        boolean checkResult = false;
        if (checkIfQuestionAndAnswerHasValue() == true) {
            if (checkIfQuestionAndAnswerMeetsLimit(5, 250) == true) {
               checkResult = true;
            } else {
                checkResult = false;
            }
        } else {
            checkResult = false;
        }
        return checkResult;
    }
    
    private boolean checkIfQuestionAndAnswerHasValue() {
        boolean checkResult = false;
        if (parseQuestion() == null || parseAnswer() == null) {
            showDialogForQuestionAndAnswerBeingNull();
        } else {
            checkResult = true;
        }
        return checkResult;
    }

    private boolean checkIfQuestionAndAnswerMeetsLimit(int minChars, int maxChars) {
        int questionTextCount = parseQuestion().length();
        int answerTextCount = parseAnswer().length();
        boolean checkResult = false;
        if (questionTextCount < minChars || questionTextCount > maxChars) {
            showDialogForQuestionAndAnswerReachingLimit();
        } else if (answerTextCount < minChars || answerTextCount > maxChars) {
            showDialogForQuestionAndAnswerReachingLimit();
        } else {
            checkResult = true;
        } 
        return checkResult;
    }

    private void saveDataToDatabase() {
        //TODO: Save question and answer to a database
    }

    private void showDialogForQuestionAndAnswerBeingNull() {
        //TODO: Show a dialog scene showing message for user to review content 
    }

    private void showDialogForQuestionAndAnswerReachingLimit() {
        //TODO: Show a dialog scene showing message for user to review content 
    }


}

