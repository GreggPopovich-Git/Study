package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jsl49","ehfkdl12");
			// MySQL일 경우
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:db이름", "계정", "비밀번호");
			// Oracle일 경우
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
