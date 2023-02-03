package workspace;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        scene = new Scene(root,Color.RED);
        
        stage.setTitle("JavaFX Practice");
        Image icon = new Image(getClass().getResourceAsStream("favicon.png")); //Refer to Notes Line 4 - 6 
        stage.getIcons().add(icon);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}