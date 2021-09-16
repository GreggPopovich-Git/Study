package exServlet.servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exServlet.model.guest.GuestDAO;
import exServlet.model.guest.GuestVO;

@WebServlet("/guest_modify")
public class GuestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GuestModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = dao.guestView(idx);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("Guest/guest_modify.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		GuestDAO dao = GuestDAO.getInstance();
		GuestVO vo = dao.guestView(idx);
		String pass = request.getParameter("pass");
		int result = 999;
		if(vo.getPass().equals(pass)) {
			vo.setIdx(idx);
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			dao.guestModify(vo);
			response.sendRedirect("guest_list?page=" + page);
		} else {
			response.sendRedirect("guest_modify?page=" + page + "&idx=" + idx + "&result=" + result);
		}
	}

}
