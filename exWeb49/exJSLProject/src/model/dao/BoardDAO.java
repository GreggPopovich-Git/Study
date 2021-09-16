package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.vo.BoardVO;
import util.DBManager;


public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	// 전체 게시글 수 검색
	public int boardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0; // 리턴타입
		String sql = "select count(*) from tbl_board_49";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	public int boardWrite(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "insert into tbl_board_49(idx, userid, name, pass, email, subject, contents) values(tbl_board_49_seq_idx.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPass());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getSubject());
			pstmt.setString(6, vo.getContents());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 전체 목록(검색x, 페이지처리o)
	public List<BoardVO> boardList(int startpage, int endpage, String sort) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> bList = new ArrayList<BoardVO>(); // 리턴타입
		String sql = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board_49 " + sort + ") A where rownum <= ?) X where X.rnum >= ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				bList.add(vo);
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
		return bList;
	}
	// 전체 목록(검색o, 페이지처리o)
	public List<BoardVO> boardList(String s_query, int startpage, int endpage, String sort) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> bList = new ArrayList<BoardVO>(); // 리턴타입
		String sql = "select X.* from (select rownum as rnum, A.* from (select * from tbl_board_49 " + sort + ") A where "
				+ s_query + " and rownum <= ?) X where " + s_query + " and X.rnum >= ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				bList.add(vo);
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
		return bList;
	}
	// 검색 게시글 수 카운트
	public int boardCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0; // 리턴타입
		String sql = "select count(*) from tbl_board_49 where " + s_query;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	// 게시물 조회 (view)
	// 1.조회수 증가
	public void boardHit(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBManager.getConnection();
		String sql = "update tbl_board_49 set readcnt = readcnt + 1 where idx = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 2. 게시글 불러오기
	public BoardVO boardView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = new BoardVO(); // 리턴타입
		conn = DBManager.getConnection();
		// 2.게시물 조회
		String sql = "select * from tbl_board_49 where idx = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				vo.setLikecnt(rs.getInt("likecnt"));
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
		return vo;
	}
	// 게시물 수정(modify)
	public int boardModify(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "update tbl_board_49 set email=?, subject=?, contents=? where idx=? and pass=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getContents());
			pstmt.setInt(4, vo.getIdx());
			pstmt.setString(5, vo.getPass());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	// 게시물 삭제
	public int boardDelete(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		int flag = 0;
		try {
			conn = DBManager.getConnection();
			String query = "select pass from tbl_board_49 where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			if (pass.equals(rs.getString("pass")))
				flag = 1; // 비밀번호 맞음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 삭제
		if (flag == 1) { // 비밀번호가 맞았을 때
			try {
				conn = DBManager.getConnection();
				String query = "delete from tbl_board_49 where idx = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				row = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		return row;
	}
	// 좋아요 개수 수정
	public void likeCntUp(int likecnt, int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			String query = "update tbl_board_49 set likecnt=? where idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, likecnt);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 댓글 쓰기
	public int boardReply(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "insert into tbl_board_49(idx, userid, name, pass, email, subject, contents, reply) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 100000+vo.getIdx());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPass());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getSubject());
			pstmt.setString(7, vo.getContents());
			pstmt.setInt(8, vo.getReply());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
}
