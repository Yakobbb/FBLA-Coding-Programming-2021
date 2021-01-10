package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleChoiceController extends QuestionLoader {
    @FXML private Label questionText;
    @FXML private RadioButton choice1;
    @FXML private RadioButton choice2;
    @FXML private RadioButton choice3;
    @FXML private RadioButton choice4;
    @FXML private Button submit;
    @FXML private ProgressBar progressBar;

    /*
    A toggle group is needed so that multiple possible answers can't be chosen at the same time.
     */
    @FXML final ToggleGroup group = new ToggleGroup();


    /*
    Initializes all .fxml objects
     */
    @FXML
    public void initialize() {

        questionText.setText(getQuestion());

        RadioButton[] arrayOfChoices = {choice1, choice2, choice3, choice4};
        List<RadioButton> listOfChoices = Arrays.asList(arrayOfChoices);
        Collections.shuffle(listOfChoices);

        listOfChoices.get(0).setText(getAnswer1());
        listOfChoices.get(1).setText(getPa1());
        listOfChoices.get(2).setText(getPa2());
        listOfChoices.get(3).setText(getPa3());

        int progress = getProgress();
        progressBar.setProgress((double) progress / 5);
        setProgress(progress + 1);

    }

    /*
    Initially, no answer choice is selected, which prevents the user from submitting an answer.
    Once the user chooses an answer, the submit button is enabled.
     */
    public void selectChoice() {
        submit.setDisable(false);
    }

    public void submit() throws IOException {
        if (choice1.isSelected() && choice1.getText().equals(getAnswer1())) loadCorrect();
        else if (choice2.isSelected() && choice2.getText().equals(getAnswer1())) loadCorrect();
        else if (choice3.isSelected() && choice3.getText().equals(getAnswer1())) loadCorrect();
        else if (choice4.isSelected() && choice4.getText().equals(getAnswer1())) loadCorrect();
        else loadIncorrect();
    }
}
