package workspace;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    try {
                        App.setRootForScene("welcomeScreen");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        };
        thread.start();
    }

    @FXML
    public void saveCard(ActionEvent e) {
        String cardQuestion = questionContainer.getText();
        String cardAnswer = answerContainer.getText();
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    if (isQuestionConditionsMet() == false || isAnswerConditionsMet() == false) {
                        System.out.println("DATA UNSUCCESSFULLY SAVED");
                        conditionsUnmetDialog();
                    } else {
                        database.insertQuestionAndAnswer(cardQuestion, cardAnswer);
                        questionContainer.setText("");
                        answerContainer.setText("");
                        dataSavedDialog();
                    }
                });
            }
        };
        thread.start();
    }

    @FXML
    private void conditionsUnmetDialog() {
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("WARNING");
                    alert.setHeaderText("CHECK QUESTION AND ANSWER FOR CONTENT");
                    alert.setContentText("Please check if either or both of your question and answer have text content, or if both follow the minimum and maximum count of characters shown in the prompt text.");
                    alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                    alert.showAndWait();
                });
            }
        };
        thread.start();
    }

    @FXML
    private void dataSavedDialog() {
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setTitle("NOTE");
                    alert.setHeaderText("DATA SUCCESSFULLY SAVED");
                    alert.setContentText("Your question and answer are successfully saved");
                    alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                    alert.showAndWait();
                });
            }
        };
        thread.start();
        
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
}

