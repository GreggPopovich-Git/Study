package service.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;

public class PdsWriteAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		RequestDispatcher d = request.getRequestDispatcher("Pds/pds_write.jsp");
		d.forward(request, response);
	}

}
