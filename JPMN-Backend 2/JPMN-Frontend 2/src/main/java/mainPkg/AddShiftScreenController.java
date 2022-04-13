package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddShiftScreenController extends GUI {
	
	@FXML
	private TextField staff_IDTextField;
	
	@FXML
	private TextField endTimeTextField;
	
	@FXML
	private TextField startTimeTextField;
	
	@FXML
	private TextField shiftIDTextField;
	
	@FXML
	private Label shiftRemovedMsg;
	
	@FXML
	private Label shiftAddedMsg;
	
	@FXML
	private Label displayAllShifts;
	
	@FXML
	void confirmRemove(ActionEvent event) {
		String shift_IDDeleteInput = shiftIDTextField.getText();
		ConnectionManager connectionManager = new ConnectionManager();
		connectionManager.sendDeleteRequest("deleteShiftByID?shift_ID="+ shift_IDDeleteInput);
		
		shiftRemovedMsg.setText("Shift with ID: " + shift_IDDeleteInput + " has been removed!");
	}
	
	@FXML
	void confirmInput(ActionEvent event) {
		
		String staff_IDInput = staff_IDTextField.getText().replace(" ", "WHITESPACEHEREX");
		String startTimeInput = startTimeTextField.getText().replace(" ", "WHITESPACEHEREX");
		String endTimeInput = endTimeTextField.getText().replace(" ", "WHITESPACEHEREX");
		
		ConnectionManager connectionManager = new ConnectionManager();
		connectionManager.sendRequest("addShift/?valuesAsCSV=" + "," + staff_IDInput + "," + startTimeInput + "," +  endTimeInput);
		
		shiftAddedMsg.setText("Shift has been added!");
	}
	
	@FXML
	void goToStaffScreen(ActionEvent event) {
		{try{launchStaffScene();} catch (IOException e) {e.printStackTrace();}}
	}
	
	@FXML
	void showAllShifts(ActionEvent event) {
		ConnectionManager connectionManager = new ConnectionManager();
		String answers = connectionManager.sendRequest("getAllShifts");
		
		String finalAnswers = answers.replace("'}," , "\n\n");
		
		displayAllShifts.setText(finalAnswers);
	}
	
}
