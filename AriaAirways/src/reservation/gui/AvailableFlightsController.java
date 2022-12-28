package application;

public class AvailableFlightsController implements Initializable {

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
	private TableColumn<Booking, Integer> bookingNumber;
	@FXML
	private TableColumn<Booking, Integer> dateCreated;
	@FXML
	private TableColumn<Booking, Integer> flightNumber;
	@FXML
	private TableColumn<Booking, Integer> departureDate;
	@FXML
	private TableColumn<Booking, Integer> ticketNumber;
	@FXML
	private Button button add;
	@FXML
	private Button button delete;
	@FXML
	private Button button back;
	@FXML
    private Label error;
	
	static int count = 1;
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public void goBack(ActionEvent event) throws IOException {
    	 Main m = new Main();
	        m.changeScene("AdminMainMenu.fxml");
    }
	
	public void add(ActionEvent event) throws IOException {
    	 addButtonClicked();
    }
	public void addButtonClicked() {
		try {
			ObservableList<Flight> productSelected, allProducts;
			allProducts = table.getItems();
			productSelected = table.getSelectionModel().getSelectedItems();
			Flight flight=(Flight)table.getSelectionModel().getSelectedItem();
			
			if (Check.bookingExists(flight.getDepartureDate(), Login.user.getUserName())) {
				error.setText("Booking already exists");
			} else {
				flightQuery = SQL.getPassengerCount(flight.getflightNumber());
				if (flightQuery.length != 0 && flightQuery[0] == flightQuery[1]) {
					error.setText("Flight is full.");
				}else {
					Booking booking = new Booking(Login.user.getUserName(), flight.getFlightNumber(),
							flight.getDepartureDate(), count++);
					SQL.updatePassengerCount(++flightQuery[1], flight.getFlightNumber());
					 Main m = new Main();
					 m.changeScene("AdminMainMenu.fxml");
				}
			}

		} catch (Exception ex) {
			error.setText("Invalid Input");

		}
	}
	
	public void delete(ActionEvent event) throws IOException {
    	 deleteButtonClicked();
    }
		public void deleteButtonClicked() {
		try {
			ObservableList<Booking> productSelected, allProducts;
			allProducts = booking.getItems();
			productSelected = booking.getSelectionModel().getSelectedItems();
			Booking book =(Booking)booking.getSelectionModel().getSelectedItem();
			SQL.deleteBooking(book.getBookingNumber());
			productSelected.forEach(allProducts::remove);
			flightQuery = SQL.getPassengerCount(res.getFlightNumber());
			if (flightQuery.length != 0) {
				SQL.updatePassengerCount(--flightQuery[1], book.getflightNumber());
				BookFlight updateBook=new BookFlight();
				Main m = new Main();
				m.changeScene("AdminMainMenu.fxml");
			}
			
		} catch (NoSuchElementException ex) {
			error.setText("All bookings have been removed");
		}catch(Exception ex) {
			error.setText("You haven't made a selection");

		}
	}

	@Override
	public void initalize(URL url, ResourceBundle rn) {
		
		flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		originCityColumn.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
		departingCity.setCellValueFactory(new PropertyValueFactory<>("destinationCity"));
		departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		capcityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		remainingColumn.setCellValueFactory(new PropertyValueFactory<>("passengerCount"));
		bookingNumber.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));
		dateCreated.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
		flightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
		departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		ticketNumber.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));
	}
	

	public ObservableList<Flight> getFlight(){
		ObservableList<Flight> flight= SQL.getFlight();
		return flight;
	}
}
}
