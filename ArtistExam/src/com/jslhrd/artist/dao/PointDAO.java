package com.jslhrd.artist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.artist.util.DBManager;
import com.jslhrd.artist.vo.PointVO;

public class PointDAO {
	
	// 3번 문제 점수 등록
	public int insertPoint(PointVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_point_201905(serial_no,artist_id,mento_id,point) value(?,?,?,?)";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSerial_no());
			pstmt.setString(2, vo.getArtist_id());
			pstmt.setString(3, vo.getMento_id());
			pstmt.setInt(4, vo.getPoint());
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
	// 3번 문제 점수 정보 출력
	public List<PointVO> selectPoint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<PointVO> list = new ArrayList<PointVO>();
		// SQL 문장정의
		String sql = "select * from tbl_point_201905";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PointVO vo = new PointVO();
				vo.setSerial_no(rs.getInt("serial_no"));
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setMento_id(rs.getString("mento_id"));
				vo.setPoint(rs.getInt("point"));
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
	// 4번 문제 채점 결과 수정
	public int updatePoint(PointVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "update tbl_point_201905 set point = ? where serial_no = ?";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPoint());
			pstmt.setInt(2, vo.getSerial_no());
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
	// 5번 문제 채점 결과 삭제
	public int deletePoint(PointVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "delete from tbl_point_201905 where serial_no = ?";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSerial_no());
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
}
