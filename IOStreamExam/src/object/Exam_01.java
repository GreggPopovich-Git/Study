package object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point implements Serializable { // Serializable 인터페이스를 구현해서 객체를 직렬화 시킴
	int x, y;

	Point() {}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "x = " + x + "\ty = " + y;
	}
}

public class Exam_01 {
	public static void main(String[] args) throws Exception {
		Point p1 = new Point(10, 20);
		System.out.println(p1);
		File file = new File("object.txt");
		// 객체를 파일로 저장
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(p1); // p1이 직렬화 되어있지 않으면 객체는 데이터 전송이 안됨.
		oos.close();
	}

}
