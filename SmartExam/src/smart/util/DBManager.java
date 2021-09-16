package smart.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	// DB Connection method
	public static Connection getConnection() {
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String myID = "jsl49";
		String myPass = "ehfkdl12";
		
		Connection myConn = null;
		try {
			Class.forName(myDriver);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			myConn = DriverManager.getConnection(myURL, myID, myPass);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return myConn;
	}
	
}