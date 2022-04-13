package mainPkg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StaffScreenController extends GUI{
    
    @FXML
    private TextField IdInputField;
    
    @FXML
    private TextField deleteField;
    
    @FXML
    private Label staffPrintOutLabel;
    
    @FXML
    private Label displayAllStaff;
    
    @FXML
    void addShift(ActionEvent event) throws IOException {
        try{launchAddShiftScene();} catch (IOException e) {e.printStackTrace();}
    }
    
    @FXML
    void addStaff(ActionEvent event) throws IOException {
        //try {launchAddStaffScene();} catch (IOException e) {e.printStackTrace();}
        launchAddStaffScene();
    }
    
    @FXML
    void deleteStaffById(ActionEvent event) {
        String usersId = deleteField.getText();
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.sendDeleteRequest("deleteStaffById?s_ID="+ usersId);
    }
  
    @FXML
    void getAllStaff(ActionEvent event) {
        
        ConnectionManager connectionManager = new ConnectionManager();
        String answers = connectionManager.sendRequest("getAllStaff");
        displayAllStaff.setText(answers);
    }
    
    @FXML
    void getStaffById(ActionEvent event) {
        String usersId = IdInputField.getText();
        ConnectionManager connectionManager = new ConnectionManager();
        String answer = connectionManager.sendRequest("getStaffByID/?staff_ID="+ usersId);
        //System.out.println("TESTTTTTT\n" + answer);
        staffPrintOutLabel.setText(answer);
    }
    
    @FXML
    void goToAdminscreen(ActionEvent event) {
        try {launchAdminScene();} catch (IOException e) {e.printStackTrace();}
    }
    
}
