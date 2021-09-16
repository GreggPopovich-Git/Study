package exam01;
class Parent {
	int bun;
	String name;
	
	void print() {
		System.out.print(bun + "\t" + name);
	}
}
class Child extends Parent {
	int kor,eng,mat,tot;
	
	Child(int bun, String name, int kor, int eng, int mat) {
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
	}
	void dataPrint() {
		System.out.print(bun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot);
	}
}
public class Exam_03 {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.bun = 1;
		p.name = "김학생";
		p.print();
		System.out.println();
		
		Child c = new Child(1,"AAA",99,88,77);
		c.print();
		System.out.println();
		c.dataPrint();
	}
}