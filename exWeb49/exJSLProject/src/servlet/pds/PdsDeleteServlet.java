package servlet.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.PdsDAO;
import model.vo.MemberVO;
import model.vo.PdsVO;

@WebServlet("/pds_delete")
public class PdsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PdsDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		ServletContext context = getServletContext();
		String path = context.getRealPath("Pds/upload");
		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = dao.getPds(idx);
		HttpSession session = request.getSession();
		MemberVO membervo = (MemberVO)session.getAttribute("vo");
		int drow = 0;
		if(membervo.getUserid().equals(vo.getUserid())) { // 본인인지 확인
			drow = 3; // 본인인 경우
			dao.pdsDelete(idx);
			String oldfilename = vo.getFilename();
			if(oldfilename != null) {
				File file = new File(path, oldfilename);
				if(file.exists()) {
					file.delete();
				}
			}
		} else {
			drow = -1; // 본인이 아닌경우
		}
		response.sendRedirect("pds_list?page=" + page + "&drow=" + drow + "&idx=" + idx);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
