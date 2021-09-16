package exam01;
class B {
	int bun;
	String name;
	B (int bun, String name) {
		this.bun = bun;
		this.name = name;
	}
	void print() {
		System.out.print(bun + "\t" + name + "\t");
	}
}
class BB extends B {
	int kor, eng, mat, tot;
	
	BB (int bun, String name, int kor, int eng, int mat) {
		super(bun,name);
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
	}
	void print() {
		super.print();
		System.out.println(kor + "\t" + eng + "\t" + mat + "\t" + tot);
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		BB bb = new BB(1,"김학생",90,88,90);
		bb.print();
		// 1 김학생 90 88 90 268
	}
}