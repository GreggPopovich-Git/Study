package mapexam;

import java.io.FileReader;
import java.util.Properties;

public class Exam_08 {

	public static void main(String[] args) throws Exception {
		Properties pro = new Properties();
		String path = Exam_08.class.getResource("database.properties").getPath();
		pro.load(new FileReader(path));
		
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
	}

}