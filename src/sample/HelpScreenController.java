package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HelpScreenController {

    /*
    No .fxml objects need to be declared, since they are already formatted correctly in the
    HelpScreen.fxml file.
     */

    /*
    When the user clicks the back arrow, load the main menu.
     */
    public void returnHome() throws IOException {

        Parent menuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene menu = new Scene(menuRoot);
        menu.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        Main.getWindow().setScene(menu);

    }

}
