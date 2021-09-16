package smart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smart.util.DBManager;
import smart.vo.SmartVO;

public class SmartDao {
	private SmartDao() {}
	private static SmartDao instance = new SmartDao();
	public static SmartDao getInstance() {
		return instance;
	}
	
	// 1번문제
	public List<SmartVO> exma_01() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SmartVO> eList = new ArrayList<SmartVO>();
		String query = "select * from tbl_product_201909";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SmartVO v = new SmartVO();
				v.setP_code(rs.getString(1));
				v.setP_name(rs.getString(2));
				v.setP_size(rs.getString(3));
				v.setP_type(rs.getString(4));
				v.setP_price(rs.getInt(5));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 2번문제
	public List<SmartVO> exma_02() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SmartVO> eList = new ArrayList<SmartVO>();
		String query = "select w.w_workno,w.p_code,p.p_name,p.p_size,p.p_type,w.w_quentity,to_char(w.w_workdate,'YYYY-MM-DD') from tbl_product_201909 p, tbl_worklist_201909 w where p.p_code = w.p_code";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SmartVO v = new SmartVO();
				v.setW_workno(rs.getString(1));
				v.setP_code(rs.getString(2));
				v.setP_name(rs.getString(3));
				v.setP_size(rs.getString(4));
				v.setP_type(rs.getString(5));
				v.setW_quentity(rs.getString(6));
				v.setW_workdate(rs.getString(7));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 3번문제 입력
	public int exam_03_1(SmartVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		String sql = "insert into tbl_process_201909 values (?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getW_workno());
			pstmt.setString(2, vo.getP_p1());
			pstmt.setString(3, vo.getP_p2());
			pstmt.setString(4, vo.getP_p3());
			pstmt.setString(5, vo.getP_p4());
			pstmt.setString(6, vo.getP_p5());
			pstmt.setString(7, vo.getP_p6());
			pstmt.setString(8, vo.getW_lastdate());
			pstmt.setString(9, vo.getW_lasttime());
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
	// 3번문제 인쇄
	public List<SmartVO> exam_03_2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SmartVO> eList = new ArrayList<SmartVO>();
		String query = "select * from tbl_process_201909";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SmartVO v = new SmartVO();
				v.setW_workno(rs.getString(1));
				v.setP_p1(rs.getString(2));
				v.setP_p2(rs.getString(3));
				v.setP_p3(rs.getString(4));
				v.setP_p4(rs.getString(5));
				v.setP_p5(rs.getString(6));
				v.setP_p6(rs.getString(7));
				v.setW_lastdate(rs.getString(8));
				v.setW_lasttime(rs.getString(9));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 4번문제
	public List<SmartVO> exam_04() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SmartVO> eList = new ArrayList<SmartVO>();
		String query = "select pc.w_workno,pd.p_code,pd.p_name,decode(pc.p_p1, 'Y', '완료', 'N', '~'),\r\n" + 
				"decode(pc.p_p2, 'Y', '완료', 'N', '~'),decode(pc.p_p3, 'Y', '완료', 'N', '~'),\r\n" + 
				"decode(pc.p_p4, 'Y', '완료', 'N', '~'),decode(pc.p_p5, 'Y', '완료', 'N', '~'),\r\n" + 
				"decode(pc.p_p6, 'Y', '완료', 'N', '~'),to_char(to_date(pc.w_lastdate), 'YYYY-MM-DD'),to_char(to_date(pc.w_lasttime,'HH24MI'), 'HH24:MI') \r\n" + 
				"from tbl_product_201909 pd, tbl_process_201909 pc, tbl_worklist_201909 w \r\n" + 
				"where pd.p_code = w.p_code and w.w_workno = pc.w_workno";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SmartVO v = new SmartVO();
				v.setW_workno(rs.getString(1));
				v.setP_code(rs.getString(2));
				v.setP_name(rs.getString(3));
				v.setP_p1(rs.getString(4));
				v.setP_p2(rs.getString(5));
				v.setP_p3(rs.getString(6));
				v.setP_p4(rs.getString(7));
				v.setP_p5(rs.getString(8));
				v.setP_p6(rs.getString(9));
				v.setW_lastdate(rs.getString(10));
				v.setW_lasttime(rs.getString(11));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
}
