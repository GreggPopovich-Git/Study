package file;

import java.io.File;

public class Exam_02 {

	public static void main(String[] args) throws Exception {
		// directory 생성
		File f = new File("C:/Users/ilove/data");
		if (f.exists())
			f.delete();
		if (!f.exists())
			f.mkdir();
		// file 생성
		File f2 = new File(f, "abc.txt");
		if(!f2.exists())
			f2.createNewFile();
		
	}

}
