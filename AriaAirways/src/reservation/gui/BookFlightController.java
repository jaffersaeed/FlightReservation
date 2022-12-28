package  reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class BookFlightController implements Initializable {
	
    @FXML
    private Button back;
    @FXML
    private ComboBox  origin;
    @FXML
    private ComboBox  destination;
    @FXML
    private Button view;
    @FXML
    private CheckBox oneway;
    @FXML
    private CheckBox roundTrip;
    @FXML
    private DatePicker travelDate;
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign5.jpg"));
    
     public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }
     
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> list = FXCollections.observableArrayList("Atlanta","Boston","Chicago","Dallas-Fort Worth","Denver","Houston","Las Vegas","Los Angeles","Miami","New York","Pheonix","San Francisico","Seattle","Washington");
         origin.setItems(list);
         ObservableList<String> list2 = FXCollections.observableArrayList("Atlanta","Boston","Chicago","Dallas-Fort Worth","Denver","Houston","Las Vegas","Los Angeles","Miami","New York","Pheonix","San Francisico","Seattle","Washington");
         destination.setItems(list);
    }  
     public void viewFlights(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }
}
