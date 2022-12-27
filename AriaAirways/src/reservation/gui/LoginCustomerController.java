package reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginCustomerController{


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
    private Button adminlogin_bttn;
    @FXML
    private Label error;


    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
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
        



    
