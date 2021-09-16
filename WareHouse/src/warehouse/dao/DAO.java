package warehouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import warehouse.util.DBManager;
import warehouse.vo.VO;

public class DAO {
	private DAO() {}
	private static DAO instance = new DAO();
	public static DAO getInstance() {
		return instance;
	}
	// 2번문제 출력
	public List<VO> exam_02() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select p_code, p_name, to_char(p_size) || 'mm', \r\n" + 
				"LPAD(to_char(p_incost, 'FML999,999'), 8), LPAD(to_char(p_outcost, 'FML999,999'), 8) \r\n" + 
				"from tbl_product_202002";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setP_code(rs.getString(1));
				v.setP_name(rs.getString(2));
				v.setC_name(rs.getString(3));
				v.setTel1(rs.getString(4));
				v.setTel2(rs.getString(5));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 문제 3번 정보 입력
	public int exam_03(VO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		String sql = "insert into tbl_inout_202002 values (?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getT_no());
			pstmt.setString(2, vo.getP_code());
			pstmt.setString(3, vo.getT_type());
			pstmt.setInt(4, vo.getT_cnt());
			pstmt.setString(5, vo.getT_date());
			pstmt.setString(6, vo.getC_code());
			row = pstmt.executeUpdate();
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
			} catch (Exception e) {}
		}
		return row;
	}
	// 문제 3 max 값 가져오기
	public int getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select max(t_no) + 1 from tbl_inout_202002";
		int max = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				max = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return max;
	}
	// 문제 4번 정보 출력
	public List<VO> exam_04() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select t_no, p.p_code, p_name, decode(t_type, 'O', '출고', 'I', '입고'), t_cnt, c_name, to_char(t_date, 'YYYY-MM-DD') \r\n" + 
				"from tbl_product_202002 p, tbl_company_202002 c, tbl_inout_202002 i \r\n" + 
				"where p.p_code = i.p_code and i.c_code = c.c_code order by t_no";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setT_no(rs.getString(1));
				v.setP_code(rs.getString(2));
				v.setP_name(rs.getString(3));
				v.setT_type(rs.getString(4));
				v.setT_cnt(rs.getInt(5));
				v.setC_name(rs.getString(6));
				v.setT_date(rs.getString(7));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 문제 5번 삭제
	public int exam_05(String t_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		String sql = "delete from tbl_inout_202002 where t_no = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t_no);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		return row;
	}
	// 6번문제 통계 출력
	public List<VO> exam_06() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select p.p_code, p_name, t_cnt, LPAD(to_char((t_cnt * (p_outcost - p_incost)), 'FML999,999'), 11) \r\n" + 
				"from tbl_product_202002 p, tbl_inout_202002 i \r\n" + 
				"where p.p_code = i.p_code and t_type = 'O'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setP_code(rs.getString(1));
				v.setP_name(rs.getString(2));
				v.setT_cnt(rs.getInt(3));
				v.setTel1(rs.getString(4));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	
}
