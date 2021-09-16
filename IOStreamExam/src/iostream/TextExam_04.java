package iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TextExam_04 {

	public static void main(String[] args) throws Exception {
		File f = new File("output2.txt");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		out.println("파일 출력입니다.");
		
		PrintWriter out2 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		out2.println("콘솔 출력입니다.");
		
		PrintWriter out3 = new PrintWriter(new FileWriter(f));
		out3.println("파일2 출력");
		
		out.close();
		out2.close();
		out3.close();
	}

}
