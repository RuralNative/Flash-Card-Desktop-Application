package workspace;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeScreenController {

    @FXML

    public void changeViewToCardMaker(ActionEvent e) throws IOException {
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    try {
                        App.setRootForScene("cardMakerInterface");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        };
        thread.start();
    }
    public void changeViewToCardReader(ActionEvent e) throws IOException {
        Thread thread = new Thread(){
            @Override public void run(){
                Platform.runLater(() -> {
                    try {
                        App.setRootForScene("cardReaderInterface");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        };
        thread.start();
    }

}

