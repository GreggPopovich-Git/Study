package file;

import java.io.File;
import java.util.Date;

public class Exam_03 {

	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\ilove\\OneDrive\\바탕 화면\\IT 자료\\bowling순서도.pdf");
		if (f.exists()) {
			System.out.println("파일명 : " + f.getName());
			System.out.println("파일경로 : " + f.getPath());
			System.out.println("상위경로 : " + f.getParent());
			System.out.println("수정일 : " + new Date(f.lastModified()));
			System.out.println("파일용량 : " + f.length() + " Byte");
			System.out.println("절대경로 : " + f.getAbsolutePath());
		} else {
			System.out.println(f.getName() + "이 존재하지 않음");
		}
		
	}

}
