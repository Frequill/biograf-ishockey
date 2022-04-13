package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminScreenController extends GUI {
    
    @FXML
    private Label errorMessageAdmin;
    
    @FXML
    private Label displayAllSaloons;
    
    @FXML
    private TextField saloonNameTextField;
    
    @FXML
    private TextField saloonSeatsTextField;
    
    @FXML
    private TextField saloon_idTextField;
    
    @FXML
    private Label saloonRemovedMsg;
    
    @FXML
    void addMovie(ActionEvent event) throws IOException {
        launchMovieScene();
    }

    @FXML
    void addSaloon(ActionEvent event) {
        String saloonNameInput = saloonNameTextField.getText();
        String seatsInput = saloonSeatsTextField.getText();
    
        ConnectionManager connectionManager = new ConnectionManager();
        String answer = connectionManager.sendRequest("addSaloon/?valuesAsCSV=" + "," + saloonNameInput + "," + seatsInput);
    
        errorMessageAdmin.setText("Saloon: " + saloonNameInput + " has been added!");
    }

    @FXML
    void deleteSaloon(ActionEvent event) {
        String saloon_IDInput = saloon_idTextField.getText();
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.sendDeleteRequest("deleteSaloonByID?saloon_ID="+ saloon_IDInput);
        
        saloonRemovedMsg.setText("Saloon with ID: " + saloon_IDInput + " has been removed!");
    }

    @FXML
    void goToStaffScreen(ActionEvent event) {
        try {
            launchStaffScene();}catch (IOException e) {e.printStackTrace();}
    }

    @FXML
    void goToStartScreen(ActionEvent event) {
        try {goToStartScene();} catch (IOException e) {e.printStackTrace();}
    }
    
    @FXML
    void getAllSaloons(ActionEvent event) {
        ConnectionManager connectionManager = new ConnectionManager();
        String answers = connectionManager.sendRequest("getAllSaloons");
        displayAllSaloons.setText(answers);
    }

}
