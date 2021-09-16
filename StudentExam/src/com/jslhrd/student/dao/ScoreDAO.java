package com.jslhrd.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.student.util.DBManager;
import com.jslhrd.student.vo.StudentVO;

public class ScoreDAO {
	
	
	// 3번 문제 학생 점수 입력
	public int insertScore(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_score_201905(syear,sclass,sno,kor,eng,mat) value(?,?,?,?,?,?)";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setInt(4, vo.getKor());
			pstmt.setInt(5, vo.getEng());
			pstmt.setInt(6, vo.getMat());
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
	
	// 3번 문제 학생 점수 출력
	public List<StudentVO> selectScore() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<StudentVO> list = new ArrayList<StudentVO>();
		// SQL 문장정의
		String sql = "select * from tbl_score_201905";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setSno(rs.getString("sno"));
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
	// 6번 문제 출력
	public List<StudentVO> totavePrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<StudentVO> list = new ArrayList<StudentVO>();
		// SQL 문장정의
		String sql = "select de.syear, de.sclass, de.tname, sum(sco.kor) as kor, sum(sco.eng) as eng, sum(sco.mat) as mat, round(avg(sco.kor),1) as korave, round(avg(sco.eng),1) as engave, round(avg(sco.mat),1) as matave from tbl_dept_201905 de, tbl_score_201905 sco where de.syear = sco.syear and de.sclass = sco.sclass group by de.syear, de.sclass, de.tname order by de.tname";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSyear(rs.getString("syear"));
				vo.setSclass(rs.getString("sclass"));
				vo.setTname(rs.getString("tname"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setKorave(rs.getDouble("korave"));
				vo.setEngave(rs.getDouble("engave"));
				vo.setMatave(rs.getDouble("matave"));
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
