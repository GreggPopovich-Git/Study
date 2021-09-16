package iostream;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;

// 키보드 입력 -> 파일 출력
public class ByteExam_01 {

	public static void main(String[] args) {
		File f = new File("abc.txt");
		try {
			// 모니터 출력
			FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
			// 파일 출력용
			FileOutputStream fos1 = new FileOutputStream(f);
			byte[] data = {66, 68, 70, 72, (byte)'!'};
			fos.write(data);
			fos1.write(data);
			
			System.out.println("출력 끝");
			fos.close();
			fos1.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
