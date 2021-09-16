package MySample.servlet.member;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySample.model.member.MemberDAO;

@WebServlet("/pwfind.do")
public class MemberPassFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberPassFindServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("member/passfind.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String email = "";
		if(request.getParameter("email2") == null) {
			email = request.getParameter("email1") + "@" + request.getParameter("domain");
		} else {
			email = request.getParameter("email1") + "@" + request.getParameter("email2");
		}
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.usercheck(userid, email);
		
		if(row == 1) {
			// mail server 설정
			String host = "smtp.googlemail.com";
			String user = "iloveoov5082@gmail.com"; // 자신의 네이버 계정
			String password = "ehfkdl508@";// 자신의 네이버 패스워드

			// SMTP 서버 정보를 설정한다.
			Properties props = new Properties();
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");

			// 인증 번호 생성
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 10; i++) {
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}
			String AuthenticationKey = temp.toString();

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			// email 전송
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(user, "관리자"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

				// 메일 제목
				msg.setSubject("안녕하세요  인증 메일입니다.");
				// 메일 내용
				msg.setText("인증 번호는 : " + temp);

				Transport.send(msg);

			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("akey", AuthenticationKey);
			request.setAttribute("userid", userid);
			request.setAttribute("row", row);
		}
		
		doGet(request, response);
	}

}
