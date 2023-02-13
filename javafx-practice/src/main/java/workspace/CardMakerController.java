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
        System.out.println("cardQuestion" + cardAnswer);
        database.insertQuestionAndAnswer(cardQuestion, cardAnswer);
    }
}

