package reservation.gui;

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
import reservation.util.Admin;
import reservation.util.Check;
import reservation.util.Customer;
import reservation.util.Menu;
import javafx.event.ActionEvent;
import reservation.util.User;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AdminLoginController {

	
    @FXML
    private Button wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button back;
    @FXML
    private Button login;
    @FXML
    private Button forgotPass;
    @FXML
    private Label error;
    
    static User user;
    
     ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign1.jpg"));


    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
    
    public void ForgotPass(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("forgotPassword.fxml");
    }
    
 public void adminLogin(ActionEvent event) throws IOException {
    	
				try {
				if (Check.isValidUser(username.getText(), password.getText())) {
						user = Menu.login(username.getText(), password.getText());
					}
				
					// check if user is an admin
					if (Check.isValidUser(username.getText(),password.getText()) 
							&& (user instanceof Admin)) {
						Main m = new Main();
						m.changeScene("AdminMainMenu.fxml");
					}
					else if (Check.isValidUser(username.getText(),password.getText()) 
						&& (user instanceof Customer)) {
					error.setText("Please go to Customer Login");
			}else {
				error.setText("Invalid Username or Password");
			}
			
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
    
    }

