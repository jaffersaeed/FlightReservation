package reservation.util;

import java.sql.SQLException;

import reservation.data.SQL;

public class Check {
	
	private Check() {
		
	}
	
	/** method returns true if this user is valid */
	public static boolean isValidUser(String username, String password) {
		
		String[] result;// A string array to store user information when retrieved from database
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
			System.out.println(sql.getMessage());
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
			result = SQL.getReservationCount();
		}
		catch (SQLException s) {
			
		}
		catch (Exception e) {
			
		}
		
		return result;
	}
	
	
	public static void setbookingCount(int resCount) {

		try {
			SQL.setReservationCount(resCount);
		} catch (SQLException s) {

		} catch (Exception e) {

		}

		System.out.println("Success!");
	}
	
	public static boolean bookingExists(String departureDate, String username) {
		String[] result = null; 
		try {
			result = SQL.getReservation(departureDate, username);
		}
		
		catch (SQLException sql) {
			return true;
		}
		catch (Exception e) {
			return true;
		}
		
		if (result.equals(null) || result[0] == null) {
			return false;
		}
		else
			return true;
		
	}

}