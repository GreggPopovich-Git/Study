package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class BoardDAO {
   private BoardDAO() {} //디폴트 생성자 생성
   private static BoardDAO instance = new BoardDAO();
   public static BoardDAO getInstance() {
      return instance;
   }
   // 게시글 총수 카운트
   public int boardCount() {
      Connection conn=null;
      PreparedStatement pstmt = null;
      ResultSet rs =null;
      
      int row=0;
      String query = "select count(*) from tbl_board";
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            row=rs.getInt(1);
         }
      }catch(Exception e) {}
      return row;
   }
   // 페이지별 게시글 불러오기
   public List<BoardVO> getList(int startPage, int pageList) {
      Connection conn=null;
      PreparedStatement pstmt = null;
      ResultSet rs =null;
      List<BoardVO> list = new ArrayList<BoardVO>();
      //String query = "select * from tbl_board order by bno desc limit ?, ?";
      String query = "select * from tbl_board order by bno desc limit " + startPage + ", " + pageList;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(query);
         //pstmt.setInt(1, startPage);
         //pstmt.setInt(2, pageList);
         rs = pstmt.executeQuery();
         BoardVO vo = null;
         while(rs.next()) {
        	 vo = new BoardVO();
        	 vo.setBno(rs.getInt("bno"));
        	 vo.setWriter(rs.getString("writer"));
        	 vo.setRegdate(rs.getString("regdate"));
        	 vo.setReadcnt(rs.getInt("readcnt"));
        	 list.add(vo);
         }
      }catch(Exception e) {}
      return list;
   }
   // 글번호로 검색 하기
   public BoardVO getSelect(int bno) {
      Connection conn=null;
      PreparedStatement pstmt = null;
      ResultSet rs =null;
      String query = "update tbl_board set readcnt = readcnt + 1 where bno = "+ bno;
      BoardVO vo = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(query);
         pstmt.executeUpdate();
         query = "select * from tbl_board where bno = " + bno;
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();
         while(rs.next()) {
        	 vo = new BoardVO();
        	 vo.setBno(rs.getInt("bno"));
        	 vo.setWriter(rs.getString("writer"));
        	 vo.setTitle(rs.getString("title"));
        	 vo.setContents(rs.getString("contents"));
        	 vo.setRegdate(rs.getString("regdate"));
        	 vo.setReadcnt(rs.getInt("readcnt"));
         }
      }catch(Exception e) {}
      return vo;
   }
}