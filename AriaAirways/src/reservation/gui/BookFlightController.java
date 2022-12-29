package  reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import reservation.data.SQL;
import reservation.util.Flight;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class BookFlightController implements Initializable {
	
	@FXML
	private TableView<Flight>table;
	@FXML
	private TableColumn<Flight, String> flightIdColumn;
	@FXML
	private TableColumn<Flight, String> originCityColumn;
	@FXML
	private TableColumn<Flight, String> departingCity;
	@FXML
	private TableColumn<Flight, String> departingColumn; 
	@FXML
	private TableColumn<Flight, Integer> capacityColumn;
	@FXML
	private TableColumn<Flight, Integer> remainingColumn;
	
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
     public void viewFlights(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }

 	public void initialize(URL url, ResourceBundle rb ) {
 			flightIdColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
 			originCityColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureCity"));
 			departingCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
 			departingColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDate"));
 			capacityColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("capacity"));
 			remainingColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("passengerCount"));
 			
 			table.setItems(SQL.getFlight());
 		
 	}
 }