package reservation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgotPass2Controller {

	@FXML
	private TextField newPassword;
	@FXML
	private Button back;
	@FXML
	private Button submit;
	Imageview myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign2.jpg"));
	
	 public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("forgotPassword.fxml");
    }
	  public void submitNewPass(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("loginCustomer.fxml");
    }
}
