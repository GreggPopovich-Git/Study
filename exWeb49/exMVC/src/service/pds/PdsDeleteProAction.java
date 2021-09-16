package service.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;

public class PdsDeleteProAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage = request.getParameter("page");
		String pass = request.getParameter("pass");
		
		PdsDAO DAO = PdsDAO.getInstance();
		
		String filename = DAO.getPds(idx).getFilename();
		int row = DAO.pdsDelete(idx, pass); //
		if(row==1) {//성공
			// 파일 삭제
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("Pds/upload/");// 파일 저장 경로
			File file = new File(path+filename);
			if(file.exists()) {
				file.delete();
			}

			request.setAttribute("sw", 1);
			request.setAttribute("page", nowpage);
		}else {//실패
			request.setAttribute("sw", 0);
		}

		RequestDispatcher d = request.getRequestDispatcher("Pds/pds_delete_pro.jsp");
		d.forward(request, response);
	}

}
