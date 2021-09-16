package model.gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class GalleryDAO {
	private GalleryDAO() {}
	private static GalleryDAO instance = new GalleryDAO();
	public static GalleryDAO getInstance() {
		return instance;
	}
	
	// 전체 갤러리 카운트 메소드(검색없음)
	public int galleryCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="select count(*) from tbl_sample_gallery";
		int row=0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()){
				row=rs.getInt(1);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return row;
	}
	// 전체 갤러리 카운트 메소드(검색추가)
	public int galleryCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from tbl_sample_gallery where " + s_query;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	// 전체 갤러리 게시글 목록(검색없음, 페이지 추가)
	public List<GalleryVO> galleryList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GalleryVO> list = new ArrayList<GalleryVO>();
		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_sample_gallery order by idx desc) A where rownum <= ?) X where X.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GalleryVO vo = new GalleryVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	// 전체 갤러리 게시글 목록(검색추가, 페이지 추가)
	public List<GalleryVO> galleryList(String s_query, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GalleryVO> list = new ArrayList<GalleryVO>();
		String query = "select X.* from (select rownum as rnum, A.* from (select * from tbl_sample_gallery order by idx desc) A where "
				+ s_query + " and rownum <= ?) X where " + s_query + " and X.rnum >= ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GalleryVO vo = new GalleryVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContents(rs.getString("contents"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcnt(rs.getInt("readcnt"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	// 갤러리 등록 메소드
	public int galleryWrite(GalleryVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		String query = "insert into tbl_sample_gallery(idx, name, userid, pass, subject, contents, type) values(tbl_sample_gallery_seq_idx.nextval,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPass());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getContents());
			pstmt.setString(6, vo.getType());
			row = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	// 게시글 불러오기
	public GalleryVO getGallery(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GalleryVO vo = new GalleryVO(); // 리턴타입
		String sql = "select * from tbl_sample_gallery where idx = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setName(rs.getString("name"));
			vo.setPass(rs.getString("pass"));
			vo.setSubject(rs.getString("subject"));
			vo.setContents(rs.getString("contents"));
			vo.setRegdate(rs.getString("regdate"));
			vo.setReadcnt(rs.getInt("readcnt"));
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
	// 조회수증가
	public void GalleryHit(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update tbl_sample_gallery set readcnt = readcnt + 1 where idx = ?";
		try {
			conn = DBManager.getConnection();
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
	// 게시글 수정
	public int galleryModify(GalleryVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "select pass from tbl_sample_gallery where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getIdx());
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString("pass").equals(vo.getPass())) {
				String query = "update tbl_sample_gallery set name = ?, subject = ?, contents = ? where idx = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getSubject());
				pstmt.setString(3, vo.getContents());
				pstmt.setInt(4, vo.getIdx());
				row = pstmt.executeUpdate();
			} else {
				row = -3; // 비밀번호 틀림
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
		return row;
	}
	// 게시글 삭제
	public int galleryDelete(int idx, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "select pass from tbl_sample_gallery where idx = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			if (pass.equals(rs.getString("pass"))) {
				query = "delete from tbl_sample_gallery where idx = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				pstmt.executeUpdate();
				row = 1; // 삭제 되었을때
			} else {
				row = 0; // 비밀번호 틀림
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
		return row;
	}
}
