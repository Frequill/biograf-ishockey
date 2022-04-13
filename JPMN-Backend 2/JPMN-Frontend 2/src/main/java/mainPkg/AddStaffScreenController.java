package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddStaffScreenController extends GUI {
	
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField salaryTextField;
	
	@FXML
	private TextField salt1TextField;
	
	@FXML
	private TextField email_addressTextField;
	
	@FXML
	private TextField salt2TextField;
	
	@FXML
	void confirmInput(ActionEvent event) {
		String nameInput = nameTextField.getText();
		String salaryInput = salaryTextField.getText();
		String salt1Input = salt1TextField.getText();
		String email_addressInput = email_addressTextField.getText();
		String salt2Input = salt2TextField.getText();
		
		//ConnectionManager connectionManager = new ConnectionManager();
		//String request = connectionManager.sendRequest("addStaff/?CompletedStatement=");
		
		ConnectionManager connectionManager = new ConnectionManager();
		String answer = connectionManager.sendRequest("addStaff/?valuesAsCSV=" + "," + nameInput + "," + salaryInput + ","+  salt1Input + "," + email_addressInput + "," + salt2Input);
		System.out.println(answer); //?!
	}
	
	@FXML
	void goToStaffScreen(ActionEvent event)
	{try{launchStaffScene();} catch (IOException e) {e.printStackTrace();}}
}
