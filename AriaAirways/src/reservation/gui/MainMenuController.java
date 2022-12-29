package  reservation.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainMenuController {

	@FXML
    private Button logout;
    @FXML
    private Button bookflights;
    @FXML
    private Button flights;
    @FXML
    private Button myFlights;
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign4.jpg"));  
    Image myImage1 = new Image(getClass().getResourceAsStream("GUI_LOGO.jpg"));
    
    public void logout(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
    public void bookFlight(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("BookFlights.fxml");
    }
    public void availableFlights(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("AvailableFlights.fxml");
    }
    public void myFlight(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("AvailableFlights.fxml");
}
}
