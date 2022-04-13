package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.IOException;

public class AllMovieScreeningsScreenController extends GUI {

    @FXML
    private TextArea allScreeningsTextArea;

    @FXML
    private TextField movieIDToBeDeleted;

    @FXML
    void goToAddMovieScreen(ActionEvent event) throws IOException {
        launchMovieScene();
    }

    @FXML
    void deleteMovieByID(ActionEvent event) {
        String movie_ID = movieIDToBeDeleted.getText();
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.sendDeleteRequest("deleteScreeningById?movie_ID="+ movie_ID);

        allScreeningsTextArea.setFont(new Font("System", 30));
        allScreeningsTextArea.setText("Screening " + movie_ID + " has been successfully deleted!");
    }

    @FXML
    void refreshAllScreenings(ActionEvent event) {
        ConnectionManager connectionManager = new ConnectionManager();
        String allScreenings = connectionManager.sendRequest("getAllScreenings");

        String firstAllScreenings = allScreenings.replace("},", "}\n\n");
        String secondScreenings = firstAllScreenings.replace("[", " ");
        String thirdScreenings = secondScreenings.replace("]", "");
        String finalScreenings = thirdScreenings.replace("saloon", "\nsaloon");

        allScreeningsTextArea.setFont(new Font("System", 12));
        allScreeningsTextArea.setText(finalScreenings);
    }
}
