package workspace;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CardReaderController {

    @FXML

    public void changeViewToDefaultScreen(ActionEvent e) throws IOException {
        App.setRootForScene("welcomeScreen");
    }
}
