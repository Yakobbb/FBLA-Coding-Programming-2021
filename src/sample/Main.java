package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage window;


    /*
    Initializes the JavaFX framework, and loads the menu screen
     */
    @Override
    public void start(Stage stage) throws Exception{
        window = stage;
        window.setResizable(false);
        window.setTitle("FBLA Quiz");
        window.getIcons().add(new Image("/images/AppIcon.png"));

        /*
        Loads the corresponding .fxml file, as well as the Style.css
        sheet (this is done for every scene that is loaded)
        */
        Parent menuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene menu = new Scene(menuRoot);
        menu.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        /*
        Then the scene is loaded to the Stage object
         */
        window.setScene(menu);
        window.show();

    }

    /*
    Used by other controller classes so that they can load their scenes in the same window,
    rather than always open a new one.
     */
    public static Stage getWindow() {
        return window;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
