package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AdminLoginController {

	
    @FXML
    private Button wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button back;
    @FXML
    private Button login;
    @FXML
    private Button forgotPass;


    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
    
    public void ForgotPass(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("forgotPassword.fxml");
    }
    
    public void adminLogin(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }
}
