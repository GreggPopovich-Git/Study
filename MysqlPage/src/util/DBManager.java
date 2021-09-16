package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		// DB Connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsl49", "jsl49", "ehfkdl12");
			//System.out.println("Connection Success");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}