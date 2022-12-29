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
/* public void addButtonClicked() {
		try {
			ObservableList<Flight> productSelected, allProducts;
			allProducts = table.getItems();
			productSelected = table.getSelectionModel().getSelectedItems();
			Flight flight=(Flight)table.getSelectionModel().getSelectedItem();
			
			if (Check.bookingExists(flight.getDepartureDate(), Login.user.getUserName())) {
				error.setText("Booking already exists");
			} else {
				flightQuery = SQL.getPassengerCount(flight.getflightNumber());
				if (flightQuery.length != 0 && flightQuery[0] == flightQuery[1]) {
					error.setText("Flight is full.");
				}else {
					Booking booking = new Booking(Login.user.getUserName(), flight.getFlightNumber(),
							flight.getDepartureDate(), count++);
					SQL.updatePassengerCount(++flightQuery[1], flight.getFlightNumber());
					 Main m = new Main();
					 m.changeScene("AdminMainMenu.fxml");
				}
			}

		} catch (Exception ex) {
			error.setText("Invalid Input");

		}
	}
	
	public void delete(ActionEvent event) throws IOException {
    	 deleteButtonClicked();
    }
		public void deleteButtonClicked() {
		try {
			ObservableList<Booking> productSelected, allProducts;
			allProducts = booking.getItems();
			productSelected = booking.getSelectionModel().getSelectedItems();
			Booking book =(Booking)booking.getSelectionModel().getSelectedItem();
			SQL.deleteBooking(book.getBookingNumber());
			productSelected.forEach(allProducts::remove);
			flightQuery = SQL.getPassengerCount(res.getFlightNumber());
			if (flightQuery.length != 0) {
				SQL.updatePassengerCount(--flightQuery[1], book.getflightNumber());
				BookFlight updateBook=new BookFlight();
				Main m = new Main();
				m.changeScene("AdminMainMenu.fxml");
			}
			
		} catch (NoSuchElementException ex) {
			error.setText("All bookings have been removed");
		}catch(Exception ex) {
			error.setText("You haven't made a selection");

		}
	}