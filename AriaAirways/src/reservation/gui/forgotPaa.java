package reservation.gui;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class forgotPaa extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Forgot Password");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);
		// Username Label
		
		Label title = new Label("Forgot Password");
		GridPane.setConstraints(title, 0, 0);
		title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		
		Label message = new Label("Please enter existing username ");
		GridPane.setConstraints(message, 0, 2);
		
		
		Label newLabel = new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 3);
		
		// Username text field
		TextField nameInput = new TextField();
		nameInput.setPromptText("Username");
		GridPane.setConstraints(nameInput, 1, 3);

		// Create a complete button
		Button complete = new Button("Confirm");
		
		GridPane.setConstraints(complete, 0, 4);
		Button login = new Button("Back");		
		GridPane.setConstraints(login, 3, 0);

		

		grid.getChildren().addAll(newLabel, nameInput, complete, login, title, message);

		Scene scene = new Scene(grid, 800, 400);
		window.setScene(scene);
		window.show();
	}
}

