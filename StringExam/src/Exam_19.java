import java.io.File;
import java.util.Scanner;

public class Exam_19 {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(new File("c:\\data\\indata.txt")); // 파일을 불러와서 내용을 스캔해서 scn에 저장.
		while(scn.hasNextLine()) {
			String s = scn.nextLine();
			System.out.println(s);
		}
	}
}