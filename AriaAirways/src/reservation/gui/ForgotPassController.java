package  reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import reservation.util.Check;
import reservation.util.Menu;
import reservation.data.SQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class ForgotPassController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Button changePassword_bttn;
    @FXML
    private TextField UsernameForgotpass;
    @FXML
    private Label error;
    @FXML
    private TextField SecurityAnswer;
    @FXML
    private ComboBox comb;
    
    ImageView myImageView;
    
    Image myImage = new Image(getClass().getResourceAsStream("GUIdesign2.jpg"));
    
    public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("loginCustomer.fxml");
    }
    @FXML
    void comb(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();

        
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> list = FXCollections.observableArrayList("What is your favorite pet's name?","Where is your mom from?","What is your mother's maiden name?","What is the name of your 2nd grade teacher?");
         comb.setItems(list);
    }
         
         
     public void changePass(ActionEvent event) throws IOException {
    	 if(Check.usernameExists(UsernameForgotpass.getText())) {
    		 
    		 String [] query = Menu.forgotPassword(UsernameForgotpass.getText());
    		 if (query.length == 15) {
    			 if(SecurityAnswer.getText().equals(query[2])) {
    		 		error.setText(query[1]);				
    	 }
    			if(!SecurityAnswer.getText().equals(query[2])) {
    		 		error.setText("Invalid Answer");	
    			 }
    		 }
    	 }
    	 if(!Check.usernameExists(UsernameForgotpass.getText())) {
    		 error.setText("Username Doesn't Exist");
    	 }
    }
}
