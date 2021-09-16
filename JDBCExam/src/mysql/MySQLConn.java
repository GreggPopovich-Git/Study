package mysql;
/* JDBC 접속절차			JDBC API
 * 1. JDBC 드라이버 로딩		Class.forName
 * 2. 커넥션 연결			Connection 객체 생성
 * 		(DB와연결)		DriverManager
 * 3. 명령문 실행			Statement
 * 		(SQL실행)			ResultSet
 * 4. 명령문 실행,커넥션 종료	close();
 * 
 * 5. database backup - ㅡmysql dump -u root -p DB명 > 파일이름.sql
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConn {

	public static void main(String[] args) {
		try {
			// JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL 드라이버 로딩");
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "ehfkdl12");
			System.out.println("MySQL Connection pool");
			
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}