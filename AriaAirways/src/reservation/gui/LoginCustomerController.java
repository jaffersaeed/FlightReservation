package reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import reservation.util.Admin;
import reservation.util.Check;
import reservation.util.Customer;
import reservation.util.Menu;
import javafx.event.ActionEvent;
import reservation.util.User;

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
    
    static User user;


    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
    
    public void LoginButtonClicked(ActionEvent event) throws IOException {
    	
    	try {
				if (Check.isValidUser(username.getText(), password.getText())) {
					
						user = Menu.login(username.getText(), password.getText());
					}
					
					//Create a string to receive response from user's actions
	//				String response = "";
					
					// check if user is an admin
					if (Check.isValidUser(username.getText(),password.getText()) 
							&& (user instanceof Admin)) {
						Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
					}
					else if (Check.isValidUser(username.getText(),password.getText()) 
						&& (user instanceof Customer)) {
					Main m = new Main();
					m.changeScene("MainMenu.fxml");
			}else {
				error.setText("Wrong Username or Password, please try again!");
			}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
    
    }

        



    
