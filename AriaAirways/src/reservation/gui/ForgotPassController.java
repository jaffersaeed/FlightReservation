package  reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import reservation.util.Check;
import reservation.data.SQL;

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
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign2.jpg"));
    
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