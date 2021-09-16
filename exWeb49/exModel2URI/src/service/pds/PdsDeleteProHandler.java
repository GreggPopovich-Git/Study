package service.pds;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pds.PdsDAO;
import service.CommandHandler;

public class PdsDeleteProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage = request.getParameter("page");
		String pass = request.getParameter("pass");
		
		PdsDAO DAO = PdsDAO.getInstance();
		
		String filename = DAO.searchFile(idx);
		int row = DAO.deletePds(idx, pass); //
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
		
		return "/Pds/pds_delete_pro.jsp";
	}

}
