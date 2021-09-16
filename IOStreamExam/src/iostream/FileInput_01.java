package iostream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class FileInput_01 {

	public static void main(String[] args) throws Exception {
		File file = new File("abc.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str, ", ");
			while(st.hasMoreTokens()) {
				System.out.print(st.nextToken() + "\t");
			}
			System.out.println();
		}
		br.close();
	}

}
