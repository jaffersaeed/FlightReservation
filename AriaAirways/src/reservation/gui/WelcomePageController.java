package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private Button Login;
   @FXML
private Button Register;

 public void userlogin(ActionEvent event) throws IOException {
	        Main m = new Main();
	        m.changeScene("loginCustomer.fxml");
	    }

	    public void userregister(ActionEvent event) throws IOException {
	    	Main m = new Main();
		    m.changeScene("register.fxml");
	    }
	}
