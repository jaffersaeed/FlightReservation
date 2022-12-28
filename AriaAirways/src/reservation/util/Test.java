package reservation.util;

import reservation.data.SQL;
import 

public class Test {
	public void testGetUser() throws SQLException {
		   String[] expectedUser = {"testuser", "testpassword", "testusertype", "Test", "User", "123 Main St", "Testville", "TX", "12345", "test@example.com", "123-45-6789", "test question", "test answer"};
		   String[] actualUser = SQL.getUser("testuser", "testpassword");

		   assertArrayEquals(expectedUser, actualUser);
		}
}
/*	public static void main(String[] args) {
		String username= "lilpapa";
		String password= "123papa";
		SQL.getUser(username, password);
	}

}*/


