package service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import service.Action;
import util.PageIndex;

public class BoardListAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardDAO dao = BoardDAO.getInstance();
				BoardDAO dao = BoardDAO.getInstance();
				String s_query="", addtag="", query="",key="";
				
				int totcount = 0; // 게시글 총수
				//post 방식(검색일 경우)
				if(request.getParameter("key") != null) {
					//key = URLDecoder.decode(request.getParameter("key"));
					key = request.getParameter("key");
					query = request.getParameter("search");
					s_query = query + " like '%" + key + "%'";
					addtag = "&search="+query+"&key="+ key;
					totcount = dao.boardCount(s_query);
				}else {
					totcount = dao.boardCount();	
				}
				
				int nowpage= 1;   // 현재 페이지
				int maxlist= 10;  // 페이지당 글 수
				int totpage = 1;  //총 페이지수		
				
				if(totcount%maxlist == 0 ) {
					totpage=totcount/maxlist;
				}else{
					totpage=totcount/maxlist+1;
				}
				
				if(request.getParameter("page") != null) {
					nowpage=Integer.parseInt(request.getParameter("page"));
				}
				
				int pagestart=(nowpage-1)*maxlist+1;
				int endpage=nowpage*maxlist;
				int listcount = totcount-((nowpage-1)*maxlist);
				
				List<BoardVO> list = null;
				if(key.equals("")) {
					list = dao.boardList(pagestart,endpage);
				}else {
					list = dao.boardList(s_query, pagestart,endpage);
				}
				String pageSkip="";
				if(key.equals("")) {
					pageSkip = PageIndex.pageList(nowpage, totpage, "/Board?cmd=board_list", addtag);
				}else {	
					pageSkip = PageIndex.pageListHan(nowpage, totpage, "/Board?cmd=board_list", query, key);
				}
				request.setAttribute("totcount", totcount);
				request.setAttribute("list", list);
				request.setAttribute("listcount", listcount);
				request.setAttribute("page", nowpage);
				request.setAttribute("totpage", totpage);
				request.setAttribute("pageSkip", pageSkip);
				request.setAttribute("search", query);
				request.setAttribute("key", key);
					
				RequestDispatcher dispater = 
						request.getRequestDispatcher("Board/board_list.jsp");
				dispater.forward(request, response);
	}

}
