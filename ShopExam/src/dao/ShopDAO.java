package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import vo.ShopVO;

public class ShopDAO {
	private ShopDAO() {}
	private static ShopDAO instance = new ShopDAO();
	public static ShopDAO getInstance() {
		return instance;
	}
	// method sample def.
	public void method() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		
		// SQL 문장정의
		String sql = "";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 작업영역
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
		//리턴이 있을 경우
	}
	
	// 가장 큰 회원번호 검색 메소드
	public int custMaxNo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "select max(custno) as custno from tbl_member_001";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 작업영역
			while(rs.next()) {
				row = rs.getInt("custno");
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
			} catch (Exception e) {}
		}
		//리턴이 있을 경우
		return row;
	}
	// member 등록 메소드
	public int shopInsert(ShopVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city) value(?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustno());
			pstmt.setString(2, vo.getCustname());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getJoindate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getCity());
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
	// money 등록 메소드
	public int moneyInsert(ShopVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 리턴 타입 정의
		int row = 0;
		// SQL 문장정의
		String sql = "insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) value(?,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustno());
			pstmt.setInt(2, vo.getSaleno());
			pstmt.setInt(3, vo.getPcost());
			pstmt.setInt(4, vo.getAmount());
			pstmt.setInt(5, vo.getPrice());
			pstmt.setString(6, vo.getPcode());
			pstmt.setString(7, vo.getSdate());
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
	// 회원정보 출력 메소드
	public List<ShopVO> memberPrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 리턴 타입 정의
		
		List<ShopVO> mList = new ArrayList<ShopVO>();
		// SQL 문장정의
		String sql = "select * from tbl_member_001";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 작업영역
			while(rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setGender(rs.getString("gender"));
				vo.setJoindate(rs.getString("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
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
			} catch (Exception e) {}
		}
		return mList;
	}
	// 매출 정보 출력
	public List<ShopVO> moneyPrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 리턴 타입 정의
		
		List<ShopVO> moList = new ArrayList<ShopVO>();
		// SQL 문장정의
		String sql = "select * from tbl_money_001";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 작업영역
			while(rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setSaleno(rs.getInt("saleno"));
				vo.setPcost(rs.getInt("pcost"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPrice(rs.getInt("price"));
				vo.setPcode(rs.getString("pcode"));
				vo.setSdate(rs.getString("sdate"));
				moList.add(vo);
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
			} catch (Exception e) {}
		}
		return moList;
	}
	// 문제 3번 회원목록 조회화면
	public List<ShopVO> custPrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 리턴 타입 정의
		
		List<ShopVO> cuList = new ArrayList<ShopVO>();
		// SQL 문장정의
		String sql = "select mem.custno, mem.custname, mem.phone, mem.gender, mem.joindate,mem.grade, ci.cityname from tbl_member_001 mem, tbl_city_001 ci where mem.city=ci.city";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 작업영역
			while(rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setGender(rs.getString("gender"));
				vo.setJoindate(rs.getString("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCityname(rs.getString("cityname"));
				cuList.add(vo);
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
			} catch (Exception e) {}
		}
		return cuList;
	}
	// 문제 4번 회원매출 조회화면
	public List<ShopVO> pricePrint() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 리턴 타입 정의
		
		List<ShopVO> cuList = new ArrayList<ShopVO>();
		// SQL 문장정의
		String sql = "select mem.custno, custname, phone, grade, sum(price) from tbl_member_001 mem, tbl_money_001 mon where mem.custno = mon.custno group by custno, custname, phone, grade order by sum(price) desc";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 작업영역
			while(rs.next()) {
				ShopVO vo = new ShopVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("sum(price)"));
				cuList.add(vo);
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
			} catch (Exception e) {}
		}
		return cuList;
	}
}
