package exServletJSTL.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exServletJSTL.model.admin.AdminVO;

/**
 * Servlet implementation class AdminLoginOK
 */
@WebServlet("/AdminLogin/adminloginok.do")
public class AdminLoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminLoginOK() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("adminid");
		String passwd = request.getParameter("adminpass");
		
		//AdminDAO dao = AdminDAO.getInstance();
		//int row = dao.adminLogin(userid, passwd);
		int row=1;
		if (row == 1) {
			//AdminVO vo = dao.adminSelect(userid);//이름, 아이디, 별칭
			AdminVO vo = new AdminVO();
			vo.setAdminid("admin");
			vo.setAdminname("관리자");
			
			HttpSession session = request.getSession();
			session.setAttribute("admin", vo);
			session.setMaxInactiveInterval(1800);
			response.sendRedirect("/Admin/notice_list.do");
		}

	}

}
