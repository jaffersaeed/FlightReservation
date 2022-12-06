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
import flightreservation.flight;
public class ManageFlight extends Application {

	Stage window;
	TableView<flight> table;
	TextField flightId, originCity, destinationCity, departureTime, departureDate, capacity, remaining;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Aria's Airline Reservation");
		// Bus Id column
		TableColumn<flight, Integer> flightIdColumn = new TableColumn<>("Flight Id");
		flightIdColumn.setMinWidth(100);
		flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));

		// Departure City column
		TableColumn<flight, String> originCityColumn = new TableColumn<>("Origin City");
		originCityColumn.setMinWidth(150);
		originCityColumn.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

		// Destination City column
		TableColumn<flight, String> departingCity = new TableColumn<>("Destination City");
		departingCity.setMinWidth(150);
		departingCity.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		// Departure Time column
		TableColumn<flight, String> departureColumn = new TableColumn<>("Departure Time");
		departureColumn.setMinWidth(150);
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		// Capacity City column
		TableColumn<flight, Integer> capcityColumn = new TableColumn<>("Capacity");
		capcityColumn.setMinWidth(150);
		capcityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		// Seats Available Time column
		TableColumn<flight, String> remainingColumn = new TableColumn<>("Passanger Count");
		remainingColumn.setMinWidth(150);
		remainingColumn.setCellValueFactory(new PropertyValueFactory<>("passengerCount"));
		// Bus input
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
		// Add Button
		Button addButton = new Button("Add");
	
		// Delete Button
		Button deleteButton = new Button("Delete");

		// Back Button to return to admin main page
		Button back = new Button("back");
	
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(flightId, originCity, departureTime, destinationCity, capacity, remaining, addButton,
				deleteButton, back);

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
}
