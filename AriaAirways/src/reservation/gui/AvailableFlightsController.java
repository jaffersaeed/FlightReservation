package  reservation.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import reservation.data.SQL;
import reservation.util.Flight;

public class AvailableFlightsController implements Initializable{
	

	@FXML
	private TableView<Flight>table;
	@FXML
	private TableColumn<Flight, Integer> flightIdColumn;
	@FXML
	private TableColumn<Flight, String> originCityColumn;
	@FXML
	private TableColumn<Flight, String> departingCity;
	@FXML
	private TableColumn<Flight, String> departingColumn; 
	@FXML
	private TableColumn<Flight, Integer> capacityColumn;
	@FXML
	private TableColumn<Flight, Integer> remainingColumn;
	

	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
    private Label error;
	
	static int count = 1;
	
	


	public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
    }

	
	public void delete(ActionEvent event) throws IOException {
   	  Main m = new Main();
	        m.changeScene("ManageFlight.fxml");
    }



	public void initialize(URL url, ResourceBundle rb ) {
			flightIdColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightNumber"));
			originCityColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureCity"));
			departingCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
			departingColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDate"));
			capacityColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("capacity"));
			remainingColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("passengerCount"));
			
			table.setItems(SQL.getFlight());
		
	}
}