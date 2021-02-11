package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.io.IOException;
import java.sql.SQLException;


public class IncorrectController extends QuestionLoader{

    @FXML private Label firstStatement;
    @FXML private Label secondStatement;
    @FXML private Label thirdStatement;
    @FXML private Label fourthStatement;
    @FXML private ProgressBar progressBar;
    private int progress = getProgress();

    /*
    Initialize all the .fxml objects, and check whether the question that was just done incorrectly
    was a Matching question, or not. If it was, it has to display all of the correct match-ups in
    the form of "potential answer  -->  correct answer". If the question was of a different type, then
    simply displays the correct answer.
     */
    public void initialize() {
        progressBar.setProgress((double) progress / 5);
        addToRightOrWrong(false);

        if (getQuestionType() == 1 || getQuestionType() == 2 || getQuestionType() == 4) {

            String answer = getAnswer1();

            firstStatement.setText("Correct Answer: ");

            if (answer.equals("true") || answer.equals("false")) {
                secondStatement.setText(answer.substring(0, 1).toUpperCase() + answer.substring(1));
            } else {
                secondStatement.setText(answer);
            }

            thirdStatement.setVisible(false);
            fourthStatement.setVisible(false);

        } else if (getQuestionType() == 3) {
            firstStatement.setText("Correct Match-Ups: ");
            secondStatement.setText(getPa1() + "  ->  " + getAnswer1());
            thirdStatement.setText(getPa2() + "  ->  " + getAnswer2());
            fourthStatement.setText(getPa3() + "  ->  " + getAnswer3());
        }

    }

    /*
    If 5 questions have been done, goes to the ending screen. If not, adds the current
    question to the ArrayList of question IDs that have already been done, and then goes to the
    next question.
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
