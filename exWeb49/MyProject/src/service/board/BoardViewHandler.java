package service.board;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import service.CommandHandler;

public class BoardViewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = BoardDAO.getInstance();
		// 쿠키 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x = 0; x < cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("board" + idx)) {
				bool = true;
				break;
			}
		}
		if(!bool) {
			String value = "" + System.currentTimeMillis();
			info = new Cookie("board" + idx, value);
			info.setMaxAge(24*60*60);
			response.addCookie(info);
			dao.BoardHit(idx); //조회수증가
		}
		BoardVO vo = dao.getBoard(idx);
		vo.setIdx(idx);
		
		request.setAttribute("vo", vo);
		
		return "/board/board_view.jsp";
	}

}
