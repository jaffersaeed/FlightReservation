package reservation.gui;

    import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextField;
	import reservation.util.Check;
	import reservation.util.Customer;
	import reservation.util.User;
	import reservation.util.Menu;

	import java.io.IOException;

	public class LoginCustomerController {

	    @FXML
	    private Button login_bttn;
	   @FXML
	    private Button forgotpass_bttn;
	   @FXML
	    private Button back_bttn;
	    @FXML
	    private TextField username;
	   @FXML
	    private TextField password;
	   
	   static User user;
	  

	    public void Mainmenu(ActionEvent event) throws IOException {
	        Main m = new Main();
	        
	            if (Check.isValidUser(username.getText(), password.getText())) {
	            	user = Menu.login(username.getText(), password.getText());
	}
				if ((Check.isValidUser(username.getText(), password.getText())
					&& (user instanceof Customer))) {
						m.changeScene("MainMenu.fxml");
					}

				}
					
	 
}