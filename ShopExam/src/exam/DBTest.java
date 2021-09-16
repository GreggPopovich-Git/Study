package exam;

import util.DBManager;

public class DBTest {

	public static void main(String[] args) {
		DBManager conn = DBManager.getInstance();
		System.out.println(conn);
		
	}

}
