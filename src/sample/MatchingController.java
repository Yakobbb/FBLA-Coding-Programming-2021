package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatchingController extends QuestionLoader {

    @FXML private Label leftColumn1;
    @FXML private Label leftColumn2;
    @FXML private Label leftColumn3;
    @FXML private Label rightColumn1;
    @FXML private Label rightColumn2;
    @FXML private Label rightColumn3;
    @FXML private ProgressBar progressBar;
    @FXML private Label questionText;

    /*
    Initialize .fxml objects with the data from the questionLoader class
     */
    public void initialize() {

        questionText.setText(getQuestion());

        Label[] arrayOfLeftColumn = {leftColumn1, leftColumn2, leftColumn3};
        List<Label> listOfLeftColumn = Arrays.asList(arrayOfLeftColumn);
        Collections.shuffle(listOfLeftColumn);

        listOfLeftColumn.get(0).setText(getPa1());
        listOfLeftColumn.get(1).setText(getPa2());
        listOfLeftColumn.get(2).setText(getPa3());

        rightColumn1.setText(getAnswer1());
        rightColumn2.setText(getAnswer2());
        rightColumn3.setText(getAnswer3());

        int progress = getProgress();
        progressBar.setProgress((double) progress / 5);
        setProgress(progress + 1);
    }

    /*
    The following functions implement the JavaFX dragging mechanism. Many of these methods are
    repetitive, but necessary since each unique .fxml object has its own unique ID. This was
    easily the most difficult functionality to implement, so more in-depth comments have been
    provided for understanding (some may reference the specific JavaFx documentation for drag
    and drop).
     */


    @FXML
    public void handleDragDetection1(MouseEvent event) {

        /* Drag detected, start a drag-and-drop gesture */
        Dragboard db = leftColumn1.startDragAndDrop(TransferMode.ANY);

        /* Put string of the source on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(leftColumn1.getText());
        db.setContent(content);

        /* End event */
        event.consume();
    }

    @FXML
    public void handleDragDetection2(MouseEvent event) {
        Dragboard db = leftColumn2.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString(leftColumn2.getText());
        db.setContent(content);

        event.consume();
    }

    @FXML
    public void handleDragDetection3(MouseEvent event) {
        Dragboard db = leftColumn3.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString(leftColumn3.getText());
        db.setContent(content);

        event.consume();
    }

    @FXML
    public void handleDragOver(DragEvent event) {

        /* Data is dragged over the target */
        /* Accept it only if it is not dragged from the same node and if it has a string */

        if (event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }

    @FXML
    public void handleDragEntered1(DragEvent event) {

        /* The gesture entered the target */
        /* Show to the user that it is an actual possible gesture target */

        if (event.getDragboard().hasString()) {
            rightColumn1.setTextFill(Paint.valueOf("white"));
        }

        event.consume();
    }

    @FXML
    public void handleDragEntered2(DragEvent event) {
        if (event.getDragboard().hasString()) {
            rightColumn2.setTextFill(Paint.valueOf("white"));
        }

        event.consume();
    }

    @FXML
    public void handleDragEntered3(DragEvent event) {
        if (event.getDragboard().hasString()) {
            rightColumn3.setTextFill(Paint.valueOf("white"));
        }

        event.consume();
    }

    @FXML
    public void handleDragExited1(DragEvent event) {

        /*
        Mouse moved away, remove the graphical cues (in this case for rightColumn1)
        */

        rightColumn1.setTextFill(Paint.valueOf("black"));
        event.consume();
    }

    @FXML
    public void handleDragExited2(DragEvent event) {
        rightColumn2.setTextFill(Paint.valueOf("black"));
        event.consume();
    }

    @FXML
    public void handleDragExited3(DragEvent event) {
        rightColumn3.setTextFill(Paint.valueOf("black"));
        event.consume();
    }

    @FXML
    public void handleDragDropped1(DragEvent event) throws IOException {
        /* Data is dropped */
        /* Read and use the string that was on the source */

        Dragboard db = event.getDragboard();
        boolean success = false;

        /*
        In this case, if the data in rightColumn1 (or in other words, answer_1 from the database) matches
        the data that came from the source that's being dragged (or in other words, if it's pa_1 from the database),
        then hide the rightColumn1 object by setting its String to "", and by setting its border as a
        standard, transparent border.
         */
        if (db.getString().equals(getPa1())) {

            rightColumn1.setText("");;
            rightColumn1.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
            success = true;

            /*
            Checks if all the right columns are clear, which means the user matched everything correctly
             */

            if (rightColumn1.getText().equals("") && rightColumn2.getText().equals("")
                    && rightColumn3.getText().equals("")) {

                loadCorrect();
            }

        } else {
            loadIncorrect();
        }

        /* let the source know whether the string was successfully transferred and used */
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    public void handleDragDropped2(DragEvent event) throws IOException {
        /*
        Same as above, but for rightColumn2
         */
        Dragboard db = event.getDragboard();
        boolean success = false;

        if (db.getString().equals(getPa2())) {

            rightColumn2.setText("");
            rightColumn2.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
            success = true;

            if (rightColumn1.getText().equals("") && rightColumn2.getText().equals("")
                    && rightColumn3.getText().equals("")) {

                loadCorrect();
            }

        } else {
            loadIncorrect();
        }

        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    public void handleDragDropped3(DragEvent event) throws IOException {
        /*
        Same as above, but for rightColumn3
         */
        Dragboard db = event.getDragboard();
        boolean success = false;

        if (db.getString().equals(getPa3())) {

            rightColumn3.setText("");
            rightColumn3.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
            success = true;

            if (rightColumn1.getText().equals("") && rightColumn2.getText().equals("")
                    && rightColumn3.getText().equals("")) {

                loadCorrect();
            }

        } else {
            loadIncorrect();
        }
        /* let the source know whether the string was successfully
         * transferred and used */
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    public void handleDragDone1(DragEvent event) {

        /*
        Drag and drop data was successfully transferred, meaning that in this case,
        since the user matched two nodes correctly, leftColumn1 would
        become cleared just like the right columns in the previous 3 functions
         */

        if (event.getTransferMode() == TransferMode.MOVE) {
            leftColumn1.setText("");
            leftColumn1.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
        }
        event.consume();
    }

    @FXML
    public void handleDragDone2(DragEvent event) {

        /*
        Same, but for leftColumn2
         */

        if (event.getTransferMode() == TransferMode.MOVE) {
            leftColumn2.setText("");
            leftColumn2.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
        }
        event.consume();
    }

    @FXML
    public void handleDragDone3(DragEvent event) {

        /*
        Same, but for leftColumn3
         */

        if (event.getTransferMode() == TransferMode.MOVE) {
            leftColumn3.setText("");
            leftColumn3.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.DASHED,
                    CornerRadii.EMPTY, BorderStroke.DEFAULT_WIDTHS)));
        }
        event.consume();
    }

}
