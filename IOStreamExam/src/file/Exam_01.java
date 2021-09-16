package file;

import java.io.File;

public class Exam_01 {

	public static void main(String[] args) {
		try {
			File file = new File("Data"); // 디렉토리
			if (file.exists())
				file.delete();
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("디렉토리를 만들기 시작합니다");
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			File file2 = new File("Test");
			if (!file2.exists()) {
				file2.mkdir();
			}
			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
