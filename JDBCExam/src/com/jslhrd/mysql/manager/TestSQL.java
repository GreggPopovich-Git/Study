package com.jslhrd.mysql.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestSQL {
	DBManager manager = DBManager.getInstance();
	Connection myConn = null;
	Statement stmt = null; // 일회성
	PreparedStatement pstmt = null; // 여러번 사용가능
	ResultSet rs = null;
	
	// 1. dept 테이블에 등록 메소드 정의
/*	public int deptInsert(int dno, String dname, String loc) {
		String sql = "insert into dept(dno, dname, loc) values(" + dno + ",'" + dname + "','" + loc + "')";
		int row = 0; // 리턴타입
		try {
			myConn = manager.getConnection();
			stmt = myConn.createStatement();
			row = stmt.executeUpdate(sql);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (myConn != null) myConn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
*/
	// 2. DEPT 테이블 전체 목록 검색하여 출력하는 메소드
/*	public void deptList() {
		try {
		String sql = "select * from dept";
		myConn = manager.getConnection();
		stmt = myConn.createStatement();
		rs = stmt.executeQuery(sql);
		System.out.println("부서번호\t부서명\t\t지역명");
		while(rs.next()) {
			System.out.print(rs.getInt("dno") + "\t");
			System.out.print(rs.getString("dname") + "\t\t");
			System.out.print(rs.getString("loc") + "\n");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(myConn != null) myConn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
*/
	public List<DeptVO> deptList() {
		String sql = "select * from dept";
		List<DeptVO> list = new ArrayList<DeptVO>();
		try {
		myConn = manager.getConnection();
		stmt = myConn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			DeptVO vo = new DeptVO();
			vo.setDno(rs.getInt("dno"));
			vo.setDname(rs.getString("dname"));
			vo.setLoc(rs.getString("loc"));
			list.add(vo);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(myConn != null) myConn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int deptInsert(DeptVO vo) {
		String sql = "insert into dept(dno, dname, loc) values(?, ?, ?)";
		int row = 0; // 리턴타입
		try {
			myConn = manager.getConnection();
			pstmt = myConn.prepareStatement(sql);
			pstmt.setInt(1, vo.getDno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(3, vo.getLoc());
			row = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (myConn != null) myConn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}