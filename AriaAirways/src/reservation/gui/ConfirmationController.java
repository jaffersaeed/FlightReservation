package reservation.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ConfirmationController {

	@FXML
	private Button myflights;
	@FXML
	private Button mainmenu;
	
	ImageView myImageView;
   
    Image myImage = new Image(getClass().getResourceAsStream("GUI_LOGO.jpg"));
    Image myImage1 = new Image(getClass().getResourceAsStream("GUIdesign5.jpg"));
    
	public void MainMenu(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }
	public void myFlights(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("myFlights.fxml");
    }
}
