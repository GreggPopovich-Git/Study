package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import vo.VO;

public class DAO {
	private DAO() {
	}

	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}
	// 2번문제
	public List<VO> custList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO> list = new ArrayList<VO>();
		String query = "select p_no, p_name, p_birth, decode(p_gender, 'M', '남', 'F', '여'), p_tel1 || '-' || p_tel2 || '-' || p_tel3, \r\n"
				+ "decode(p_city, '10', '서울', '20', '경기', '30', '강원', '40', '대구') from tbl_cust_201004";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			VO vo = null;
			while (rs.next()) {
				vo = new VO();
				vo.setP_no(rs.getString(1));
				vo.setP_name(rs.getString(2));
				vo.setP_birth(rs.getString(3));
				vo.setP_gender(rs.getString(4));
				vo.setP_tel1(rs.getString(5));
				vo.setP_city(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
		}
		return list;
	}

	// 문제 3번 등록
	public int orderInsert(VO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_order_201004 values (?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_seno());
			pstmt.setString(2, vo.getP_no());
			pstmt.setString(3, vo.getI_code());
			pstmt.setString(4, vo.getP_date());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
		}
		return row;
	}
	// 4번 문제
	public List<VO> orderList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO> list = new ArrayList<VO>();
		String query = "select substr(to_char(p_seno), 0, 4) || '-' || substr(to_char(p_seno), 5) , c.p_no, p_name, o.i_code, i_name, to_char(p_date, 'YYYY-MM-DD') \r\n" + 
				"from tbl_cust_201004 c, tbl_order_201004 o, tbl_injection_201004 i \r\n" + 
				"where c.p_no = o.p_no and o.i_code = i.i_code order by p_seno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			VO vo = null;
			while (rs.next()) {
				vo = new VO();
				vo.setP_city(rs.getString(1));
				vo.setP_no(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setI_code(rs.getString(4));
				vo.setI_name(rs.getString(5));
				vo.setP_date(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
		}
		return list;
	}
	// 5번 문제
	public List<VO> countList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO> list = new ArrayList<VO>();
		String query = "select o.i_code, i_name, c from \r\n" + 
				"(select i_code, count(i_code) c from tbl_order_201004 group by i_code) o, \r\n" + 
				"tbl_injection_201004 i where i.i_code = o.i_code order by i_code";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			VO vo = null;
			while (rs.next()) {
				vo = new VO();
				vo.setI_code(rs.getString(1));
				vo.setI_name(rs.getString(2));
				vo.setP_seno(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
		}
		return list;
	}
}
