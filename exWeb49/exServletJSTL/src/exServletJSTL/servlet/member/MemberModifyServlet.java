package exServletJSTL.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exServletJSTL.model.member.MemberDAO;
import exServletJSTL.model.member.MemberVO;
import exServletJSTL.util.UserSHA256;

@WebServlet("/userinfo_modify.do")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberModifyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") == null) {
			response.sendRedirect("login_form.do");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Member/userinfo_modify.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		String pass = UserSHA256.getSHA256(request.getParameter("passwd"));
		vo.setPasswd(pass);
		vo.setGubun(request.getParameter("gubun"));
		vo.setZipcode(request.getParameter("zipcode"));
		vo.setAddr1(request.getParameter("addr1"));
		vo.setAddr2(request.getParameter("addr2"));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(request.getParameter("email"));
		String fa[] = request.getParameterValues("fa");
		String favorite = fa[0];
		for(int x = 1; x < fa.length; x++) {
			favorite = favorite + "," + fa[x];
		}
		vo.setFavorite(favorite);
		vo.setJob(request.getParameter("job"));
		vo.setIntro(request.getParameter("intro"));
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.memberModify(vo);
		response.sendRedirect("index.do");
	}

}
