package com.jslhrd.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.student.util.DBManager;
import com.jslhrd.student.vo.StudentVO;

public class StudentDAO {
	
	// 2번 문제 학생 등록
	public int insertStudent(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) value(?,?,?,?,?,?,?,?,?)";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setString(4, vo.getSname());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getTel1());
			pstmt.setString(8, vo.getTel2());
			pstmt.setString(9, vo.getTel3());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return row;
	}
	// 2번 문제 학생정보 테이블 출력
	public List<StudentVO> selectStudent() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<StudentVO> list = new ArrayList<StudentVO>();
		// SQL 문장정의
		String sql = "select * from tbl_student_201905";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setBirth(rs.getString("birth"));
				vo.setGender(rs.getString("gender"));
				vo.setTel1(rs.getString("tel1"));
				vo.setTel2(rs.getString("tel2"));
				vo.setTel3(rs.getString("tel3"));
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
			} catch (Exception e) {
			}
		}
		return list;
	}
	
	// 4번 문제 학생 정보 삭제
	public void deleteStudent(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "delete from tbl_student_201905 where syear = ? and sclass = ? and sno = ?";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(row == 1)
			System.out.println("학생 정보가 삭제 되었습니다.");
		else
			System.out.println("학생 정보 삭제가 실패했습니다.");
	}
	// 4번 문제 학생 성적 정보 삭제
	public void deleteScore(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "delete from tbl_score_201905 where syear = ? and sclass = ? and sno = ?";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if(row == 1)
			System.out.println("학생 성적 정보가 삭제 되었습니다.");
		else
			System.out.println("학생 성적 정보 삭제가 실패했습니다.");
		deleteStudent(vo);
	}
	// 5번 문제 출력
	public List<StudentVO> deletePrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<StudentVO> list = new ArrayList<StudentVO>();
		// SQL 문장정의
		String sql = "select stu.syear, stu.sclass, stu.sno, stu.sname, stu.gender, sco.kor, sco.eng, sco.mat from tbl_student_201905 stu,tbl_score_201905 sco where stu.syear = sco.syear and stu.sclass = sco.sclass and stu.sno = sco.sno";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setGender(rs.getString("gender"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
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
			} catch (Exception e) {
			}
		}
		return list;
	}

}
