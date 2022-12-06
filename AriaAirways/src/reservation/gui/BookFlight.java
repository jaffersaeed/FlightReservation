package reservation.gui;

import javafx.application.Application;
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
import reservation.util.Flight;
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
		
		// Delete Button
		Button delete = new Button("Remove Booking");
		
		// Back Button to return to admin main page
		Button back = new Button("Back");
		

		HBox hBox = new HBox();
		Label book = new Label("Book a Flight");
		Label space = new Label("   ");
		hBox.getChildren().addAll(book, space, bookButton);
		hBox.setAlignment(Pos.BASELINE_RIGHT);
		table = new TableView<>();

	
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		VBox yu = new VBox();
		HBox hBack = new HBox();
		hBack.getChildren().addAll(delete, back);
		hBack.setAlignment(Pos.BASELINE_RIGHT);

		yu.getChildren().addAll( hBack);
		BorderPane lay = new BorderPane();
		lay.setCenter(yu);
		lay.setTop(vBox);
		 scene = new Scene(lay, 1200, 600);
		window.setScene(scene);
		window.show();
	}

	}
