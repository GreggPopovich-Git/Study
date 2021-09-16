package service.pds;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pds.PdsDAO;
import model.pds.PdsVO;
import service.CommandHandler;

public class PdsViewHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String nowpage=request.getParameter("page");

		PdsDAO pDao = PdsDAO.getInstance();
		boolean found =false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();

		for(int i=0;i<cookies.length;i++){
			info=cookies[i];
			if(info.getName().equals("pdsCookie"+idx)){
				found=true;
				break;
			}
		}//for문의 끝
		String newValue=""+System.currentTimeMillis();
		 
		if(!found) {  //쿠키가 없으면(내용을 처음보는 경우)
			info=new Cookie("pdsCookie" + idx,newValue); //쿠키 생성
			response.addCookie(info); //생성된 쿠키를 넘김
			pDao.hitsPds(idx);				//조회수를 1증가
		}//if문의 종료
		
		PdsVO pVO = pDao.selectPdsNum(idx);

		request.setAttribute("pds", pVO);
		request.setAttribute("page", nowpage);
		return "/Pds/pds_view.jsp";
	}

}
