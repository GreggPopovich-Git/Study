package oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.util.DBManager;
import oracle.vo.VO;

public class DAO2 {
	private DAO2() {}
	private static DAO2 instance = new DAO2();
	public static DAO2 getInstance() {
		return instance;
	}
	// 1번 문제
	public List<VO> exam_1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select max(salary) Max, min(salary) Min, sum(salary) Sum, round(avg(salary)) from emp";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setEno(rs.getInt(1));
				v.setSalary(rs.getInt(2));
				v.setSum(rs.getInt(3));
				v.setTot(rs.getInt(4));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 2번 문제
	public List<VO> exam_2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select job, max(salary) Max, min(salary) Min, sum(salary) Sum, round(avg(salary),0) Avg from emp group by job";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setJob(rs.getString(1));
				v.setEno(rs.getInt(2));
				v.setSalary(rs.getInt(3));
				v.setSum(rs.getInt(4));
				v.setTot(rs.getInt(5));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 3번 문제
	public List<VO> exam_3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select job, count(*) cnt from emp group by job";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setJob(rs.getString(1));
				v.setEno(rs.getInt(2));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 4번 문제
	public List<VO> exam_4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select count(manager) mcnt from emp";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setEno(rs.getInt(1));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 5번 문제
	public List<VO> exam_5() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select max(salary) - min(salary) diff from emp";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setEno(rs.getInt(1));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 6번 문제
	public List<VO> exam_6() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select job, min(salary) Min from emp group by job having not min(salary) < 2000 order by min(salary) desc";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setJob(rs.getString(1));
				v.setEno(rs.getInt(2));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 7번 문제
	public List<VO> exam_7() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select dno, count(*) cnt, round(avg(salary),2) Avg from emp group by dno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setDno(rs.getInt(1));
				v.setEno(rs.getInt(2));
				v.setSalary(rs.getInt(3));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 8번 문제
	public List<VO> exam_8() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select decode(dno, 10, 'ACCOUNTING',\r\n" + "				   20, 'RESEARCH',\r\n"
				+ "				   30, 'SALES',\r\n" + "				   40, 'OPERATIONS') dname,\r\n"
				+ "	   decode(dno, 10, 'NEW YORK',\r\n" + "	   			   20, 'DALLAS',\r\n"
				+ "	   			   30, 'CHICAGO',\r\n" + "	   			   40, 'BOSTON') loc,\r\n"
				+ "	   count(*) cnt, round(avg(salary)) sal from emp group by dno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setJob(rs.getString(2));
				v.setDno(rs.getInt(3));
				v.setSalary(rs.getInt(4));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 9번 문제
	public List<VO> exam_9() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select job, dno, decode(dno, 10, sum(salary)) d10,\r\n"
				+ "				 decode(dno, 20, sum(salary)) d20,\r\n"
				+ "				 decode(dno, 30, sum(salary)) d30,\r\n"
				+ "				 sum(salary) tot from emp group by job, dno order by dno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setJob(rs.getString(1));
				v.setDno(rs.getInt(2));
				v.setSalary(rs.getInt(3));
				v.setSum(rs.getInt(4));
				v.setTot(rs.getInt(5));
				v.setManager(rs.getInt(6));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
}
