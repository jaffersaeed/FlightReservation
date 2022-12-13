package reservation.gui;

import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import reservation.util.Flight;


public class ViewAvail extends Application {

	Stage window;
	TableView<Flight> table;
	TextField flightId, originCity, destinationCity, departureTime, departureDate, capacity, remaining;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Flight Reservation App");
		// Flight Id column
		TableColumn<Flight, Integer> flightIdColumn = new TableColumn<>("Flight Id");
		flightIdColumn.setMinWidth(100);
		flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

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
		// Flight input
		flightId = new TextField();
		flightId.setPromptText("Flight Id");
		flightId.setMinWidth(150);

		// Departure City input
		originCity = new TextField();
		originCity.setPromptText("Departure City");

		// Destination City input
		destinationCity = new TextField();
		destinationCity.setPromptText("Destination City");
		// Departure Date City input
		departureTime = new TextField();
		departureTime.setPromptText("Departure Date");
		// Destination City input
		capacity = new TextField();
		capacity.setPromptText("Amount");
		// Departure Date City input
		remaining = new TextField("0");

		// Back Button to return to admin main page
		Button back = new Button("Back");
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(back);

		table = new TableView<>();
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		BorderPane lay = new BorderPane();
		lay.setCenter(vBox);

		Scene scene = new Scene(lay);
		window.setScene(scene);
		window.show();
	}

	}

