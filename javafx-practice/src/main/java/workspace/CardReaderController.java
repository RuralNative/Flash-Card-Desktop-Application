package workspace;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Platform;
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
    
    @FXML
    private TextArea answerContainer;

    @FXML
    private TextField questionContainer;

    @FXML
    public void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }

    @FXML
    public void showAnswer(ActionEvent e) throws IOException, SQLException {
        currentID = indexList.get(this.index); //Changes currentID value to current index value
        String answerString = database.selectAnswer(currentID);
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    answerContainer.setText(answerString);
                    System.out.println(answerString);
                });
            }
        };
        thread.start();
    }

    @FXML
    public void moveToNextQuestion(ActionEvent e) throws IOException, SQLException {
        currentID = indexList.get(this.index); //Changes currentID value to current index value
        if (currentID == lastID) {
            index = 0;
            showQuestion(currentID);
        } else {
            ++index;
            showQuestion(currentID);
            questionContainer.setText("");
            answerContainer.setText("");
        }
    }

    @FXML 
    public void moveToLastQuestion(ActionEvent e) throws IOException, SQLException {
        currentID = indexList.get(this.index); //Changes currentID value to current index value
        if (currentID == firstID) {
            index = indexList.size()-1;
            showQuestion(currentID);
        } else {
            --index;
            showQuestion(currentID);
            questionContainer.setText("");
            answerContainer.setText("");
        }
    }

    public void showQuestion(int ID) throws IOException, SQLException {
        currentID = indexList.get(this.index); //Changes currentID value to current index value
        String questionString = database.selectQuestion(currentID);
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {     
                    questionContainer.setText(questionString);
                    System.out.println(questionString);
                });
            }
        };
        thread.start();
    }
}