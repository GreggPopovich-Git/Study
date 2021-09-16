package exam02;

import java.util.Scanner;

class Hak {
	String hakbun;
	String name;
	Hak(String hakbun, String name) {
		this.hakbun = hakbun;
		this.name = name;
	}
	void titlePrint() {
		System.out.println("학년\t반\t번호\t이름");
	}
	void dataPrint() {
		String clas = hakbun.substring(0,1);
		String ban = hakbun.substring(1,2);
		String bun = hakbun.substring(3);
		System.out.println(clas + "\t" + ban + "\t" + bun + "\t" + name);
	}
}
class Student extends Hak {
	int kor, eng, mat, tot;
	int rank = 1;
	double ave;
	String score;

	Student(String hakbun, String name) {
		super(hakbun, name);
	}
	void titlePrint() {
		System.out.println("학년\t반\t번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
	}
	void dataPrint() {
		String clas = hakbun.substring(0,1);
		String ban = hakbun.substring(1,2);
		String bun = hakbun.substring(3);
		System.out.print(clas + "\t" + ban + "\t" + bun + "\t" + name + "\t");
	}
	void cal(String score) {
		this.score = score;
		String imsi[] = score.split(" ");
		kor = Integer.parseInt(imsi[0]);
		eng = Integer.parseInt(imsi[1]);
		mat = Integer.parseInt(imsi[2]);
		tot = kor + eng + mat;
		ave = (int)(tot / 3. * 100 + 0.5) / 100.;
	}
	void scorePrint() {
		System.out.println(kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + ave + "\t" + rank);
	}
}
/* [입력형식] (학번은 1-1-01)
 * 학생 등록 : 1101,이학생,90 88 79;
 * 학번이 0000 입력종료
 * [출력형식]
 * 학년	반	번호	이름	국어	영어	수학	총점	평균	석차
 * 
 */
public class Exam_08 {
	void rank(Student a[], int cnt) {
		for (int x = 0; x < cnt; x++) {
			for (int y = 0; y < cnt; y++) {
				if (a[x].ave < a[y].ave) {
					a[x].rank++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Student[] student = new Student[10];
		Exam_08 ss = new Exam_08();
		//입력
		int cnt = 0;
		for(int x = 0; x < student.length; x++) {
			System.out.print("학생 등록 : ");
			String imsi[] = scn.nextLine().split(",");
			if (imsi[0].equals("0000")) {
				System.out.println("입력종료");
				break;
			}
			student[x] = new Student(imsi[0],imsi[1]);
			student[x].cal(imsi[2]); //계산
			cnt++;
		}
		ss.rank(student, cnt); //석차
		student[0].titlePrint(); //타이틀 프린트
		for (int x = 0; x < cnt; x++) { //데이터 프린트
			student[x].dataPrint();
			student[x].scorePrint();
		}
		scn.close();
	}
}