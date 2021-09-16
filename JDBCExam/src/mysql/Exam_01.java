package mysql;
// ANSI 표준
/* DDL(정의) - CREATE, ALTER, DROP
 * DML(조작) - SELECT, INSERT, UPDATE, DELETE
 * DCL(제어) - GRANT, REVOKE
 * TCL(트렌잭션) - COMMIT, ROLLBACK, SAVEPOINT
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam_01 {

	public static void main(String[] args) {
		//String myDriver = "oracle.jdbc.driver.OracleDriver";
		String myDriver = "com.mysql.jdbc.Driver";
		//String myURL = "jdbc:oracle:thin@localhost:1521:xe"; //sid
		String myURL = "jdbc:mysql://localhost:3306/jsl49";
		//String myID = "system"; // 계정이름
		String myID = "jsl49";
		String myPass = "ehfkdl12"; // password
		
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName(myDriver);
			System.out.println("MySQL driver loading");
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			// 2. DB 연결
			Connection con = DriverManager.getConnection(myURL, myID, myPass);
			System.out.println("MySQL connection success");
			// 3. SQL 실행
			String sql = "create table DEPT(\r\n" + 
					"	DEPTNO int(10),\r\n" + 
					"	DNAME varchar(20), LOC varchar(50)" + 
					")";
			Statement stmt = con.createStatement();
			// SELECT 할때는 stmt.executeQuery(sql);
			stmt.executeUpdate(sql);
			
			//4. DB 연결 종료
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}