package service.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.Action;

public class PdsWriteProAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("Pds/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024;//최대 2MB
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy()파일중복처리(a.bm 중복시-> a1.bmp)

		String name = multi.getParameter("name");
		String pass = multi.getParameter("pass");
		String email = multi.getParameter("email");
		String subject = multi.getParameter("subject");
		String contents = multi.getParameter("contents");
		String filename = multi.getFilesystemName("filename");
		String page = multi.getParameter("page");
		PdsVO pVo = new PdsVO();
		pVo.setName(name);
		pVo.setPass(pass);
		pVo.setEmail(email);
		pVo.setSubject(subject);
		pVo.setContents(contents);
		pVo.setFilename(filename);
		
		PdsDAO pDao = PdsDAO.getInstance();
		int row = pDao.pdsWrite(pVo);
		
		if(row==1) {//성공
			request.setAttribute("sw", 1);
		}else {//실패
			request.setAttribute("sw", 0);
		}
		request.setAttribute("page", page);
		RequestDispatcher d = request.getRequestDispatcher("Pds/pds_write_pro.jsp");
		d.forward(request, response);

	}

}
