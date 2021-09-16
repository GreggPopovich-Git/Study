package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import vo.member.MemberVO;
import vo.member.ZipVO;

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
			String query = "insert into tbl_member(name, userid, passwd, gubun, zipcode, addr1, addr2, tel, email, job, intro, favorite) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getGubun());
			pstmt.setString(5, vo.getZipcode());
			pstmt.setString(6, vo.getAddr1());
			pstmt.setString(7, vo.getAddr2());
			pstmt.setString(8, vo.getTel());
			pstmt.setString(9, vo.getEmail());
			pstmt.setString(10, vo.getJob());
			pstmt.setString(11, vo.getIntro());
			pstmt.setString(12, vo.getFavorite());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	// 회원 불러오기
	public MemberVO getMember(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = new MemberVO(); // 리턴타입
		String sql = "select * from tbl_member where userid = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setUserid(rs.getString("userid"));
			vo.setName(rs.getString("name"));
			vo.setPasswd(rs.getString("passwd"));
			vo.setGubun(rs.getString("gubun"));
			vo.setZipcode(rs.getString("zipcode"));
			vo.setAddr1(rs.getString("addr1"));
			vo.setAddr2(rs.getString("addr2"));
			vo.setTel(rs.getString("tel"));
			vo.setEmail(rs.getString("email"));
			vo.setFavorite(rs.getString("favorite"));
			vo.setJob(rs.getString("job"));
			vo.setIntro(rs.getString("intro"));
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
			String query = "update tbl_member set passwd = ?, gubun = ?, zipcode = ?, addr1 = ?, addr2 = ?, tel = ?, email = ?, job = ?, intro = ?, favorite = ? where userid = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPasswd());
			pstmt.setString(2, vo.getGubun());
			pstmt.setString(3, vo.getZipcode());
			pstmt.setString(4, vo.getAddr1());
			pstmt.setString(5, vo.getAddr2());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getJob());
			pstmt.setString(9, vo.getIntro());
			pstmt.setString(10, vo.getFavorite());
			pstmt.setString(11, vo.getUserid());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	// 리스트 출력
	public List<MemberVO> memberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> mList = new ArrayList<MemberVO>(); // 리턴타입
		String sql = "select * from tbl_member";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setFirst_time(rs.getString("first_time"));
				vo.setLast_time(rs.getString("last_time"));
				mList.add(vo);
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
				e.printStackTrace();
			}
		}
		return mList;
	}

	// ID 중복체크
	public int idCheck(String userid) {
		int row = 0;
		List<MemberVO> mList = memberList();
		for (int x = 0; x < mList.size(); x++) {
			if (userid.equals(mList.get(x).getUserid())) {
				row = 1;
			}
		}
		return row;
	}

	// 우편번호 검색
	public List<ZipVO> zipList(String addr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ZipVO> list = new ArrayList<ZipVO>(); // 리턴타입
		String sql = "select * from zipcode where dong like '%" + addr + "%'";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipVO zip = new ZipVO();
				zip.setZipcode(rs.getString("zipcode"));
				zip.setSido(rs.getString("sido"));
				zip.setGugun(rs.getString("gugun"));
				zip.setDong(rs.getString("dong"));
				zip.setBunji(rs.getString("bunji"));
				list.add(zip);
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
				e.printStackTrace();
			}
		}
		return list;
	}

	// 유저 로그인
	public int userLogin(String userid, String userpw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0; // 리턴타입
		String sql = "select passwd from tbl_member where userid = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (userpw.equals(rs.getString("passwd"))) {
					sql = "update tbl_member set last_time = sysdate where userid =?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.executeUpdate();
					row = 1;
				} else
					row = 0;
			} else
				row = -1;
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
				e.printStackTrace();
			}
		}
		return row;
	}

	// 리스트 검색
	public List<MemberVO> searchList(String search_gubun, String search) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> sList = new ArrayList<MemberVO>(); // 리턴타입
		String sql = "select * from tbl_member where " + search_gubun + " like '%" + search + "%'";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setFirst_time(rs.getString("first_time"));
				vo.setLast_time(rs.getString("last_time"));
				sList.add(vo);
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
				e.printStackTrace();
			}
		}
		return sList;
	}
}
