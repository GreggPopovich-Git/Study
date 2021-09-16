package com.jslhrd.artist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.artist.util.DBManager;
import com.jslhrd.artist.vo.AllVO;

public class JoinDAO {
	
	// 6번 문제 멘토 점수 조회
	public List<AllVO> joinPrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<AllVO> list = new ArrayList<AllVO>();
		// SQL 문장정의
		String sql = "select po.serial_no, art.artist_id, art.artist_name, art.artist_birth, po.point, men.mento_name from tbl_artist_201905 art,tbl_mento_201905 men, tbl_point_201905 po  where art.artist_id = po.artist_id and po.mento_id = men.mento_id order by serial_no";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AllVO vo = new AllVO();
				vo.setSerial_no(rs.getInt("serial_no"));
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setPoint(rs.getInt("point"));
				vo.setMento_name(rs.getString("mento_name"));
				
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
	
	// 6번 문제 멘토 점수 조회
		public List<AllVO> avePrint() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			// 리턴 타입 정의
			List<AllVO> list = new ArrayList<AllVO>();
			// SQL 문장정의
			String sql = "select art.artist_id, art.artist_name, art.artist_gender, sum(point),round(avg(point),2) from tbl_artist_201905 art, tbl_point_201905 po  where art.artist_id = po.artist_id group by art.artist_id, artist_name, artist_gender order by sum(point) desc";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					AllVO vo = new AllVO();
					vo.setArtist_id(rs.getString("artist_id"));
					vo.setArtist_name(rs.getString("artist_name"));
					vo.setArtist_gender(rs.getString("artist_gender"));
					vo.setPoint(rs.getInt("sum(point)"));
					vo.setAgency(rs.getString("round(avg(point),2)"));
					
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
