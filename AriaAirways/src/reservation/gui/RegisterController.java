package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
	
	@FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField address;
    @FXML
    private TextField zipcode;
    @FXML
    private TextField state;
    @FXML
    private TextField city;
    @FXML
    private ComboBox  comb;
    @FXML
    private TextField securityAnswer;
    @FXML
    private Button back;
    @FXML
    private Button registerNext;
   
    
    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
	
	@FXML
    void Select(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
        
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> list = FXCollections.observableArrayList("What is your favorite pet's name?","Where is your mom from?","Where were you born?","What is the name of your 2nd grade teacher?");
         comb.setItems(list);
    }    
     
    public void next(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }

}
