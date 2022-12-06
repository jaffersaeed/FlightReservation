package reservation.data;


import javafx.collections.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javafx.collections.ObservableList;
import reservation.util.Flight;
import reservation.util.Booking;

public class SQL {
	
	private Connection connection;
	static ObservableList<Flight> flightSchedule;
	static ObservableList<Booking> booking;
	
	private SQL() {
		
	}

	/**public static void main(String[] args) {
		System.out.println("performing setup...");		
		String userName = "asolomon14@student.gsu.edu";
		String userPassword = "Mountain3717";
		String cnnString=
				"jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;"
				+ "user=" + userName + ";"
				+ "password=" + userPassword + ";"
				+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;"
				+ "loginTimeout=30;authentication=ActiveDirectoryPassword";
		
	}**/
	public static String createUser(String userName, String password, String type, String firstName,
			String lastName, String address, String city, String state, String zipCode, String phoneNumber,String email,
			String ssn, String securityQ, String securityA) throws SQLException {
		
		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "insert into User values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setString(1, userName);
		statement.setString(2, password);
		statement.setString(3, type);
		statement.setString(4, firstName);
		statement.setString(5, lastName);
		statement.setString(6, address);
		statement.setString(7, city);
		statement.setString(8, state);
		statement.setString(9, zipCode);
		statement.setString(10, phoneNumber);
		statement.setString(11, email);
		statement.setString(12, ssn);
		statement.setString(13, securityQ);
		statement.setString(14, securityA);

		statement.executeUpdate();

		c.connection.close();

		return "Account created successfully";

	}
	public static String[] getUser(String username) throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");
		String[] user = new String[14];

