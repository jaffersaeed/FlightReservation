package reservation.gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
<<<<<<< HEAD
<<<<<<< HEAD
import javafx.application.Application;
import javafx.stage.Stage;
=======
>>>>>>> branch 'master' of https://github.com/jaffersaeed/CIS-Project.git
=======
>>>>>>> branch 'master' of https://github.com/jaffersaeed/CIS-Project.git
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class FlightMainMenu extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}


@Override
	public void start(Stage primaryStage)  {
		window = primaryStage;
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		// Create a Username label
		Label welcome = new Label("Welcome to Aria's Airplane Reservation");
		GridPane.setConstraints(welcome, 0, 0);
		// Create a Username text field
		Button book = new Button("Book Flights");
		GridPane.setConstraints(book, 0, 1);
		Button available = new Button("All Available Rides");
		GridPane.setConstraints(available, 0, 2);
		Button logout = new Button("Logout");
		GridPane.setConstraints(logout, 0, 3);
		
		grid.getChildren().addAll(welcome, book, available, logout);
		grid.setAlignment(Pos.CENTER);
		Scene scene = new Scene(grid, 800, 400);
		window.setScene(scene);
		window.show();
	}
}
