package file;

import java.io.File;

public class Exam_04 {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		// System.out.println(path);
		File f = new File(path);

		File[] list = f.listFiles();
		for (int x = 0; x < list.length; x++) {
			if (list[x].isDirectory()) {
				System.out.println(list[x].getName() + "   d");
				File file = new File(path, list[x].getName());
				String[] str = file.list();
				for (String s : str)
					System.out.println("\t" + s);
				System.out.println();
			} else {
				System.out.println(list[x].getName());
			}
		}
	}
}
