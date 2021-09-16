package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DBManager {
	public static Connection getConnection() { // Oracle DB 접속
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jsl49","ehfkdl12");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, PreparedStatement pstmt) { // Oracle DB 접속 해제
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) { // Oracle DB 접속 해제
		try {
			rs.close();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}