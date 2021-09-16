package oracle.exam;

import java.sql.Connection;

import oracle.util.DBManager;

public class DBTest {

	public static void main(String[] args) {
		Connection conn = DBManager.getConnection();
		System.out.print("conn : " + conn);
		
	}

}
