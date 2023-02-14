package workspace;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CardMakerController {
    
    private CardDatabase database = new CardDatabase();

    @FXML
    private TextField questionContainer;

    @FXML
    private TextArea answerContainer;

    @FXML
    public void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    @FXML
    public void saveCard(ActionEvent e) {
        String cardQuestion = questionContainer.getText();
        String cardAnswer = answerContainer.getText();
        if (isQuestionConditionsMet() == false || isAnswerConditionsMet() == false) {
            System.out.println("DATA UNSUCCESSFULLY SAVED");
        } else {
            database.insertQuestionAndAnswer(cardQuestion, cardAnswer);
            questionContainer.setText("");
            answerContainer.setText("");
        }
        
    }

    private boolean isQuestionConditionsMet() {
        int questionLength = questionContainer.getText().length();
        boolean conditionsMet;
        if (questionLength >= 5 && questionLength <= 255) {
            conditionsMet = true;
        } else {
            System.out.println("CONDITIONS FOR QUESTION ARE NOT MET");
            conditionsMet = false;
        }
        return conditionsMet;
    }

    private boolean isAnswerConditionsMet() {
        int answerLength = answerContainer.getText().length();
        boolean conditionsMet;
        if (answerLength >= 5 && answerLength <= 255) {
            conditionsMet = true;
        } else {
            System.out.println("CONDITIONS FOR ANSWER ARE NOT MET");
            conditionsMet = false;
        }
        return conditionsMet;
    }

    //TODO: Make sure answer container is wrapped
    //TODO: Check if the content of container meets condition such as minimum characters and maximum characters, all containers must have content, before save is successfully ran
}

