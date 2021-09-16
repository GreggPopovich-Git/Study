package iostream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextExam_05 {

	public static void main(String[] args) throws Exception {
		File file = new File("output.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
/*		while (true) {
			String str = br.readLine();
			if(str == null)
				break;
			System.out.println(str);
		}
*/
		String str = "";
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}

}
