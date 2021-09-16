import java.util.Scanner;

class Student {
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	
	Student(){}
	Student(int bun, String name, int kor, int eng, int mat) {
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public void sPrint() {
		System.out.print(bun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat);
	}
}
public class Exam_06 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Student[] student = new Student[10];
		int cnt = 0;
		while (true) {
			System.out.print("학생등록 : ");
			String[] str = scn.nextLine().split(",");
			if (str[0].equals("0000"))
				break;
			int bun = Integer.parseInt(str[0]);
			String name = str[1];
			int kor = Integer.parseInt(str[2]);
			int eng = Integer.parseInt(str[3]);
			int mat = Integer.parseInt(str[4]);
			
			Student stu = new Student(bun,name,kor,eng,mat);
			student[cnt] = stu;
			cnt++;
		}
		//출력
		System.out.println("번호\t이름\t국어\t영어\t수학");
		for (int x = 0; x < cnt; x++) {
			student[x].sPrint();
		}
		scn.close();
	}
}