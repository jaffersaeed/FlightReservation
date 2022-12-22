package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchtoMain(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("loginCustomer.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoRegister(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoAdminLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Adminlogin.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoMainMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoForgotPassword(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("forgotPassword.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoForgotPassword2(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword2.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoBacktoWelcome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoAdminMainMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainMenu.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoBacktoWelcome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
		stage = ((Stage)(Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}