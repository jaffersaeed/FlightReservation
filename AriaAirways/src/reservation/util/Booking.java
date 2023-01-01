package reservation.util;

import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

import reservation.data.SQL;

public class Booking {

	private int bookingNumber; 
	private String dateCreated; 
	private String username;
	private int flightNumber; 
	private String departureDate; 
	private int ticketNumber;
	
	private static int bookingCount;
	public String result;
	
	
	public Booking() {
		this("Username not found!", 0, "Not found",0);
	}
	
	public Booking(String string, int i, String string2, int j) {

	}

	public Booking(String username, String departureDate, int ticketNumber, int flightNumber) {
		int lastCount = Check.getbookingCount();
		bookingCount = ++lastCount;
		this.flightNumber = bookingCount;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		this.dateCreated = sdf.format(date); 
		this.bookingNumber=flightNumber;
		this.username = username;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.ticketNumber = flightNumber;
		this.result = createBooking();
		Check.setbookingCount(bookingCount);
	}
	
	public Booking(int bookingNumber, String dateCreated, String username, int flightNumber, String departureDate, int ticketNumber) {
			this.bookingNumber = bookingNumber;
			this.dateCreated = dateCreated;
			this.username = username;
			this.flightNumber = flightNumber;
			this.departureDate = departureDate;
			this.ticketNumber = ticketNumber;
	}

	public String createBooking() {
		String output = "";// a string to save the result of this update
		try {// call database and save response in output
			output = SQL.createBooking(this.bookingNumber, this.dateCreated, this.username,
					this.flightNumber, this.departureDate, this.ticketNumber);
		} catch (SQLException sql) {
			output = sql.getMessage();// save any error message in output
		} catch (Exception e) {
			output = e.getMessage();// save any error message in output
		}

		return output;
	}

	public int getBookingNumber() {
		return flightNumber;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getUsername() {
		return username;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public String getDepartureDate() {
		return departureDate;
	}


	public static int getBookingCount() {
		return bookingCount;
	}

	public void setBookingNumber(int bookingNumber) {
		this.flightNumber = bookingNumber;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public static void setBookingCount(int bookingCount) {
		Booking.bookingCount = bookingCount;
	}

}
