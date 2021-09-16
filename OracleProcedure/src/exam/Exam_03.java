package exam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import util.DBUtil;

public class Exam_03 {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		System.out.print("사번입력 : ");
		int num = scn.nextInt();
		Connection conn = DBUtil.getConnection();
		// System.out.print(conn);
		String sql = "{call emp_name_search(?, ?, ?, ?, ?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, num);
		cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(3, java.sql.Types.DATE);
		cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
		cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
		cstmt.execute();

		String ename = cstmt.getString(2);
		String date = cstmt.getString(3);
		int salary = cstmt.getInt(4);
		String job = cstmt.getString(5);
		System.out.println("사번\t이름\t입사일자\t\t급여\t업무명");
		System.out.print(num + "\t");
		System.out.print(ename + "\t");
		System.out.print(date.substring(0, 10) + "\t");
		System.out.print(salary + "\t");
		System.out.print(job + "\t");
		scn.close();
	}
}
