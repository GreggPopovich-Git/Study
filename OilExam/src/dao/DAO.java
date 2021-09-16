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
	// 3번 문제
	public List<VO> exam_1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select saleno, REGEXP_REPLACE(oildate, '(.{4})(.{2})(.{2})', '\\1년\\2월\\3일'), oilname, amount, decode(paytype, 1, '현금', 2, '카드'), nvl(custname, '비회원'), nvl(s.custno,'비회원'),\r\n" + 
				"nvl(custtel1,'000') || '-' || nvl(custtel2,'0000') || '-' || nvl(custtel3,'0000') as tel, nvl(creditcard, ' '), oilcost \r\n" + 
				"from tbl_custinfo_202010 c, tbl_oilinfo_202010 o, tbl_saleinfo_202010 s \r\n" + 
				"where c.custno(+) = s.custno and o.oiltype = s.oiltype \r\n" + 
				"order by saleno";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setSaleno(rs.getString(1));
				v.setOildate(rs.getString(2));
				v.setOilname(rs.getString(3));
				v.setAmount(rs.getInt(4));
				v.setPaytype(rs.getString(5));
				v.setCustname(rs.getString(6));
				v.setCustno(rs.getString(7));
				v.setCusttel1(rs.getString(8));
				v.setCreditcard(rs.getString(9));
				v.setOilcost(rs.getInt(10));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 4번 문제
	public List<VO> exam_2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<VO> eList = new ArrayList<VO>();
		String query = "select REGEXP_REPLACE(oildate, '(.{4})(.{2})(.{2})', '\\1년\\2월\\3일'), oilname, count(oilcost) gun, sum(oilcost) tot\r\n" + 
				"from tbl_saleinfo_202010 a, tbl_oilinfo_202010 b where a.oiltype = b.oiltype\r\n" + 
				"group by oildate, oilname order by a.oildate, b.oilname";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VO v = new VO();
				v.setOildate(rs.getString(1));
				v.setOilname(rs.getString(2));
				v.setAmount(rs.getInt(3));
				v.setOilcost(rs.getInt(4));
				eList.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
}
