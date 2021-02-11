package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import java.io.IOException;


public class FillInController extends QuestionLoader {

    @FXML private Label questionText;
    @FXML private ProgressBar progressBar;
    @FXML private TextField textField;

    /*
    Make sure the .fxml nodes are showing the correct question text and progress bar
     */
    public void initialize() {

        questionText.setText(getQuestion());

        int progress = getProgress();
        progressBar.setProgress((double) progress / 5);
        setProgress(progress + 1);

    }

    /*
    If "Enter" is pressed, check to see if the text field matches the answer. If it does, go to the
    correct answer screen. If it doesn't, go to the incorrect answer screen.
     */
    @FXML
    public void pressedEnter(KeyEvent key) throws IOException {
        if (key.getCode().toString().equals("ENTER") && textField.getText().equals(getAnswer1())) loadCorrect();
        else if (key.getCode().toString().equals("ENTER")) loadIncorrect();
    }

}
