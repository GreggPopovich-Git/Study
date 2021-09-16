package service.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gallery.GalleryDAO;
import model.gallery.GalleryVO;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;
import model.qa.QADAO;
import model.qa.QAVO;
import service.CommandHandler;

public class IndexHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		GalleryDAO gdao = GalleryDAO.getInstance();
		List<GalleryVO> glist = new ArrayList<GalleryVO>();
		glist = gdao.galleryList(1, 3);
		String target = "src=";
		List<String> path = new ArrayList<String>();
		for(int x = 0; x < glist.size(); x++) {
			String contents = glist.get(x).getContents();
			int target_num = contents.indexOf(target);
			String result = contents.substring(target_num,(contents.substring(target_num).indexOf(" ")+target_num));
			path.add(result);
		}
		NoticeDAO noticedao = NoticeDAO.getInstance();
		List<NoticeVO> noticelist = noticedao.noticeList(1, 5);
		QADAO qadao = QADAO.getInstance();
		List<QAVO> qalist = qadao.qaList(1, 5);
		request.setAttribute("qalist", qalist);
		request.setAttribute("nlist", noticelist);
		request.setAttribute("path", path);
		request.setAttribute("glist", glist);
		return "/index.jsp";
	}

}
