package exam;

import java.sql.CallableStatement;
import java.sql.Connection;

import util.DBUtil;

public class Exam_02 {

	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		// System.out.print(conn);
		String sql = "{call sp_salary(?, ?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, "KING");
		cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
		cstmt.execute();
		
		int salary = cstmt.getInt(2);
		System.out.println("KING의 급여는 " + salary);
		
	}

}
