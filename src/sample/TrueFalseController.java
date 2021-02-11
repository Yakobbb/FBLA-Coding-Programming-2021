package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;

public class TrueFalseController extends QuestionLoader {

    @FXML private Label questionText;
    @FXML private ProgressBar progressBar;

    /*
    Initializes the .fxml objects
     */
    @FXML
    public void initialize() {

        questionText.setText(getQuestion());

        int progress = getProgress();
        progressBar.setProgress((double) progress / 5);
        setProgress(progress + 1);
    }

    /*
    The below two functions check whether what the user selected was correct
     */
    public void selectTrue() throws IOException {
        if (getAnswer1().equals("true")) loadCorrect();
        else loadIncorrect();
    }

    public void selectFalse() throws IOException{
        if (getAnswer1().equals("false")) loadCorrect();
        else loadIncorrect();
    }
}
