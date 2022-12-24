package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginCustController{


    @FXML
    private Button login_bttn;
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
    private Label error;


    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
    
    public void forgotPass(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("forgotPassword.fxml");
    }
    
    public void adminLogin(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("Adminlogin.fxml");
    }
    
    public void LoginButtonClicked(ActionEvent event) throws IOException {
    	if(username.getText().toString().equals("yes")&&password.getText().toString().equals("yes"))
        {
    	 Main m = new Main();
    	 m.changeScene("WelcomePage.fxml");
        }
    else
       {
            error.setText("Wrong Username or Password, please try again!");;
        }
    }
}
        



    
