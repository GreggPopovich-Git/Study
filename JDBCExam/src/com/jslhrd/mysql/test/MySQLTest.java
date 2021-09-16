package com.jslhrd.mysql.test;

import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLTest extends MySQLConn {
	Statement stmt = null;
	ResultSet rs = null;
	
	public MySQLTest() {
		super();
	}
	// 등록메소드 정의
	public int insertDept(int dno, String dname, String loc) throws Exception {
		String sql = "insert into dept(dno, dname, loc) values(" + dno + ",'" + dname + "','" + loc + "')";
		stmt = myConn.createStatement();
		int row = stmt.executeUpdate(sql);
		return row;
	}
	// 출력메소드 정의
	public void listDept() throws Exception {
		String sql = "select * from dept";
		stmt = myConn.createStatement();
		rs = stmt.executeQuery(sql);
		System.out.println("부서번호\t부서명\t\t지역명");
		while(rs.next()) {
			System.out.print(rs.getInt("dno") + "\t");
			System.out.print(rs.getString("dname") + "\t\t");
			System.out.print(rs.getString("loc") + "\n");
		}
	}
	// 수정메소드 정의
	public int updateDept(int dno) throws Exception {
		
		int row = 0;
		return row;
	}
	// 삭제메소드 정의
	public int deleteDept(int dno) throws Exception {
		String sql = "delete from dept where dno = " + dno;
		stmt = myConn.createStatement();
		int row = stmt.executeUpdate(sql);
		return row;
	}
	@Override
	public void cleanup() throws Exception {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		
	}

}