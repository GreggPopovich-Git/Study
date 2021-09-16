package MySample.model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MySample.util.DBManager;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	// 회원가입
	public int memberInsert(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "insert into tbl_sample_member(userid, pass, name, email, tel) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getTel());
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
	// IDCheck
	public int idcheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		List<String> DBUserid = new ArrayList<String>();
		String sql = "select userid from tbl_sample_member";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DBUserid.add(rs.getString("userid"));
			}
			for(int x = 0; x < DBUserid.size(); x++) {
				if(userid.equals(DBUserid.get(x))) {
					row = 1; // 아이디가 있을때
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row; // 아이디가 있으면 1, 없으면 0
	}
	// last_time update
	public void lastTimeUpdate(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update tbl_sample_member set last_time = sysdate where userid =?";
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 유저 로그인
	public int userLogin(String userid, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0; // 리턴타입
		String sql = "select pass from tbl_sample_member where userid = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (pass.equals(rs.getString("pass"))) {
					sql = "update tbl_sample_member set last_time = sysdate where userid =?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.executeUpdate();
					row = 1; // 로그인 성공
				} else
					row = 0; //비밀번호 틀림
			} else
				row = -1; // 아이디 없음
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
	// 회원 정보 불러오기
	public MemberVO getMember(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = new MemberVO(); // 리턴타입
		String sql = "select * from tbl_sample_member where userid = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setUserid(rs.getString("userid"));
			vo.setName(rs.getString("name"));
			vo.setPass(rs.getString("pass"));
			vo.setTel(rs.getString("tel"));
			vo.setEmail(rs.getString("email"));
			vo.setFirst_time(rs.getString("first_time"));
			vo.setLast_time(rs.getString("last_time"));
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
	// 회원정보 수정
	public int memberModify(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "update tbl_sample_member set name = ?, email = ?, tel = ? where userid = ? and pass = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getUserid());
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
	// IDFind
	public String idfind(String email, String tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userid = "";
		String sql = "select userid from tbl_sample_member where email = ? and tel = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, tel);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userid = rs.getString("userid");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userid; // 아이디가 있으면 1, 없으면 0
	}
	// IDCheck
	public int usercheck(String userid, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String sql = "select pass from tbl_sample_member where userid = ? and email = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = 1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row; // 아이디가 있으면 1, 없으면 0
	}
	// 비밀번호 수정
	public int passModify(String userid, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = DBManager.getConnection();
			String query = "update tbl_sample_member set pass = ? where userid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pass);
			pstmt.setString(2, userid);
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
}
