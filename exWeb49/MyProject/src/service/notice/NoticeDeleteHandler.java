package service.notice;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import service.CommandHandler;

public class NoticeDeleteHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("notice/upload");
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO vo = dao.getNotice(idx);
		int row = dao.noticeDelete(idx);
		if(row == 1) {
			String oldfilename = vo.getFilename();
			if(oldfilename != null) {
				File file = new File(path, oldfilename);
				if(file.exists()) {
					file.delete();
				}
			}
		}
		request.setAttribute("deleterow", row);
		return "/notice/delete.jsp";
	}

}
