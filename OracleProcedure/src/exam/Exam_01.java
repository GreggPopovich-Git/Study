package exam;

import java.sql.CallableStatement;
import java.sql.Connection;

import util.DBUtil;

public class Exam_01 {

	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		// System.out.print(conn);
		String sql = "{call dept_insert(?, ?, ?, ?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, 60);
		cstmt.setString(2, "총무");
		cstmt.setString(3, "서울");
		cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
		cstmt.execute();
		
		int row = cstmt.getInt(4);
		System.out.println(row);
	}

}
