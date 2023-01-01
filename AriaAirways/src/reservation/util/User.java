package reservation.util;





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
	

	public User() {
		
	}
	

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


	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


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


	public String getPassword() {
		return password.toString();
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	public void setSecurityQ(String securityQ) {
		this.securityQ = securityQ;
	}
	
	public void setSecurityA(String answer) {
		this.securityA = answer;
	}

	public String getSecurityQ() {
		return this.securityQ;
	}
	

	public String getSecurityA() {
		return this.securityA;
	}
	

	public void setPhoneNumber(String securityQ) {
		this.securityQ = securityQ;
	}
	

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	
}