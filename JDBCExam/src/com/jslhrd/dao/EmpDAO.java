package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.util.DBManager;
import com.jslhrd.vo.EmpVO;

public class EmpDAO {
	private EmpDAO() {
	}

	private static EmpDAO instance = new EmpDAO();

	public static EmpDAO getInstance() {
		return instance;
	}

	// emp 테이블 전체 목록 구하기
	public List<EmpVO> empList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<EmpVO> eList = new ArrayList<EmpVO>();
		// SQL 문장정의
		String sql = "select * from emp";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEno(rs.getInt("eno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setHiredate(rs.getString("hiredate"));
				vo.setManager(rs.getInt("manager"));
				vo.setSalary(rs.getInt("salary"));
				vo.setCommission(rs.getInt("commission"));
				vo.setDno(rs.getInt("dno"));
				eList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return eList;
	}
	// emp 테이블 정보 삽입
	public int empInsert(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into emp(eno,ename,hiredate,salary,dno) value(?,?,?,?,?)";
		// curdate() - mysql method
		LocalDate date = LocalDate.now();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, date.toString());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setInt(5, vo.getDno());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return row;
	}
	// emp 테이블 사원번호를 이용한 검색
	public EmpVO empSearch(int eno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		EmpVO vo = new EmpVO();
		// SQL 문장정의
		String sql = "select * from emp where eno = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo.setEno(rs.getInt("eno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setHiredate(rs.getString("hiredate"));
				vo.setManager(rs.getInt("manager"));
				vo.setSalary(rs.getInt("salary"));
				vo.setCommission(rs.getInt("commission"));
				vo.setDno(rs.getInt("dno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return vo;
	}
	// emp 테이블 정보 수정
	public int empUpdate(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "update emp set ename = ?, job = ?, manager = ?, salary = ?, commission = ? where eno = ?";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEname());
			pstmt.setString(2, vo.getJob());
			pstmt.setInt(3, vo.getManager());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setInt(5, vo.getCommission());
			pstmt.setInt(6, vo.getEno());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return row;
	}
	// emp 테이블 정보 삭제
	public int empDelete(int eno) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "delete from emp where eno = ?";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return row;
	}
	// emp, dept 테이블 조인 부서명 출력
	public List<EmpVO> empDeptList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<EmpVO> list = new ArrayList<EmpVO>();
		// SQL 문장정의
		String sql = "select eno, ename, hiredate, salary, e.dno, dname from emp e, dept d where e.dno = d.dno";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEno(rs.getInt("eno"));
				vo.setEname(rs.getString("ename"));
				vo.setHiredate(rs.getString("hiredate"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDname(rs.getString("dname"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return list;
	}
}
