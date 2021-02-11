package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class EndController extends QuestionLoader{
    @FXML private Label score;
    @FXML private Button getResultsButton;
    @FXML private Label successfulResults;
    private final Stage window = Main.getWindow();

    /*
    Show the user their score, in both fraction and percentage form
     */
    public void initialize() {
        int totalCorrect = getTotalCorrect();
        double percentageCorrect = totalCorrect/5.0*100.0;

        score.setText("Your score: " + Integer.toString(totalCorrect) + "/5... or "
        + Integer.toString((int) percentageCorrect) + "%!");
    }

    /*
    Clear all of the data taken throughout the quiz, and load the main Menu
     */
    public void goBackToMenu() throws IOException {
        setProgress(0);
        clearQuestionIDsAlreadyDone();
        clearQuestionsAlreadyDone();
        clearRightOrWrong();
        setTotalCorrect(0);

        Parent menuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene menu = new Scene(menuRoot);
        menu.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        window.setScene(menu);

    }

    /*
    Utilize the data collected throughout the quiz, and use a writer object to make/modify the
    "results.txt" file based on this data. A for loop is used to loop over the five questions,
    and an if-else statement is used to see if any of the questions were of the Matching type.
    If this is the case, the method must write the results differently since there isn't
    one definite correct answer.
     */
    public void getResults() throws IOException {

        ArrayList<ArrayList<String>> questionsAlreadyDone = getQuestionsAlreadyDone();
        ArrayList<Boolean> rightOrWrong = getRightOrWrong();
        File resultsFile = new File("results.txt");
        FileWriter writer = new FileWriter("results.txt");

        writer.write("~FBLA Quiz RESULTS~\n\n");

        for (int i = 0; i < 5; i++) {
            String questionType = questionsAlreadyDone.get(i).get(0);
            writer.write("#" + Integer.toString(i+1) + ":  ");
            writer.write(questionsAlreadyDone.get(i).get(1) + "\n");
            writer.write("Answer:  ");

            if (questionType.equals("3")) {
                writer.write(questionsAlreadyDone.get(i).get(3) + "  ->  " + questionsAlreadyDone.get(i).get(2)
                + "\n");
                writer.write("         " + questionsAlreadyDone.get(i).get(4) + "  ->  "
                + questionsAlreadyDone.get(i).get(6) + "\n");
                writer.write("         " + questionsAlreadyDone.get(i).get(5) + "  ->  "
                        + questionsAlreadyDone.get(i).get(7) + "\n");

            } else writer.write(questionsAlreadyDone.get(i).get(2) + "\n");

            if (rightOrWrong.get(i).equals(true)) writer.write("You got this question CORRECT\n\n");
            else writer.write("You got this question WRONG\n\n");

        }

        writer.close();

        /*
        Reset all necessary values for the next quiz
         */
        setProgress(0);
        clearQuestionIDsAlreadyDone();
        clearQuestionsAlreadyDone();
        clearRightOrWrong();
        setTotalCorrect(0);

        /*
        Show that the results were created successfully, and hide the "Get Results" button
         */
        successfulResults.setOpacity(1.0);
        getResultsButton.setVisible(false);

    }
}
