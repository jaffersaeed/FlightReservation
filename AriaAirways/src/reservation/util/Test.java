package reservation.util;

import reservation.data.SQL;


public class Test {
	public static void main(String[] args) {
		String username= "lilpapa";
		String password= "123papa";
		SQL.getUser(username, password);
	}

}
