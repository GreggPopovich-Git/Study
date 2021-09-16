package iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TextExam_03 {

	public static void main(String[] args) throws Exception {
		File f = new File("output.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.println("1 파일에 쓰기");
		pw.println("2 파일에 쓰기");
		pw.println("3 파일에 쓰기");
		pw.println("4 파일에 쓰기");
		pw.println("5 파일에 쓰기");
		pw.close();
		
	}

}
