package service.pds;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.Action;

public class PdsModifyProAction implements Action {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("Pds/upload/");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024;//최대 2MB
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy()파일중복처리(a.bm 중복시-> a1.bmp)
		String nowpage=multi.getParameter("page");
		int idx = Integer.parseInt(multi.getParameter("idx"));
		String name = multi.getParameter("name");
		String email = multi.getParameter("email");
		String pass = multi.getParameter("pass");
		String subject = multi.getParameter("subject");
		String contents = multi.getParameter("contents");
		String filename1 = multi.getParameter("filename1");
		String filename = multi.getFilesystemName("filename");
		
		PdsVO pVo = new PdsVO();
		pVo.setIdx(idx);
		pVo.setName(name);
		pVo.setEmail(email);
		pVo.setPass(pass);
		pVo.setSubject(subject);
		pVo.setContents(contents);
		pVo.setFilename(filename);
		
		if (filename == null) {  // 예전 파일 이용시
			pVo.setFilename(filename1);
		}else{	//새 파일로 변경(구파일삭제)
			File a1 = new File(path + filename1);
			if (a1.exists())
				a1.delete();
		}

		PdsDAO pDao = PdsDAO.getInstance();
		int row = pDao.pdsModify(pVo);
		
		if(row==1) {//성공
			request.setAttribute("sw", 1);
			request.setAttribute("page", nowpage);
		}else {//실패
			request.setAttribute("sw", 0);
		}

		RequestDispatcher d = request.getRequestDispatcher("Pds/pds_modify_pro.jsp");
		d.forward(request, response);
	}

}
