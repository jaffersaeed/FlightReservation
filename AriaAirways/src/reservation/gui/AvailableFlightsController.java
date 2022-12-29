package  reservation.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import reservation.data.SQL;
import reservation.util.Booking;
import reservation.util.Check;
import reservation.util.Flight;

public class AvailableFlightsController {

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
	private TableColumn<Flight, String> capacityColumn;
	@FXML
	private TableColumn<Flight, String> remainingColumn;
	
	@FXML
	private Button add;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
    private Label error;
	
	static int count = 1;
	
	

	public ObservableList<Flight> getFlight() {
		ObservableList<Flight> List = FXCollections.observableArrayList(); 

	public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
    }
	
	public void add(ActionEvent event) throws IOException {
   	  Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
    }
	
	public void delete(ActionEvent event) throws IOException {
   	  Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
    }

	public ObservableList<Flight> getFlights(){
		ObservableList<Flight> flight= SQL.getFlight();
		return flight;
	}
	
		
	
}


