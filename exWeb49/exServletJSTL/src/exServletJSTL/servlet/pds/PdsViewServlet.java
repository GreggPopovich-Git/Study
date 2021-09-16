package exServletJSTL.servlet.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServletJSTL.model.pds.PdsDAO;
import exServletJSTL.model.pds.PdsVO;

@WebServlet("/pds_view.do")
public class PdsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PdsViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		int row = 99;
		if(request.getParameter("row") != null) {
			row = Integer.parseInt(request.getParameter("row"));
		}
		PdsDAO dao = PdsDAO.getInstance();
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
			info.setMaxAge(60);
			response.addCookie(info);
			dao.pdsHit(idx); //조회수증가 추가
		}
		PdsVO vo = dao.getPds(idx);
		vo.setIdx(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("Pds/pds_view.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
