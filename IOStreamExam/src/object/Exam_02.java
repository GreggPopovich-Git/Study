package object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam_02 {
	public static void main(String[] args) throws Exception {
		File file = new File("object.txt");
		// 파일에 저장된 객체를 불러오기
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Object obj = ois.readObject();
		Point p = (Point) obj;
		System.out.println(p);
		ois.close();
	}

}
