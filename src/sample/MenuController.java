package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
This class handles all the functions for the Menu screen, which includes selecting a category for the quiz, as
well as handling the methods that are called when the different Button objects from the MainMenu.fxml file are
pressed. Each method is of a similar format: they all load another scene.
 */
public class MenuController {

    private final Stage window = Main.getWindow();

    /*
    Loads help scene
     */
    public void goToHelpScreen() throws IOException {

        Parent helpScreenRoot = FXMLLoader.load(getClass().getResource("HelpScreen.fxml"));
        Scene helpScreen = new Scene(helpScreenRoot);
        helpScreen.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        window.setScene(helpScreen);

    }

    /*
    Loads instructions scene
     */
    public void goToInstructions() throws IOException {

        Parent eventsRoot = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Scene events = new Scene(eventsRoot);
        events.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        window.setScene(events);
    }

    /*
    Each of the following methods sets the category for the questionLoader class, so that it knows
    which range of questions it can choose from in the database (since they are ordered by category).
     */
    public void pressedEvents() throws IOException {
        goToInstructions();
        QuestionLoader.setCategory("Events");
    }

    public void pressedByLaws() throws IOException {
        goToInstructions();
        QuestionLoader.setCategory("ByLaws");
    }

    public void pressedRandom() throws IOException {
        goToInstructions();
        QuestionLoader.setCategory("Random");
    }

    public void pressedEverything() throws IOException {
        goToInstructions();
        QuestionLoader.setCategory("Everything");
    }

}
