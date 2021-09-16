package exam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import util.DBUtil;

public class Exam_fn_02 {

	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		// 입력전 카운트
		String sql = "{? = call fn_count}";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		cstmt.execute();
		int precount = cstmt.getInt(1);
		// 키보드 입력
		Scanner scn = new Scanner(System.in);
		System.out.println("사용자 등록 화면");
		System.out.print("부서 번호 : ");
		int dno = scn.nextInt();
		System.out.print("부서 이름 : ");
		String dname = scn.next();
		System.out.print("지역명 : ");
		String loc = scn.next();
		// 데이터베이스 입력
		sql = "{? = call fn_insert(?, ?, ?)}";
		cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		cstmt.setInt(2, dno);
		cstmt.setString(3, dname);
		cstmt.setString(4, loc);
		cstmt.execute();
		// 입력 후 카운트
		sql = "{? = call fn_count}";
		cstmt = conn.prepareCall(sql);
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		cstmt.execute();
		int count = cstmt.getInt(1);
		if (count > precount)
			System.out.println("등록되었습니다.");
		else
			System.out.println("등록에 실패했습니다.");
		scn.close();
	}

}
