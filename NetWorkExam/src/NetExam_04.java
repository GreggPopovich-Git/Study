import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class NetExam_04 {

	public static void main(String[] args) throws Exception {
		URL google = new URL("http://www.google.com");
		URLConnection googleConn = google.openConnection();
		System.out.println("문서타입 : " + googleConn.getContentType());
		System.out.println("******문서의 내용******");
		InputStream input = googleConn.getInputStream();
		int cnt = 1000;
		int str;
		while (((str = input.read()) != -1) && (--cnt > 0)) {
			System.out.print((char) str);
		}
		input.close();
	}
}
