package  reservation.gui;

import java.net.URL;
import java.sql.SQLException;

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
import reservation.data.SQL;


import java.io.IOException;


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
    private TextField state; // change this to a choice box - code below
    @FXML
    private TextField city;
    @FXML
    private ComboBox  comb;
    @FXML
    private TextField securityAnswer;
    @FXML
    private Label error;
    
  //  private TextField email;
    @FXML
    private Button back;
    @FXML
    private Button registerNext;
    @FXML
    private TextField ssn;
    @FXML 
    private TextField phoneNumber;
    
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign3.jpg"));
   
    
    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("WelcomePage.fxml");
    }
	
	@FXML
    void Select(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
  //      String s1 = state.getSelectionModel().getSelectedItem().toString();
        
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> list = FXCollections.observableArrayList("What is your favorite pet's name?","Where is your mom from?","Where were you born?","What is the name of your 2nd grade teacher?");
         comb.setItems(list);
    }    
     
    public void next(ActionEvent event) throws IOException {
    
    	 String result;
    	 String type;
    	 String usernameStr = username.getText();
    	 String passwordStr = password.getText();
    	 String firstname = firstName.getText();
    	 String lastname = lastName.getText();
    	 String addressStr = address.getText();
    	 String cityStr = city.getText();
    	 String stateStr = state.getText();
    	 String zipcodeStr = zipcode.getText();
    	 String phoneNumberStr = phoneNumber.getText();
    	 String ssnStr = ssn.getText();
    //	 combStr = comb.getSelectionModel().getSelectedItem();
    	 String securityanswer = securityAnswer.getText();
    	
		if (usernameStr.isEmpty() || passwordStr.isEmpty() || firstname.isEmpty() || lastname.isEmpty() ||
				addressStr.isEmpty() || cityStr.isEmpty() ||
				stateStr.isEmpty() || zipcodeStr.isEmpty() ||
				 phoneNumberStr.isEmpty() || ssnStr.isEmpty() ||
				securityanswer.isEmpty()) {
			error.setText("Please enter all criteria.");
			
		} else {
			 String[] newUser = {usernameStr, passwordStr,type = "Customer",firstname,lastname,
				addressStr,cityStr,stateStr,zipcodeStr,
				 phoneNumberStr, ssnStr, (String) comb.getSelectionModel().getSelectedItem(),
				securityanswer};
		 		
    	 		SQL c = new SQL();
    	 		try {
					c.createUser(usernameStr, passwordStr, type, firstname, lastname, addressStr, cityStr, stateStr, zipcodeStr, phoneNumberStr, phoneNumberStr, ssnStr, securityanswer, securityanswer);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	 		Main m = new Main();
    	 		m.changeScene("WelcomePage.fxml");
    			
		
    }
    } 
		
    	
    			
    
    

 public boolean userInput(TextField a, TextField b, TextField c, TextField d, TextField e, TextField f, TextField g,
			TextField h, TextField i, TextField j, TextField k,  ComboBox<String> l, TextField m) {
		if (a.getText().isEmpty() || b.getText().isEmpty() || c.getText().isEmpty() || d.getText().isEmpty()
				|| e.getText().isEmpty() || f.getText().isEmpty() || g.getText().isEmpty()
				|| h.getText().isEmpty() || i.getText().isEmpty() || j.getText().isEmpty()
				|| k.getText().isEmpty() || l.getSelectionModel().isEmpty() || m.getText().isEmpty()) {
			return true;
		}
		return false;

	}

 } 
   


