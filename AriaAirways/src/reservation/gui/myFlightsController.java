package  reservation.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import reservation.gui.LoginCustomerController;

public class myFlightsController implements Initializable{
	

	@FXML
	private TableView<Booking>table;
	@FXML
	private TableColumn<Booking, Integer> bookingIdColumn;
	@FXML
	private TableColumn<Booking, String> dateCreatedColumn;
	@FXML
	private TableColumn<Booking, Integer> flightIdColumn;
	@FXML
	private TableColumn<Booking, String> departingColumn; 
	@FXML
	private TableColumn<Booking, Integer> ticketIdColumn;
	
	@FXML
	private Button add;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
    private Label error;
	
	static int count = 1;
	
	

	/*public ObservableList<Flight> getFlight() {
		ObservableList<Flight> List = FXCollections.observableArrayList(); 
	}*/
	public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }
	
	public void add(ActionEvent event) throws IOException {
   	  Main m = new Main();
	        m.changeScene("BookFlights.fxml");
    }
	
	public void delete(ActionEvent event) throws IOException {
   	  Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
    }

/*	public ObservableList<Flight> getFlights(){
		ObservableList<Flight> flight= SQL.getFlight();
		return flight;
	}*/


	public void initialize(URL url, ResourceBundle rb ) {
			bookingIdColumn.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingNumber"));
			dateCreatedColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("dateCreated"));
			flightIdColumn.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("flightNumber"));
			departingColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("departureDate"));
			ticketIdColumn.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("ticketNumber"));

			
			table.setItems(SQL.getBookings(LoginCustomerController.user.getUserName()));
		
	}
}