package oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.util.DBManager;
import oracle.vo.VO;

public class DAO {
	private DAO() {}
	private static DAO instance = new DAO();
	public static DAO getInstance() {
		return instance;
	}
	// 메소드 정의
	public List<VO> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary, job, dno, commission, salary*12, salary*12+nvl(commission,0) from emp";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				v.setJob(rs.getString(3));
				v.setDno(rs.getInt(4));
				v.setCommission(rs.getInt(5));
				v.setTot(rs.getInt(6));
				v.setSum(rs.getInt(7));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 1번 문제
	public List<VO> getList_01() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary, salary+300 from emp";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				v.setTot(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 2번 문제
	public List<VO> getList_02() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary, salary*12+100 from emp order by salary*12+100 desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				v.setTot(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 3번 문제
	public List<VO> getList_03() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary from emp where salary > 2000 order by salary desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 4번 문제
	public VO getList_04() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VO v = new VO();
		String query = "select ename, dno from emp where eno = 7788";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				v.setEname(rs.getString(1));
				v.setDno(rs.getInt(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	// 5번 문제
	public List<VO> getList_05() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary from emp where salary not between 2000 and 3000";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 6번 문제
	public List<VO> getList_06() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, job, to_char(hiredate,'YY-MM-DD') from emp where hiredate between '81/02/20' and '81/05/01'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setJob(rs.getString(2));
				v.setHiredate(rs.getString(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 7번 문제
	public List<VO> getList_07() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, dno from emp where dno = 20 or dno = 30 order by ename";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setDno(rs.getInt(2));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 8번 문제
	public List<VO> getList_08() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary, dno from emp where salary between 2000 and 3000 and dno in(20,30) order by ename";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				v.setDno(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 9번 문제
	public List<VO> getList_09() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, to_char(hiredate,'YY-MM-DD') from emp where hiredate like '81%'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setHiredate(rs.getString(2));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 10번 문제
	public VO getList_10() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		VO v = new VO();
		String query = "select ename, job from emp where manager is null";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				v.setEname(rs.getString(1));
				v.setJob(rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	// 11번 문제
	public List<VO> getList_11() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary, commission from emp where commission is not null order by salary, commission";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				v.setCommission(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 12번 문제
	public List<VO> getList_12() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename from emp where ename like '__R%'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 13번 문제
	public List<VO> getList_13() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename from emp where ename like '%A%' and ename like '%E%'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 14번 문제
	public List<VO> getList_14() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, job, salary from emp where job in('CLERK','SALESMAN') and salary not in(1600,950,1300)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setJob(rs.getString(2));
				v.setSalary(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 15번 문제
	public List<VO> getList_15() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select ename, salary, commission from emp where commission >= 500";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEname(rs.getString(1));
				v.setSalary(rs.getInt(2));
				v.setCommission(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 16번 문제
	public List<VO> getList_16() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select * from emp where substr(hiredate,4,2) = '04'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEno(rs.getInt(1));
				v.setEname(rs.getString(2));
				v.setJob(rs.getString(3));
				v.setManager(rs.getInt(4));
				v.setHiredate(rs.getString(5));
				v.setSalary(rs.getInt(6));
				v.setCommission(rs.getInt(7));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 17번 문제
	public List<VO> getList_17() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select to_char(hiredate,'YY-MM-DD'), to_char(hiredate,'YY/MON/DD DY') from emp";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setHiredate(rs.getString(1));
				v.setJob(rs.getString(2));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
	// 18번 문제
	public List<VO> getList_18() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO> eList = new ArrayList<VO>();
		String query = "select eno, ename, nvl(manager, 0) from emp";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO v = new VO();
				v.setEno(rs.getInt(1));
				v.setEname(rs.getString(2));
				v.setManager(rs.getInt(3));
				eList.add(v);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return eList;
	}
}