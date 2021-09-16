package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.MySQLManager;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}

	// 게시글 총수 카운트 메소드()
	public int boardCount() {
		String query = "select count(*) from tbl_board";
		int row = 0; // 리턴 타입
		try {
			conn = MySQLManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 게시판 전체 목록 검색 (list)
	public List<BoardVO> boardList() {
		List<BoardVO> bList = new ArrayList<BoardVO>(); // 리턴타입
		String sql = "select * from tbl_board order by idx desc";

		try {
			conn = MySQLManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				bList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	// 게시판 글쓰기 (write)
	public int write(BoardVO vo) {
		int row = 0;
		try {
			conn = MySQLManager.getConnection();
			String query = "insert into tbl_board(name, email, pass, subject, contents, regdate) values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPass());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			pstmt.setDate(6, sqlDate);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt);
		}
		return row;
	}

	// 게시물 조회 (view)
	public BoardVO view(int idx) {
		BoardVO vo = new BoardVO(); // 리턴타입
		conn = MySQLManager.getConnection();
		// 1.조회수 증가
		String sql = "update tbl_board set readcnt = readcnt + 1 where idx = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 2.게시물 조회
		sql = "select * from tbl_board where idx = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setName(rs.getString("name"));
			vo.setEmail(rs.getString("email"));
			vo.setSubject(rs.getString("subject"));
			vo.setContents(rs.getString("contents"));
			vo.setRegdate(rs.getString("regdate"));
			vo.setReadcnt(rs.getInt("readcnt"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	// 게시물 수정(modify)
	// 수정하기
	public int modify(BoardVO vo) {
		int row = 0;
		try {
			conn = MySQLManager.getConnection();
			String query = "update tbl_board set email=?,subject=?,contents=? where idx=? and pass=?";
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
			MySQLManager.close(conn, pstmt);
		}
		return row;
	}

	// 게시물 수정(modify)
	// 불러오기
	public BoardVO modify(int idx) {
		BoardVO vo = new BoardVO();
		try {
			conn = MySQLManager.getConnection();
			String query = "select * from tbl_board where idx = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				rs.next();
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPass(rs.getString("pass"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MySQLManager.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 검색시 게시글 수
	public int boardCount(String s_query) {
		int row = 0; // 리턴타입
		String sql = "select count(*) from tbl_board where " + s_query;

		try {
			conn = MySQLManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 검색시 게시물 조회
	public List<BoardVO> boardList(String s_query) {
		List<BoardVO> bList = new ArrayList<BoardVO>(); // 리턴타입
		String sql = "select * from tbl_board where + " + s_query + " order by idx desc";
		try {
			conn = MySQLManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			BoardVO vo = null;
			while (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				bList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	// 게시판 페이지별 목록 (페이지 인덱스 추가, 검색 x)
	// public List<BoardVO> boardList(int startpage, int endpage) { -- 오라클
	public List<BoardVO> boardList(int pagestart, int maxlist) {
		List<BoardVO> bList = new ArrayList<BoardVO>(); // 리턴타입
		String sql = "select * from tbl_board order by idx desc limit ?,?";
		try {
			conn = MySQLManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagestart);
			pstmt.setInt(2, maxlist);
			rs = pstmt.executeQuery();
			BoardVO vo = null;
			while (rs.next()) {
				vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				bList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	// 게시판 전체 목록 검색(페이지 인덱스 + 검색기능 추가)
	public List<BoardVO> boardList(String s_query, int pagestart, int maxlist) {
		List<BoardVO> bList = new ArrayList<BoardVO>(); // 리턴타입
		String sql = "select * from tbl_board where " + s_query + " order by idx desc limit ?,?";
		try {
			conn = MySQLManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagestart);
			pstmt.setInt(2, maxlist);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				bList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		return bList;
	}

	// 회원정보 삭제
	public int delete(int idx, String pass) {
		int row = 0;
		int flag = 0;
		// 비밀번호 비교
		try {
			conn = MySQLManager.getConnection();
			String query = "select pass from tbl_board where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			if (pass.equals(rs.getString("pass")))
				flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLManager.close(conn, pstmt, rs);
		}
		// 삭제
		if (flag == 1) {
			try {
				conn = MySQLManager.getConnection();
				String query = "delete from tbl_board where idx = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				row = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				MySQLManager.close(conn, pstmt);
			}
			return row;
		} else {
			return -1;
		}
	}
}