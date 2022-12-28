package  reservation.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class WelcomePageController {

    @FXML
    private Button Login;
   @FXML
   private Button Register;
   @FXML
   private ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUI_LOGO.jpg"));

 public void userlogin(ActionEvent event) throws IOException {
	        Main m = new Main();
	        m.changeScene("loginCustomer.fxml");
	    }

	    public void userregister(ActionEvent event) throws IOException {
	    	Main m = new Main();
		    m.changeScene("register.fxml");
	    }
	}
