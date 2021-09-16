package com.jslhrd.artist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.artist.util.DBManager;
import com.jslhrd.artist.vo.ArtistVO;

public class ArtistDAO {
	// 1번 문제 정보입력
	public int insertArtist(ArtistVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_artist_201905(artist_id,artist_name,artist_gender,artist_birth,talent,agency) value(?,?,?,?,?,?)";
		// curdate() - mysql method
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getArtist_id());
			pstmt.setString(2, vo.getArtist_name());
			pstmt.setString(3, vo.getArtist_gender());
			pstmt.setString(4, vo.getArtist_birth());
			pstmt.setString(5, vo.getTalent());
			pstmt.setString(6, vo.getAgency());
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

	// 2번 문제 정보 조회
	public List<ArtistVO> selectArtist() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		List<ArtistVO> list = new ArrayList<ArtistVO>();
		// SQL 문장정의
		String sql = "select * from tbl_artist_201905";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArtistVO vo = new ArtistVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
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
