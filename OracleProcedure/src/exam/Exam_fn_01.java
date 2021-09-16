package exam;

import java.sql.CallableStatement;
import java.sql.Connection;

import util.DBUtil;

public class Exam_fn_01 {

	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "{? = call fn_salary_ename(?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		cstmt.setString(2, "KING");
		
		cstmt.execute();
		
		int salary = cstmt.getInt(1);
		System.out.println("KING : " + salary);
		
	}

}
