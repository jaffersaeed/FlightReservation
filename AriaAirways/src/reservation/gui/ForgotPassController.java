package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class ForgotPassController {
    @FXML
    private Button back;
    @FXML
    private Button changePassword_bttn;
    @FXML
    private TextField UsernameForgotpass;
    @FXML
    private Label Error;
    
    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("loginCustomer.fxml");
    }
    
    public void changePass(ActionEvent event) throws IOException {
    	if(Check.usernameExists(UsernameForgotPass.getText())) {
    	 Main m = new Main();
    	 m.changeScene("ForgotPassword2.fxml");
        }
    else
       {
            Error.setText("Username Doesn't Exist");;
        }
}
}
