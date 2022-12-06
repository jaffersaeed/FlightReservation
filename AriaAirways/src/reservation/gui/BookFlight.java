package reservation.gui;

import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import reservation.data.SQL;
import reservation.util.Admin;
import reservation.util.Flight;
import reservation.util.Check;
import reservation.util.Customer;
import reservation.util.Booking;

public class BookFlight extends Application {

	Stage window;
	TableView<Flight> table;
	TableView<Booking> reservation;
	static int count = 1;
	Scene scene;
	int[] busQuery;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Flight Reservation App");
		TableColumn<Flight, Integer> busIdColumn = new TableColumn<>("Flight Id");
		busIdColumn.setMinWidth(100);
		busIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

		// Departure City column
		TableColumn<Flight, String> originCityColumn = new TableColumn<>("Origin City");
		originCityColumn.setMinWidth(150);
		originCityColumn.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

		// Destination City column
		TableColumn<Flight, String> departingCity = new TableColumn<>("Destination City");
		departingCity.setMinWidth(150);
		departingCity.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		// Departure Time column
		TableColumn<Flight, String> departureColumn = new TableColumn<>("Departure Time");
		departureColumn.setMinWidth(150);
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		// Capacity City column
		TableColumn<Flight, Integer> capcityColumn = new TableColumn<>("Capacity");
		capcityColumn.setMinWidth(150);
		capcityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		// Seats Available Time column
		TableColumn<Flight, String> remainingColumn = new TableColumn<>("Passanger Count");
		remainingColumn.setMinWidth(150);
		remainingColumn.setCellValueFactory(new PropertyValueFactory<>("passengerCount"));

		// Reservation Number column
		TableColumn<Booking, Integer> reservationNumber = new TableColumn<>("Booking ID");
		reservationNumber.setMinWidth(200);
		reservationNumber.setCellValueFactory(new PropertyValueFactory<>("bookingNumber"));

		// Date Created column
		TableColumn<Booking, String> dateCreated = new TableColumn<>("Date Created");
		dateCreated.setMinWidth(150);
		dateCreated.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));

		// Bus Number column
		TableColumn<Booking, Integer> busNumber = new TableColumn<>("Flight Number");
		busNumber.setMinWidth(100);
		busNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		// Departure Date column
		TableColumn<Booking, String> departureDate = new TableColumn<>("Departure Date");
		departureDate.setMinWidth(150);
		departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		// Ticket Number column
		TableColumn<Booking, Integer> ticketNumber = new TableColumn<>("Ticket Number");
		ticketNumber.setMinWidth(150);
		ticketNumber.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
		reservation = new TableView<Booking>();
		
		// Add Button
		Button bookButton = new Button("Book");
		bookButton.setOnAction(e -> {
			addButtonClicked();
			
		});
		// Delete Button
		Button delete = new Button("Remove Booking");
		delete.setOnAction(e -> {
			deleteButtonClicked();
		});

		// Back Button to return to Admin main page
		Button back = new Button("Back");
		back.setOnAction(e -> {
			Main a = new Main();
			try {
				if(Login.user instanceof Admin) {
					Admin admin=new Admin();
					admin.start(window);
				}else {
					a.start(window);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		HBox hBox = new HBox();
		Label book = new Label("Book a Flight");
		Label space = new Label("   ");
		hBox.getChildren().addAll(book, space, bookButton);
		hBox.setAlignment(Pos.BASELINE_RIGHT);
		table = new TableView<>();

		table.getColumns().addAll(flightIdColumn, originCityColumn, departureColumn, departingCity, capcityColumn,
				remainingColumn);
		table.setItems(getFlight());
		Booking.getColumns().addAll(bookingNumber, dateCreated, flightNumber, departureDate,
				ticketNumber);
		Booking.setItems(SQL.getBooking(Login.user.getUserName()));
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		VBox yu = new VBox();
		HBox hBack = new HBox();
		hBack.getChildren().addAll(delete, back);
		hBack.setAlignment(Pos.BASELINE_RIGHT);

		yu.getChildren().addAll(booking, hBack);
		BorderPane lay = new BorderPane();
		lay.setCenter(yu);
		lay.setTop(vBox);
		 scene = new Scene(lay, 1200, 600);
		window.setScene(scene);
		window.show();
	}

	// Add button clicked
	public void addButtonClicked() {
		try {
			ObservableList<Flight> productSelected, allProducts;
			allProducts = table.getItems();
			productSelected = table.getSelectionModel().getSelectedItems();
			Flight bus=(Flight)table.getSelectionModel().getSelectedItem();
			
			if (Check.reservationExists(bus.getDepartureDate(), Login.user.getUserName())) {
				Alert.display("Manage Flight", "Reservation Already Exist");
			} else {
				busQuery = SQL.getPassengerCount(bus.getFlightNumber());
				if (busQuery.length != 0 && busQuery[0] == busQuery[1]) {
					Alert.display("Manage Flight", "This Bus is Full!");
				}else {
					Booking booking = new Booking(Login.user.getUserName(), flight.getFlightNumber(),
							bus.getDepartureDate(), count++);
					SQL.updatePassengerCount(++busQuery[1], bus.getFlightNumber());
					BookFlight a = new BookFlight();
					a.start(window);
				}
			}

		} catch (Exception ex) {
			Alert.display("Manage Flight", "Invalid Input please enter correct inputs!");

		}
	}
	

	// Delete button clicked
	public void deleteButtonClicked() {
		try {
			ObservableList<Booking> productSelected, allProducts;
			allProducts = reservation.getItems();
			productSelected = reservation.getSelectionModel().getSelectedItems();
			Booking res=(Booking)reservation.getSelectionModel().getSelectedItem();
			SQL.deleteBooking(res.getBookingNumber());
			productSelected.forEach(allProducts::remove);
			busQuery = SQL.getPassengerCount(res.getFlightNumber());
			if (busQuery.length != 0) {
				SQL.updatePassengerCount(--busQuery[1], res.getFlightNumber());
				BookFlight updateRes=new BookFlight();
				updateRes.start(window);
			}
			
			
		} catch (NoSuchElementException ex) {
			Alert.display("Manage Flight", "All your reservations have been removed");
		}catch(Exception ex) {
			Alert.display("Manage Flight", "You haven\'t made a selection");

		}
	}
	public ObservableList<Flight> getBusses(){
		ObservableList<Flight> bus= SQL.getFlight();
		return bus;
	}
}