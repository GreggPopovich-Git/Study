package MySample.servlet.qa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MySample.model.member.MemberVO;
import MySample.model.qa.QADAO;
import MySample.model.qa.QAVO;
import MySample.util.UserSHA256;

@WebServlet("/qawrite.do")
public class QAWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QAWriteServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("qa/qawrite.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int row = 0;
		QAVO vo = new QAVO();
		if(session.getAttribute("sessionvo") != null) {
			MemberVO member = new MemberVO();
			member = (MemberVO)session.getAttribute("sessionvo");
			vo.setUserid(member.getUserid());
		}
		if(request.getParameter("name") != null) {
			vo.setName(request.getParameter("name"));
			vo.setPass(UserSHA256.getSHA256(request.getParameter("pass")));
			vo.setSubject(request.getParameter("subject"));
			vo.setContents(request.getParameter("contents"));
			QADAO dao = QADAO.getInstance();
			row = dao.qaWrite(vo);
		} else {
			row = -2;
		}
		request.setAttribute("writerow", row);
		doGet(request, response);
	}

}