		String query = "Select * from User where username=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, username);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			user[0] = result.getString(1);
			user[1] = result.getString(2);
			user[2] = result.getString(3);
			user[3] = result.getString(4);
			user[4] = result.getString(5);
			user[5] = result.getString(6);
			user[6] = result.getString(7);
			user[7] = result.getString(8);
			user[8] = result.getString(9);
			user[9] = result.getString(10);
			user[10] = result.getString(11);
			user[11] = result.getString(12);
			user[12] = result.getString(13);
			user[13] = result.getString(14);
		}

		c.connection.close();

		return user;

	}
	public static String[] getUser(String username, String password) throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");
		String[] user = new String[14];

		String query = "Select * from User where username=? and password=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, username);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			user[0] = result.getString(1);
			user[1] = result.getString(2);
			user[2] = result.getString(3);
			user[3] = result.getString(4);
			user[4] = result.getString(5);
			user[5] = result.getString(6);
			user[6] = result.getString(7);
			user[7] = result.getString(8);
			user[8] = result.getString(9);
			user[9] = result.getString(10);
			user[10] = result.getString(11);
			user[11] = result.getString(12);
			user[12] = result.getString(13);
			user[13] = result.getString(14);
		}

		c.connection.close();

		return user;

	}
	public static String getUsername(String userName) throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "Select username from User where username=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, userName);

		ResultSet result = statement.executeQuery();
		
		String data = "";

		if (result.next()) {
			data = result.getString(1);
		}

		c.connection.close();

		return data;

	}

	public static void createFlight(int flightNumber, String departureCity, String departureDate,
			String destinationCity, int capacity, int passengerCount) throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "insert into Flight values (?,?,?,?,?,?)";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, flightNumber);
		statement.setString(2, departureCity);
		statement.setString(3, departureDate);
		statement.setString(4, destinationCity);
		statement.setInt(5, capacity);
		statement.setInt(6, passengerCount);

		statement.executeUpdate();

		c.connection.close();

	}
	
	/** method deletes a Flight */
	public static void deleteFlight(int flightNumber) {

		try {
			
		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "delete from Flight where flightNumber = ?";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, flightNumber);

		statement.executeUpdate();

		c.connection.close();
		
		}
		catch(SQLException sql) {
			
		}
		catch(Exception e) {
			
		}

	}
	public static ObservableList<Flight> getFlight() {
		
		try {

			Connection connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

			String query = "Select * from Flight";

			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			flightSchedule = FXCollections.observableArrayList();
			while (result.next()) {
				flightSchedule.addAll(new Flight(result.getInt(1),result.getString(2),result.getString(3),
					result.getString(4), result.getInt(5),result.getInt(6)));
				
			}
			return flightSchedule;
		}
			
		catch (SQLException s) {
			System.out.println(s.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
		
	}
	public static String createBooking(int bookingNumber, String dateCreated, String userName,
			int flightNumber, String departureDate, int ticketNumber) throws SQLException {
		
		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "insert into Booking values (?,?,?,?,?,?)";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, bookingNumber);
		statement.setString(2, dateCreated);
		statement.setString(3, userName);
		statement.setInt(4, flightNumber);
		statement.setString(5, departureDate);
		statement.setInt(6, ticketNumber);

		statement.executeUpdate();

		c.connection.close();

		return "Success!";
	}
	
	
	public static String[] getBooking(int bookingNumber) throws SQLException {
		SQL c = new SQL();

		String[] booking = new String[6];

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "Select * from Booking where bookingNumber =?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setInt(1, bookingNumber);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			booking[0] = "" + result.getInt(1);
			booking[1] = result.getString(2);
			booking[2] = result.getString(3);
			booking[3] = "" + result.getInt(4);
			booking[4] = result.getString(5);
			booking[5] = "" + result.getInt(6);
		}

		c.connection.close();

		return booking;
	}
	
	public static ObservableList<Booking> getBooking(String username) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

			String query = "Select * from Booking where username=?";

			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, username);

			ResultSet result = statement.executeQuery();
			booking = FXCollections.observableArrayList();
			while (result.next()) {
				booking.addAll(new Booking(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getString(5), result.getInt(6)));

			}
			return booking;
		}

		catch (SQLException s) {
			System.out.println(s.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;

	}
	
	public static String[] getBooking(String departureDate, String userName) throws SQLException {
		SQL c = new SQL();

		String[] reservation = new String[6];

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "Select * from Reservation where departureDate =? and username=?";

		PreparedStatement statement = c.connection.prepareStatement(query);

		statement.setString(1, departureDate);
		statement.setString(2, userName);

		ResultSet result = statement.executeQuery();

		if (result.next()) {
			reservation[0] = "" + result.getInt(1);
			reservation[1] = result.getString(2);
			reservation[2] = result.getString(3);
			reservation[3] = "" + result.getInt(4);
			reservation[4] = result.getString(5);
			reservation[5] = "" + result.getInt(6);
		}

		c.connection.close();

		return reservation;
	}
	public static void deleteBooking(int bookingNumber) {

		try {

			SQL c = new SQL();

			c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

			String query = "delete from Booking where bookingNumber = ?";
			PreparedStatement statement = c.connection.prepareStatement(query);
			statement.setInt(1, bookingNumber);

			statement.executeUpdate();

			c.connection.close();

		} catch (SQLException sql) {

		} catch (Exception e) {

		}

	}

	
	public static int getBookingCount() throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "Select * from BookingCount";

		PreparedStatement statement = c.connection.prepareStatement(query);

		ResultSet result = statement.executeQuery();

		int data = 0;

		if (result.next()) {
			data = result.getInt(1);
		}

		c.connection.close();

		return data;

	}
	

	public static void setBookingCount(int bookCount) throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String query = "update BookingCount set resCount=?";

		PreparedStatement statement = c.connection.prepareStatement(query);
		
		statement.setInt(1, bookCount);

		statement.executeUpdate();
		
		c.connection.close();

	}
	
	public static int[] getPassengerCount(int flightNumber) {

		SQL c = new SQL();

		try {

			c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

			String query = "Select capacity,passengerCount from Flight where flightNumber=?";

			PreparedStatement statement = c.connection.prepareStatement(query);
			statement.setInt(1, flightNumber);

			ResultSet result = statement.executeQuery();

			int[] data = new int[2];

			if (result.next()) {
				data[0] = result.getInt(1);
				data[1] = result.getInt(2);
			}

			c.connection.close();

			return data;
		} catch (SQLException sql) {

		} catch (Exception e) {

		}
		
		return null;

	}
	public static void updatePassengerCount(int passengerCount, int flightNumber) {

		try {

			SQL c = new SQL();

			c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

			String query = "update flight set passengerCount=? where flightNumber=?";

			PreparedStatement statement = c.connection.prepareStatement(query);

			statement.setInt(1, passengerCount);
			statement.setInt(2, flightNumber);
			statement.executeUpdate();

			c.connection.close();

		} catch (SQLException sql) {

		} catch (Exception e) {

		}

	}
	public static String getCity(int zipCode) throws SQLException {

		SQL c = new SQL();

		c.connection = DriverManager.getConnection("jdbc:sqlserver://flightres.database.windows.net:1433;database=Data;user=asolomon14@student.gsu.edu;password=Mountain3717;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");

		String city = "";
		String query = "select city from zip where zipCode = ?";
		PreparedStatement statement = c.connection.prepareStatement(query);
		statement.setInt(1, zipCode);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			city = result.getString(1);
		}

		c.connection.close();

		return city;
	}
	public static void main(String[] args) {
		SQL test1 = new SQL();
	}
}