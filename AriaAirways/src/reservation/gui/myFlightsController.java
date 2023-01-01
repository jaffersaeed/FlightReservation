package  reservation.gui;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


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
		
             ObservableList<Booking> productSelected, allProducts;
             allProducts = table.getItems();
             productSelected = table.getSelectionModel().getSelectedItems();
             Booking booking =(Booking) table.getSelectionModel().getSelectedItem();
             SQL.deleteBooking(booking.getBookingNumber());
             productSelected.forEach(allProducts::remove);
 
             Main m = new Main();
 	        m.changeScene("myFlights.fxml");

	}
   	  

	public void initialize(URL url, ResourceBundle rb ) {
			bookingIdColumn.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("bookingNumber"));
			dateCreatedColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("dateCreated"));
			flightIdColumn.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("flightNumber"));
			departingColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("departureDate"));

			
			table.setItems(SQL.getBookings(LoginCustomerController.user.getUserName()));
		
	}
}