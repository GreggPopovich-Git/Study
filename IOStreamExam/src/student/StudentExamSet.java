package student;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentExamSet {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		File file = new File("student.dat");
		Set<StudentSet> sSet = new TreeSet<StudentSet>();
		while (true) {
			System.out.print("[1]학생등록 [2]전체출력 [3]종료 : ");
			int temp = scn.nextInt();
			if (temp == 1) {
				System.out.print("학생 정보 입력 : ");
				String[] info = scn.next().split(",");
				if (file.exists()) {
					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
					sSet = (Set) ois.readObject();
				}
				StudentSet stu = new StudentSet(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]),
						Integer.parseInt(info[3]), Integer.parseInt(info[4]));
				if(sSet.add(stu))
					System.out.println("등록되었습니다.");
				else
					System.out.println("중복된 자료가 있습니다.");
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				oos.writeObject(sSet);
				oos.close();
			} else if (temp == 2) {
				List<StudentSet> sList = new ArrayList<StudentSet>();
				if (file.exists()) {
					ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
					sList = (List) ois.readObject();
				}
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");
				int kortot = 0, engtot = 0, mattot = 0, total = 0;
				for (int x = 0; x < sList.size(); x++) {
					System.out.println(sList.get(x));
					kortot += sList.get(x).kor;
					engtot += sList.get(x).eng;
					mattot += sList.get(x).mat;
					total += sList.get(x).tot;
				}
				System.out.println("총점 : \t\t" + kortot + "\t" + engtot + "\t" + mattot + "\t" + total);
				double korave = (int) (kortot / 3. * 100 + 0.5) / 100.;
				double engave = (int) (engtot / 3. * 100 + 0.5) / 100.;
				double matave = (int) (mattot / 3. * 100 + 0.5) / 100.;
				double totave = (int) (total / 3. * 100 + 0.5) / 100.;
				System.out.println("총점 : \t\t" + korave + "\t" + engave + "\t" + matave + "\t" + totave);
			} else if (temp == 3) {
				System.out.println("프로그램을 종료 합니다.");
				break;
			} else
				System.out.println("잘못입력 하셨습니다.");
		}
		scn.close();
	}
}
