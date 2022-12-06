package reservation.util;

public class Admin extends User {

	public Admin( String userName, String password, String type, String firstName,
			String lastName, String address, String city, String state, String zipCode, String email,
			String phoneNumber, String ssn, String securityQ, String securityA) {
		
		super(userName, password, type, firstName,lastName,
				address, city,  state,  zipCode,  email,
				phoneNumber,  ssn,  securityQ,  securityA);
	}

	@Override
	public void makeNewReservation(int flightNumber, String departureDate, int ticketNumber) {
		// TODO Auto-generated method stub
		
	}
}