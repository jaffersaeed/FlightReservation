package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

	@FXML
    private Button logout;
    @FXML
    private Button bookflights;
    @FXML
    private Button flights;
    @FXML
    private Button myFlights;
    
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
	        m.changeScene("WelcomePage.fxml");
    }
   
}
