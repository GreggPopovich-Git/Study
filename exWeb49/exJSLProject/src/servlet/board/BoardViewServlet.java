package servlet.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardCommentDAO;
import model.dao.BoardDAO;
import model.vo.BoardCommentVO;
import model.vo.BoardVO;
import util.CommentPageIndex;
import util.UserSHA256;

@WebServlet("/board_view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String sort = request.getParameter("sort");
		int row = 0;
		if(request.getParameter("row") != null) {
			row = Integer.parseInt(request.getParameter("row"));
		}
		BoardVO vo = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		
		// 쿠키 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		for(int x = 0; x < cookies.length; x++) {
			info = cookies[x];
			if(info.getName().equals("Guest" + idx)) {
				bool = true;
				break;
			}
		}
		if(!bool) {
			String value = "" + System.currentTimeMillis();
			info = new Cookie("Guest" + idx, value);
			info.setMaxAge(300); // 쿠키 5분 유지
			response.addCookie(info);
			dao.boardHit(idx); // 조회수증가 추가
		}
		vo = dao.boardView(idx);
		vo.setIdx(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("idx", idx);
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		request.setAttribute("sort", sort);
		
		// 코멘트 출력
		List<BoardCommentVO> clist = new ArrayList<BoardCommentVO>();
		BoardCommentDAO cdao = BoardCommentDAO.getInstance();
		
		int totcount = cdao.commentCount(idx);
		int compage = 1;
		int maxlist = 10;
		int totpage = 1;
		
		if(totcount % maxlist == 0) {
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}
		
		// 페이지 번호 클릭 했을 때
		if (request.getParameter("compage") != null) {
			compage = Integer.parseInt(request.getParameter("compage"));
		}
		int startpage = (compage - 1) * maxlist + 1;
		int endpage = compage * maxlist;
		String commentsort = "order by coidx desc";
		clist = cdao.boardCommentList(startpage, endpage, commentsort, idx);
		
		// 페이징 처리
		String comPageSkip = "";
		String url = "board_view";
		comPageSkip = CommentPageIndex.pageList(compage, totpage, url, "", sort, idx, page);
		
		request.setAttribute("comPageSkip", comPageSkip);
		request.setAttribute("compage", compage);
		request.setAttribute("clist", clist);
		RequestDispatcher rd = request.getRequestDispatcher("Board/board_view.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("comment") != null) {
			BoardCommentVO vo = new BoardCommentVO();
			BoardCommentDAO dao = BoardCommentDAO.getInstance();
			vo.setName(request.getParameter("name"));
			vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
			vo.setContents(request.getParameter("comment"));
			vo.setIdx(Integer.parseInt(request.getParameter("idx")));
			dao.commentWrite(vo);
		} else {
			int likecnt = Integer.parseInt(request.getParameter("result"));
			int idx = Integer.parseInt(request.getParameter("idx"));
			BoardDAO dao = BoardDAO.getInstance();
			boolean bool = false;
			Cookie info = null;
			Cookie[] cookies = request.getCookies();
			for(int x = 0; x < cookies.length; x++) {
				info = cookies[x];
				if(info.getName().equals("like" + idx)) {
					bool = true;
					break;
				}
			}
			int rowlike = 0;
			if(!bool) {
				String value = "" + System.currentTimeMillis();
				info = new Cookie("like" + idx, value);
				info.setMaxAge(24*60*60); // 쿠키 하루 유지
				response.addCookie(info);
				dao.likeCntUp(likecnt, idx); // 좋아요 1개 추가
			} else {
				rowlike = 1;
			}
			request.setAttribute("rowlike", rowlike);
		}
		doGet(request, response);
	}

}
