package mysql;
// ANSI 표준
/* DDL(정의) - CREATE, ALTER, DROP
 * DML(조작) - SELECT, INSERT, UPDATE, DELETE
 * DCL(제어) - GRANT, REVOKE
 * TCL(트렌잭션) - COMMIT, ROLLBACK, SAVEPOINT
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam_02_Select {

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
			String sql = "select * from test";
			Statement stmt = con.createStatement();
			// SELECT 할때는 stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("번호\t이름\t생일\t\t나이");
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				int age = rs.getInt("age");
				System.out.println(idx + "\t" + name + "\t" + birth + "\t" + age);
			}
			//4. DB 연결 종료
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}