package service.admin.member;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandHandler;

public class MemberMailProHandler implements CommandHandler {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		String email = request.getParameter("list");
		email = email.substring(1,email.length()-1);
		String address[] = email.split(",");
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
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		for(int x = 0; x < address.length; x++) {
			// email 전송
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(user, "관리자"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address[x]));
				// 메일 제목
				msg.setSubject(subject);
				// 메일 내용
				msg.setText(contents);
				Transport.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(address[0]);
		request.setAttribute("success", address.length);
		
		return "/Admin/member_mail_pro.jsp";
	}

}
