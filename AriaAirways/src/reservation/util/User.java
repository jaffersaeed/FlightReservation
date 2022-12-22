package reservation.util;

<<<<<<< HEAD
import reservation.util.Menu;
import reservation.util.Booking;
import javafx.util.*;

=======
>>>>>>> branch 'master' of https://github.com/jaffersaeed/FlightReservation.git
public abstract class User implements Menu {
	
	//This is the data field
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String email;
	private String phoneNumber;
	private String ssn;
	private String userName;
	private String password; 
	private String securityQ;
	private String securityA;
	private String type;
	public Booking booking;
	
	//no-argument constructor creates a default user
	public User() {
		
	}
	
	//this constructor creates a User object with user input
	public User(String username, String password, String userType, String firstName,
			String lastName, String address, String city, String state, String zipCode, String email,
			String phoneNumber, String ssn, String securityQ, String securityA) {
		type = userType;
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setSsn(ssn);
		setUserName(username);
		setPassword(password);
		setSecurityQ(securityQ);
		setSecurityA(securityA);
	}

	//returns first name
	public String getFirstName() {
		return firstName;
	}
	
	//sets first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//returns last name
	public String getLastName() {
		return lastName;
	}

	//sets last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//returns address
	public String getAddress() {
		return address;
	}

	//sets address
	public void setAddress(String address) {
		this.address = address;
	}

	//returns ZIP code
	public String getZipCode() {
		return zipCode;
	}

	//sets ZIP code
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	//returns city
	public String getCity() {
		return city;
	}

	// sets this user's city
	public void setCity(String city) {
		this.city = city;
	}

	// returns this user's city
	public String getState() {
		return state;
	}

	// sets this user's state
	public void setState(String state) {
		this.state = state;
	}

	// returns this user's state
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//returns this user's password
	public String getPassword() {
		return password.toString();
	}
	
	// returns user type
	public String getType() {
		return type;
	}

	// sets user type
	public void setType(String type) {
		this.type = type;
	}

	//sets this user's password security question
	public void setSecurityQ(String securityQ) {
		this.securityQ = securityQ;
	}
	
	//sets this user's password security answer
	public void setSecurityA(String answer) {
		this.securityA = answer;
	}
	
	// returns this user password security question
	public String getSecurityQ() {
		return this.securityQ;
	}
	
	// returns this user password security answer
	public String getSecurityA() {
		return this.securityA;
	}
	
	//sets this user's password security question
	public void setPhoneNumber(String securityQ) {
		this.securityQ = securityQ;
	}
	
	// returns this user password security question
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	
}