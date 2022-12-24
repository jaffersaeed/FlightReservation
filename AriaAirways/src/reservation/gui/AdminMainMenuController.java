package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminMainMenuController {

	@FXML
    private Button logout;
    @FXML
    private Button bookflights;
    @FXML
    private Button manage;
    
    public void logout(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
    public void availableFlights(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("AvailableFlights.fxml");
    }
    public void manageFlights(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("ManageFlights.fxml");
    }
   

}
