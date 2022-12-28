package  reservation.gui;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private ComboBox state; // change this to a choice box - code below
    @FXML
    private TextField city;
    @FXML
    private ComboBox  comb;
    @FXML
    private TextField securityAnswer;
    @FXML
    private TextField email;
    @FXML
    private Button back;
    @FXML
    private Button registerNext;
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign3.jpg"));
   
    
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
         ObservableList<String> list1 = FXCollections.observableArrayList("Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho",
			"Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
			"Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska",
			"Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
			"Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island",
			"South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont",
			"Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
         state.setItems(list);
    }    
     
    public void next(ActionEvent event) throws IOException {
    	 String result;
		String[] newUser = {username.getText(),password.getText(),firstName.getText(),lastName.getText(),
				address.getText(),city.getText(),
				(String) state.getSelectionModel().getSelectedItem(),zipcode.getText(),
				email.getText(), (String) comb.getSelectionModel().getSelectedItem(),
				securityAnswer.getText()};
		
    			Main m = new Main();
    			m.changeScene("loginCustomer.fxml");
    }

}

