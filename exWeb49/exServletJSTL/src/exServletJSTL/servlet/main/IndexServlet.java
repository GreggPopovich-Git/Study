package exServletJSTL.servlet.main;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exServletJSTL.model.member.MemberDAO;
import exServletJSTL.model.member.MemberVO;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getMember("admin");
		
		// 조회수 증가
		int tot = Integer.parseInt(vo.getAddr1());
		int now = Integer.parseInt(vo.getAddr2());
		
		String date = vo.getFirst_time().substring(0,10);
		int row = dao.dateModify(date); // 날짜 바뀌었는지 확인해서 날짜 갱신
		if(row == 1) {
			vo.setAddr2(Integer.toString(0)); // 날짜가 바뀌었으면 오늘 방문자수 0으로 초기화
		}
		// 쿠키 검사
		boolean bool = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		String value = "" + System.currentTimeMillis();
		if(request.getCookies() != null) {
			for(int x = 0; x < cookies.length; x++) {
				info = cookies[x];
				if(info.getName().equals("Guest")) {
					bool = true;
					break;
				}
			}
		}
		if(!bool) { // 쿠키가 없으면 방문자 수 늘리기
			info = new Cookie("Guest", value);
			info.setMaxAge(24*60*60); // 쿠키 하루 유지
			response.addCookie(info);
			tot ++;
			now ++;
			vo.setAddr1(Integer.toString(tot));
			vo.setAddr2(Integer.toString(now));
			
			dao.memberModify(vo); // 방문자수 증가
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("tot", tot);
		session.setAttribute("now", now);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
