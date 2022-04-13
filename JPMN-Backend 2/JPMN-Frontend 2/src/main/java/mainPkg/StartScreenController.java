package mainPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StartScreenController extends GUI {
    
    @FXML
    private TextField passwordTextField;
    
    @FXML
    private PasswordField secretPasswordTextField;
    
    
    //Action-listeners for the "start screen", the first GUI the user sees upon boot-up...

    @FXML
    void quitProgram(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void showAdminScene(ActionEvent event) {
        //String passwordInput = passwordTextField.getText();
        String passwordInput = secretPasswordTextField.getText();
        String password = "ishockey";
    
        if (passwordInput.equals(password)) {
            try {
                launchAdminScene();
            } catch (IOException e) {
                e.printStackTrace();
            } // Try-Catch required to use JAVAFX scene-switch
        }
    }
    @FXML
    void showCustomerScene(ActionEvent event) throws IOException {
        launchCustomerScene();
    }
    
    @FXML
    void testConnection(ActionEvent event) {
        ConnectionManager connectionManager = new ConnectionManager();
        String answer = connectionManager.sendRequest("hello/?name="+ "works!!!");
        System.out.println(answer);
    }
}