package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

/*
This class is the MOAB of this program. It is responsible for generating questions, initializing tons of
variables that certain controller classes will need to reference, as well as keeping track of all of the
data (ie. questions, question types, whether the user got a question right or wrong, etc.).
 */

public class QuestionLoader {

    /*
    Initialize/declare variables that will be referenced further down, or in the controller classes
     */
    private final Stage window = Main.getWindow();
    private static int questionID;
    private static String question;
    private static int questionType;
    private static String pa1;
    private static String pa2;
    private static String pa3;
    private static String answer1;
    private static String answer2;
    private static String answer3;
    private static int progress = 0;
    private static ArrayList<Integer> questionIDsAlreadyDone = new ArrayList<>();
    private static int totalCorrect = 0;
    private static String category;
    private static ArrayList<ArrayList<String>> questionsAlreadyDone = new ArrayList<ArrayList<String>>();
    private static ArrayList<Boolean> rightOrWrong = new ArrayList<>();

    /*
    Getters and setters (as well as a couple other simple functions that are needed)
     */
    public static ArrayList<Integer> getQuestionIDsAlreadyDone() { return questionIDsAlreadyDone; }
    public static ArrayList<ArrayList<String>> getQuestionsAlreadyDone() { return questionsAlreadyDone; }
    public static void addToRightOrWrong(boolean element) { rightOrWrong.add(element); }
    public static void addToQuestionIDsAlreadyDone(int element) { questionIDsAlreadyDone.add(element); }
    public static void clearQuestionsAlreadyDone() {questionsAlreadyDone.clear();}
    public static void clearQuestionIDsAlreadyDone() { questionIDsAlreadyDone.clear(); }
    public static void clearRightOrWrong() { rightOrWrong.clear(); }
    public static int getQuestionID() { return questionID; }
    public static String getQuestion() { return question; }
    public static int getQuestionType() { return questionType; }
    public static String getPa1() { return pa1; }
    public static String getPa2() { return pa2; }
    public static String getPa3() { return pa3; }
    public static String getAnswer1() { return answer1; }
    public static String getAnswer2() { return answer2; }
    public static String getAnswer3() { return answer3; }
    public static int getProgress() { return progress; }
    public static void setProgress(int progress) { QuestionLoader.progress = progress; }
    public static void setTotalCorrect(int totalCorrect) { QuestionLoader.totalCorrect = totalCorrect; }
    public static int getTotalCorrect() { return totalCorrect; }
    public static void setCategory(String category) { QuestionLoader.category = category; }
    public static ArrayList<Boolean> getRightOrWrong() { return rightOrWrong; }


    /*
    This function accesses the PostgreSQL server on my PC (since I didn't put it onto a public web server),
    and retrieves a random question based on the category that the user chose. It then takes all the question-
    specific data from the server and assigns it to variables for use.
     */
    public void generateQuestion(String category) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/fbla_quiz";
        String username = "postgres";
        String password = "rcg;p\\(BQC_!878.";

        Random random = new Random();
        int questionNum = random.nextInt(20);

        /*
        Chooses random question based on category (1-20 Events, 21-40 ByLaws, 41-60 Random, 1-60 Everything)
         */
        switch (category) {
            case "Events" -> questionNum += 1;
            case "ByLaws" -> questionNum += 21;
            case "Random" -> questionNum += 41;
            case "Everything" -> questionNum = random.nextInt(60) + 1;
        }

        String sqlCommand = "SELECT * FROM questions WHERE question_id=" + Integer.toString(questionNum);

        Connection connection = DriverManager.getConnection(url, username, password);

        /*
        Connects to database and executes SQL statement above
         */
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCommand);

        /*
        While statement looks at the resultSet from the above SQL statement, and assigns the data
        to variables (and assigns a few more than normal if the question type is Matching, since
        all the possible answers and correct answers are needed
         */
        while (resultSet.next()) {
            questionID = resultSet.getInt("question_id");

            /*
             Makes sure no questions are repeated in quiz
             */
            if (questionIDsAlreadyDone.contains(questionID)) {
                generateQuestion(category);
                break;
            }

            question = resultSet.getString("question");
            questionType = resultSet.getInt("question_type");
            pa1 = resultSet.getString("pa_1");
            pa2 = resultSet.getString("pa_2");
            pa3 = resultSet.getString("pa_3");
            answer1 = resultSet.getString("answer_1");
            answer2 = resultSet.getString("answer_2");
            answer3 = resultSet.getString("answer_3");

            ArrayList<String> questionInfo = new ArrayList<>();
            questionInfo.add(Integer.toString(questionType));
            questionInfo.add(question);
            questionInfo.add(answer1);

            if (questionType == 3) {
                questionInfo.add(pa1);
                questionInfo.add(pa2);
                questionInfo.add(pa3);
                questionInfo.add(answer2);
                questionInfo.add(answer3);
            }

            questionsAlreadyDone.add(questionInfo);
        }

        connection.close();

    }

    /*
    Depending on the question type, the corresponding question scene is loaded
     */
    public void goToQuestion() throws IOException, SQLException {

        generateQuestion(category);
        int questionType = getQuestionType();

        if (questionType == 1) {

            Parent multipleChoiceRoot = FXMLLoader.load(getClass().getResource("MultipleChoice.fxml"));
            Scene multipleChoice = new Scene(multipleChoiceRoot);
            multipleChoice.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            window.setScene(multipleChoice);

        } else if (questionType == 2) {

            Parent trueFalseRoot = FXMLLoader.load(getClass().getResource("TrueFalse.fxml"));
            Scene trueFalse = new Scene(trueFalseRoot);
            trueFalse.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            window.setScene(trueFalse);

        } else if (questionType == 3) {

            Parent matchingRoot = FXMLLoader.load(getClass().getResource("Matching.fxml"));
            Scene matching = new Scene(matchingRoot);
            matching.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            window.setScene(matching);

        } else if (questionType == 4) {

            Parent fillInRoot = FXMLLoader.load(getClass().getResource("FillIn.fxml"));
            Scene fillIn = new Scene(fillInRoot);
            fillIn.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            window.setScene(fillIn);

        }

    }

    /*
    Loads the correct scene
     */
    public void loadCorrect() throws IOException {

        Parent correctRoot = FXMLLoader.load(getClass().getResource("Correct.fxml"));
        Scene correct = new Scene(correctRoot);
        correct.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        window.setScene(correct);

    }

    /*
    Loads the incorrect scene
     */
    public void loadIncorrect() throws IOException {

        Parent incorrectRoot = FXMLLoader.load(getClass().getResource("Incorrect.fxml"));
        Scene incorrect = new Scene(incorrectRoot);
        incorrect.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        window.setScene(incorrect);

    }

    /*
    Loads the ending screen
     */
    public void loadEnd() throws IOException {

        Parent endRoot = FXMLLoader.load(getClass().getResource("End.fxml"));
        Scene end = new Scene(endRoot);
        end.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        window.setScene(end);

    }
}
