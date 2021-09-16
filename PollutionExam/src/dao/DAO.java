package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import vo.VO;

public class DAO {
	private DAO() {}
	private static DAO instance = new DAO();
	public static DAO getInstance() {
		return instance;
	}
	// 2번 문제
	public List<VO> exam_2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select city_code, city_name, c.area_code, area_name, city_tel1 || '-' || city_tel2 || '-' || city_tel3, city_admin, decode(city_level, '1', '사원', '2', '주임', '3', '대리', '4', '과장') \r\n" + 
				"from tbl_city_202005 c, tbl_area_202005 a where c.area_code = a.area_code";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setCity_code(rs.getString(1));
				v.setCity_name(rs.getString(2));
				v.setArea_code(rs.getString(3));
				v.setArea_name(rs.getString(4));
				v.setCity_tel1(rs.getString(5));
				v.setCity_admin(rs.getString(6));
				v.setCity_level(rs.getString(7));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 3번 문제
	public int exam_3(VO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		String sql = "insert into tbl_test_202005 values(?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTest_date());
			pstmt.setString(2, vo.getTest_ampm());
			pstmt.setString(3, vo.getPollution());
			pstmt.setString(4, vo.getCity_code());
			pstmt.setInt(5, vo.getTest_value());
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
	// 4번 문제
	public List<VO> exam_4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select substr(test_date,0,4) || '년' || substr(test_date,5,2) || '월' || substr(test_date,7,2) || '일', \r\n" + 
				"decode(test_ampm, 'AM', '오전', 'PM', '오후'), pollution, t.city_code, city_name, area_name, test_value \r\n" + 
				"from tbl_test_202005 t, tbl_city_202005 c, tbl_area_202005 a \r\n" + 
				"where t.city_code = c.city_code and c.area_code = a.area_code";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setTest_date(rs.getString(1));
				v.setTest_ampm(rs.getString(2));
				v.setPollution(rs.getString(3));
				v.setCity_code(rs.getString(4));
				v.setCity_name(rs.getString(5));
				v.setArea_name(rs.getString(6));
				v.setTest_value(rs.getInt(7));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 5번 문제
	public List<VO> exam_5() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select substr(test_date,0,4) || '년' || substr(test_date,5,2) || '월' || substr(test_date,7,2) || '일', city_name, avg(test_value), \r\n" + 
				"case when avg(test_value) > 150 then '매우나쁨' \r\n" + 
				"	 when avg(test_value) > 80 then '나쁨' \r\n" + 
				"	 when avg(test_value) > 30 then '보통'\r\n" + 
				"	 else '좋음' end as test\r\n" + 
				"from tbl_test_202005 t, tbl_city_202005 c where t.city_code = c.city_code \r\n" + 
				"group by test_date, city_name";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setTest_date(rs.getString(1));
				v.setCity_name(rs.getString(2));
				v.setTest_value(rs.getInt(3));
				v.setPollution(rs.getString(4));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
}
