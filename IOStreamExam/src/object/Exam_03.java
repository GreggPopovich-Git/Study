package object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Sawon implements Serializable {
	int bun;
	String name;
	int age;
	Sawon(){}
	Sawon(int bun, String name, int age) {
		this.bun = bun;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return bun + "\t" + name + "\t" + age;
	}
}
public class Exam_03 {
	public static void main(String[] args) throws Exception {
		File file = new File("sawon.dat");
		List<Sawon> sList = new ArrayList<Sawon>();
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			sList = (List) ois.readObject();
		}
		System.out.println("번호\t이름\t나이");
		for (int x = 0; x < sList.size(); x++) {
			Sawon s = sList.get(x);
			System.out.println(s);
		}
		sList.add(new Sawon(1, "김사원", 28));
		sList.add(new Sawon(2, "이사원", 34));
		sList.add(new Sawon(3, "박사원", 25));
		sList.add(new Sawon(4, "장사원", 29));
		// 출력
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(sList);
		oos.close();
	}
}