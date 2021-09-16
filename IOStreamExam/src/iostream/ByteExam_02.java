package iostream;

import java.io.File;
import java.io.FileInputStream;

// 키보드 입력 -> 파일 출력
public class ByteExam_02 {

	public static void main(String[] args) throws Exception {
		File f = new File("abc.txt");
		FileInputStream fis = new FileInputStream(f);
		byte[] by = new byte[1024];
		String str = "";
		int count = fis.read(by);
		for (int x = 0; x < count; x++) {
			System.out.println(x + " : " + (char) by[x]);
			str = str + (char)by[x];
		}
		System.out.println(str);
		fis.close();
	}

}
