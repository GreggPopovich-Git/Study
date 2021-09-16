package exServlet.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServlet.model.guest.GuestDAO;
import exServlet.model.guest.GuestVO;

@WebServlet("/guest_view")
public class GuestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GuestViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		GuestDAO dao = GuestDAO.getInstance();
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
			dao.guestHit(idx); //조회수증가 추가
		}
		GuestVO vo = dao.guestView(idx);
		vo.setIdx(idx);
		vo.setContents(vo.getContents().replace("\n", "<br>"));
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_view.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
