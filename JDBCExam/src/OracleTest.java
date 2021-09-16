import java.sql.Connection;
import java.sql.DriverManager;

/* 	SQL - 관계형 데이터 베이스 - MySQL, Oracle, MS SQL
	noSQL - 행렬구조가 없는 구조 - 키 + 값의 형태로 저장

	JDBC Driver(Connector) - DB 시스템사에서 제공 (11g) API
*/
public class OracleTest {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver Loading.....");
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","ehfkdl12");
			System.out.println("Oracle Connection pool");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}