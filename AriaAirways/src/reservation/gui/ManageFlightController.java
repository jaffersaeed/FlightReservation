package  reservation.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import reservation.data.SQL;
import reservation.util.Check;
import reservation.util.Booking;
import reservation.util.Flight;
import reservation.gui.LoginCustomerController;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ManageFlightController implements Initializable {

        int[] flightQuery;
        static int count = 1;

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
   private Button back;
   @FXML
   public ComboBox  origin;
   @FXML
   public ComboBox  destination;
   @FXML
   private Button view;
   @FXML
   private Button confirm;
   @FXML
   public DatePicker travelDate;
   @FXML
   public Label error;
   @FXML
   public Button add;
   @FXML
   public Button delete;
   @FXML
   public TextField flightNumber;

//   ObservableList<Flight> newFlightList;

   ImageView myImageView;

   Image myImage = new Image(getClass().getResourceAsStream("GUIdesign5.jpg"));



    public void goBack(ActionEvent event) throws IOException {
         Main m = new Main();
                m.changeScene("AdminMainMenu.fxml");
   }

    public void confirmFlights(ActionEvent event) throws IOException {

        table.setItems(SQL.getFlightDetails(origin.getSelectionModel().getSelectedItem().toString(),travelDate.getValue().format(DateTimeFormatter.ofPattern("MM-DD-YYYY")),destination.getSelectionModel().getSelectedItem().toString()));
   }


    public void add(ActionEvent event) throws IOException {

         boolean dataValid = true;

         String originStr = origin.getSelectionModel().getSelectedItem().toString();
         String destinationStr = destination.getSelectionModel().getSelectedItem().toString();
         String date = travelDate.getValue().format(DateTimeFormatter.ofPattern("MM-DD-YYYY");
         String capacityStr = capacity.getText();
         String passStr = pass.getText();
         String flightN = flightNumber.getText();

          if (dataValid == true)
         {
                 if flightNumber.getSelectionModel().getSelectedItem().toString == 0
                        (
                                        error.setText("Error: Origin cannot be blank."))
                                        dataValid = false;
         }

         if (dataValid == true)
         {
                 if origin.getSelectionModel().getSelectedItem().toString == 0
                        (
                                        error.setText("Error: Origin cannot be blank."))
                                        dataValid = false;
         }

          if (dataValid == true)
         {
                 if destination.getSelectionModel().getSelectedItem().toString() == 0)
                        (
                                        error.setText("Error: Destination cannot be blank."))
                                        dataValid = false;
         }
          if (dataValid == true)
         {
                 if departureTime.getValue().format(DateTimeFormatter.ofPattern("MM-DD-YYYY") == 0)
                        (
                                        error.setText("Error: Date cannot be blank."))
                                        dataValid = false;
         }
          if (dataValid == true)
         {
                 if capacity.getText() == 0
                        (
                                        error.setText("Error: Capacity cannot be blank."))
                                        dataValid = false;
         }
          if (dataValid == true)
         {
                 if pass.getText() == 0
                        (
                                        error.setText("Error: Passenger Count cannot be blank."))
                                        dataValid = false;
         }

          if (dataValid == true)
          { Flight flight = new Flight();
                  flight = SQL.createFlight(flightNum,originStr, destinationStr
                                  date, capactiyStr, passStr);

                        table.getItems().add(flight);
                        originStr.clear();
                                destinationStr.clear();
                                date.clear();
                                passStr.clear();
                                capacityStr.clear();
                                flightNum.clear();

                        error.setText("Success! Flight has been added.");
          }

}

     public void delete(ActionEvent event) throws IOException {
          try {
                        ObservableList<Flight> productSelected, allProducts;
                        allProducts = table.getItems();
                        productSelected = table.getSelectionModel().getSelectedItems();
                        Flight flight =(Flight) table.getSelectionModel().getSelectedItem();
                        SQL.deleteFlight(flight.getFlightNumber());
                        productSelected.forEach(allProducts::remove);

                } catch (NoSuchElementException ex) {
                        error.setText("There are no trips");
                }
        }


        public void initialize(URL url, ResourceBundle rb ) {
                ObservableList<String> list = FXCollections.observableArrayList("Atlanta","Boston","Chicago","Dallas-Fort Worth","Denver","Houston","Las Vegas","Los Angeles","Miami","New York","Pheonix","San Francisco","Seattle","Washington D.C");
                origin.setItems(list);
                ObservableList<String> list1 = FXCollections.observableArrayList("Atlanta","Boston","Chicago","Dallas-Fort Worth","Denver","Houston","Las Vegas","Los Angeles","Miami","New York","Pheonix","San Francisco","Seattle","Washington D.C");
                destination.setItems(list1);

        //      flightList = new ObservableListt<Flight>();

                        flightIdColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightNumber"));
                        originCityColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureCity"));
                        departingCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
                        departingColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDate"));
                        capacityColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("capacity"));
                        remainingColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("passengerCount"));

        //              table.setItems(SQL.createFlight());

        }

}