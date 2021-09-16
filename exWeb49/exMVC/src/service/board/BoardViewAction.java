package service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import service.Action;

public class BoardViewAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = 1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
		}

		BoardDAO dao = BoardDAO.getInstance();
		
		// 쿠키검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x=0; x<cookies.length;x++){
			info = cookies[x];
			if(info.getName().equals("board"+idx)){
				bool=true;
				break;
			}
		}

		String newValue=""+System.currentTimeMillis();
		if(!bool){ // 쿠키가 존재하지 않으면
			dao.boardHits(idx);// 조회수 증가
			info = new Cookie("board"+idx, newValue);
			info.setMaxAge(60*60);//1시간 /(24*60*60)-1일
			response.addCookie(info);
		}
		
		BoardVO board = dao.boardSelect(idx);
		String content = board.getContents();
		board.setContents(content.replace("\n", "<br>"));
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Board/board_view.jsp");
		dispater.forward(request, response);
	}

}
