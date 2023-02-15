package workspace;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static Parent sceneRoot;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            sceneRoot = FXMLLoader.load(getClass().getResource("/fxml/welcomeScreen.fxml"));
            
            scene = new Scene(sceneRoot);
            
            stage.setTitle("JavaFX Practice");
            Image icon = new Image(getClass().getResourceAsStream("favicon.png")); //Refer to Notes Line 4 - 6 
            stage.getIcons().add(icon);
            
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Refer to Notes
    static void setRootForScene(String fxmlFile) throws IOException {
        scene.setRoot(loadFXML(fxmlFile));
    }

    //Refer to Notes
    private static Parent loadFXML(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/"+ fxmlFile + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }


}