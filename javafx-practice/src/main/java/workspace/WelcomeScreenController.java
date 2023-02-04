package workspace;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeScreenController {

    @FXML

    public void changeViewToCardMaker(ActionEvent e) {
    
    }

    public void changeViewToCardReader(ActionEvent e) throws IOException {
        App.setRootForScene("secondary");
    }
}

