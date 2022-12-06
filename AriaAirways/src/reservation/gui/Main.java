package reservation.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Main extends Application {

	Stage window;

	public static void main(String[] args) {
		launch(args);
	}
@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Flight Login Page");
		
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
		Label welcome1 = new Label("Welcome to Aria's Airplane Reservation");
		GridPane.setConstraints(welcome1, 0, 0);
		welcome1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		
	
		Label newLabel = new Label("Username:");
		GridPane.setConstraints(newLabel, 0, 4);
	
		TextField nameInput = new TextField("");
		nameInput.setPromptText("Username");
		GridPane.setConstraints(nameInput, 1, 4);
		

		Label password = new Label("Password");
		GridPane.setConstraints(password, 0, 5);
	
		PasswordField passInput = new PasswordField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 5);
	
		Button loginB = new Button("Login");
		GridPane.setConstraints(loginB, 1, 7);
	
		Label forgotPass = new Label("Forgot your password? ");
		GridPane.setConstraints(forgotPass, 1, 9);
	
		Button forgotB = new Button("Forgot");
		GridPane.setConstraints(forgotB, 1, 10);
		
		Label register = new Label("Need to Register? ");
		GridPane.setConstraints(register, 1, 12);
	
		Button registerB = new Button("Register");
		GridPane.setConstraints(registerB, 1, 13);
	

		Scene scene1 = new Scene(grid, 800, 400);
		grid.getChildren().addAll(welcome1, password, nameInput, passInput,newLabel, loginB, forgotB, forgotPass, register, registerB);
		grid.setAlignment(Pos.CENTER);	     
		window.setScene(scene1);
		window.show();

}
}
