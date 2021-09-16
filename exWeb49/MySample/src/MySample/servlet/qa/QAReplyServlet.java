package MySample.servlet.qa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.qa.QADAO;
import MySample.model.qa.QAVO;

@WebServlet("/qareply.do")
public class QAReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QAReplyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		QADAO dao = QADAO.getInstance();
		QAVO vo = dao.getQA(idx);
		request.setAttribute("vo", vo);
		request.setAttribute("idx", idx);
		RequestDispatcher rd = request.getRequestDispatcher("qa/qareply.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String answer = request.getParameter("answer");
		
		QADAO dao = QADAO.getInstance();
		QAVO vo = new QAVO();
		vo.setIdx(idx);
		vo.setAnswer(answer);
		int row = dao.qaModify(vo);
		System.out.println(row);
		request.setAttribute("idx", idx);
		request.setAttribute("answerrow", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("qa/qareply.jsp");
		rd.forward(request, response);
	}

}
