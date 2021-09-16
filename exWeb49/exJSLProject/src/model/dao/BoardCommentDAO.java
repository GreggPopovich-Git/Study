package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.vo.BoardCommentVO;
import util.DBManager;

public class BoardCommentDAO {
	private BoardCommentDAO() {}
	private static BoardCommentDAO instance = new BoardCommentDAO();
	public static BoardCommentDAO getInstance() {
		return instance;
	}
	
	// 댓글 수 검색
	public int commentCount(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0; // 리턴타입
		String sql = "select count(*) from tbl_board_comment_49 where idx = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	// 게시글 등록 메소드
	public int commentWrite(BoardCommentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "insert into tbl_board_comment_49(coidx, name, pass, contents, idx) values(tbl_board_comment_49_seq_coidx.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIdx());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 전체 목록(검색x, 페이지처리o)
	public List<BoardCommentVO> boardCommentList(int startpage, int endpage, String sort, int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardCommentVO> cList = new ArrayList<BoardCommentVO>(); // 리턴타입
		String sql = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board_comment_49 where idx = ? " + sort + ") A where rownum <= ?) X where X.rnum >= ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, endpage);
			pstmt.setInt(3, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardCommentVO vo = new BoardCommentVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setContents(rs.getString("contents").replace("\n", "<br>"));
				cList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cList;
	}
}
