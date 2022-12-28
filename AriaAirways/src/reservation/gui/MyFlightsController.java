package application;

public class MyFlightsController implements Initializable {
	@FXML
	private TableView<Flight, Integer> table;
	@FXML
	private TableColumn<Flight, Integer> flightIdColumn;
	@FXML
	private TableColumn<Flight, Integer> originCityColumn;
	@FXML
	private TableColumn<Flight, Integer> departingCity;
	@FXML
	private TableColumn<Flight, Integer> departingColumn; // depart time
	@FXML
	private TableColumn<Flight, Integer> capacityColumn;
	@FXML
	private TableColumn<Flight, Integer> remainingColumn;
	@FXML
	private Button back;
	
	public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("MainMenu.fxml");
    }
	
	@Override
	public void initalize(URL url, ResourceBundle rn) {
		
		flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		originCityColumn.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
		departingCity.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		capcityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		remainingColumn.setCellValueFactory(new PropertyValueFactory<>("passengerCount"));
}
		public ObservableList<Flight> getBooking(){
		ObservableList<Flight> flight= SQL.getBooking();
		return flight;
	}
