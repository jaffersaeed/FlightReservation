package  reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import reservation.data.SQL;
import reservation.util.Check;
import reservation.util.Booking;
import reservation.util.Flight;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class AdminBookFlightController implements Initializable {
	
	int[] flightQuery;
	static int count = 1;
	
	@FXML
	private TableView<Flight>table;
	@FXML
	private TableColumn<Flight, Integer> flightIdColumn;
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
    public ComboBox  origin;
    @FXML
    public ComboBox  destination;
    @FXML
    private Button view;
    @FXML
    private Button book;
    @FXML
    public DatePicker travelDate;
    @FXML
    public Label error;
    
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign5.jpg"));
    
     public void goBack(ActionEvent event) throws IOException {
					Main m = new Main();
					m.changeScene("AdminMainMenu.fxml");
    }
     public void viewFlights(ActionEvent event) throws IOException {
   
    	 
    	 table.setItems(SQL.getFlightDetails(origin.getSelectionModel().getSelectedItem().toString(),travelDate.getValue().format(DateTimeFormatter.ofPattern("MM-DD-YYYY")),destination.getSelectionModel().getSelectedItem().toString()));
    }
     
     public void book(ActionEvent event) throws IOException {
    	 try {
 			ObservableList<Flight> productSelected, allProducts;
 			allProducts = table.getItems();
 			productSelected = table.getSelectionModel().getSelectedItems();
 			Flight flight= (Flight)table.getSelectionModel().getSelectedItem();
 			
 			if (Check.bookingExists(flight.getDepartureDate(), LoginCustomerController.user.getUserName())) {
 				error.setText( "Reservation Already Exist");
 			} else {
 				flightQuery = SQL.getPassengerCount(flight.getFlightNumber());
 				if (flightQuery.length != 0 && flightQuery[0] == flightQuery[1]) {
 					error.setText("This Flight is Full!");
 				}else {
 					Booking booking = new Booking(  LoginCustomerController.user.getUserName(), 
 													flight.getDepartureDate(), 
 													count++,
 													flight.getFlightNumber());
 					SQL.updatePassengerCount(+flightQuery[1], flight.getFlightNumber());
 					 Main m = new Main();
 					 m.changeScene("Confirmation.fxml");
 					
 				}
 			}

 		} catch (Exception ex) {
 			error.setText("Invalid Input please enter correct inputs!");

 		}
	        
	     
    }

 	public void initialize(URL url, ResourceBundle rb ) {
 		ObservableList<String> list = FXCollections.observableArrayList("Atlanta","Boston","Chicago","Dallas-Fort Worth","Denver","Houston","Las Vegas","Los Angeles","Miami","New York","Pheonix","San Francisco","Seattle","Washington D.C");
 		origin.setItems(list);
 		ObservableList<String> list1 = FXCollections.observableArrayList("Atlanta","Boston","Chicago","Dallas-Fort Worth","Denver","Houston","Las Vegas","Los Angeles","Miami","New York","Pheonix","San Francisco","Seattle","Washington D.C");
 		destination.setItems(list1);
 		
 			flightIdColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightNumber"));
 			originCityColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureCity"));
 			departingCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
 			departingColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDate"));
 			capacityColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("capacity"));
 			remainingColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("passengerCount"));
 			
 			
 
 		
 	}
 	
 }
