package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.io.IOException;
import java.sql.SQLException;


public class CorrectController extends QuestionLoader {

    @FXML private ProgressBar progressBar;
    private int progress = getProgress();

    /*
    Make sure progress bar is shown with correct progress, add 1 to the total amount of questions
    answered correctly, and add true (which indicates correct) to the ordered ArrayList of what the
    user answered for each question (if it was right or wrong)
     */
    public void initialize() {
        progressBar.setProgress((double) progress / 5);
        setTotalCorrect(getTotalCorrect() + 1);
        addToRightOrWrong(true);
    }

    /*
    If 5 questions have been done, go to the ending screen. Else, add the current question
    to the ArrayList of ones already done, and go to the next question
     */
    public void goOnward() throws IOException, SQLException {
        if (progress == 5) {
            loadEnd();
        } else {
            addToQuestionIDsAlreadyDone(getQuestionID());
            goToQuestion();
        }

    }
}
