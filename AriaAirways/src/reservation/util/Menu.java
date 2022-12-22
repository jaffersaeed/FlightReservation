package reservation.util;

import java.sql.SQLException;

import reservation.data.SQL;

public interface Menu {
	
	
	public static User login(String userName, String password) {

		String[] result = null; 
		try {
			result = SQL.getUser(userName, password); 
		}
		catch (SQLException sql) {
			System.out.println(sql.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
		
			if (result[2].matches("Admin")) {
				return new Admin(result[0], result[1], result[2], result[3], result[4], result[5], result[6],
					result[7], result[8], result[9], result[10], result[11], result[12],result[13]);
			}
			else 
				return new Customer(result[0], result[1], result[2], result[3], result[4], result[5], result[6],
					result[7], result[8], result[9], result[10], result[11], result[12],result[13]);
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid user");
		}
		
		return new Customer();
		
	}

	public static String register(String[] newUser) {
		
		for (int i = 0; i < newUser.length; i++) {
			if (newUser[i] == null)
				return "Invalid Input";
		}
		
		if (newUser.length != 12) {
			return "Your registration information is incomplete";
		}
		else if (Check.usernameExists(newUser[0])) {
			return "Username exists";
		}
		
		int zipCode = 0;
		try {
			zipCode = Integer.parseInt(newUser[7]);
		}
		catch (NumberFormatException n) {
			return "Invalid zip code";
		}
		catch (Exception e) {
			return "Invalid zip code";
		}
		
		String city;
		try {
			city = SQL.getCity(zipCode).toUpperCase();
			if (city.length() == 0) {
				return "Invalid zip code";
			}
		}
		catch (SQLException sql) {
			sql.getMessage();
			return "Registration failure";
		}
		
		String userName = newUser[0], password = newUser[1],firstName = newUser[2].toUpperCase(), 
				lastName = newUser[3].toUpperCase(), address = newUser[4].toUpperCase(), 
				state = newUser[6].toUpperCase(), phoneNumber = newUser[8], email = newUser[9], ssn = newUser[10], 
				securityQuestion = newUser[11], securityAnswer = newUser[12];
		
		if (!(email.contains("@") && email.contains(".com"))) {
			return "Invalid email";
		}
		
		String userType = "";
		if (email.contains("@yorla.com")) { 
			userType = "Admin";
		}
		else {
			userType = "Customer";
		}
		
		if (!ssn.matches("\\d{9}")) {
			return "Enter 9 digits SSN";
		}
		
		String zip = zipCode +"";
	
		try {
			SQL.createUser(userName, password,userType,firstName,lastName,address,city,state,zip,phoneNumber,
					email,ssn,securityQuestion,securityAnswer);
		}
		
		catch (SQLException sql) {
			sql.getMessage();
			return "Registration failure";
		}
		
		return "Your registration is successful";
		
	}
	

	public static String[] forgotPassword(String userName) {
		String[] query = null; String[] result = new String[3];

		if (Check.usernameExists(userName)) {
			try {
				query = SQL.getUser(userName);
			}
			catch (SQLException sql) {
				result[0] = sql.getMessage();
			}
			
			result[0] = query[11];
			result[1] = query[12];
			result[2] = query[1];
			
		}
		else {
			result[0] = "Username does not exist in database";
		}
		
		return result;
		
	}	

}