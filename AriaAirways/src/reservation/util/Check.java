package reservation.util;

import java.sql.SQLException;
import reservation.data.SQL;

public class Check {
	
	public Check() {
		
	}
	
	
	public static boolean isValidUser(String username, String password) {
		
		String[] result;
		try {
			result = SQL.getUser(username, password);
		}
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
			return false;
		}
		
		if (result[0] == null) {
			return false;
		}
		else
			return true;
		
	}
	
	
	public static boolean usernameExists(String username) {
		String result;
		try {
			result = SQL.getUsername(username);
		} catch (SQLException sql) {
			System.out.println(sql.getSQLState());
			return false;
		}

		if (result.length() == 0) {
			return false;
		} else
			return true;
				
	}
	
	
	public static int getbookingCount() {
		int result = 0;
		
		try {
			result = SQL.getBookingCount();
		}
		catch (SQLException s) {
			
		}
		catch (Exception e) {
			
		}
		
		return result;
	}
	
	
	public static void setbookingCount(int resCount) {

		try {
			SQL.setBookingCount(resCount);
		} catch (SQLException s) {

		} catch (Exception e) {

		}

		System.out.println("Success!");
	}
	
	public static boolean bookingExists(String departureDate, String username) {
		String[] result = new String[6]; 
		try {
			 result = SQL.getBooking(departureDate, username);
		}
		
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
			return true;
		}
		catch (Exception e) {
			return true;
		}
		
		if ( result[4] != departureDate && result[2] != username) {
			return false;
		}
		else
			return true;
		
	}

}