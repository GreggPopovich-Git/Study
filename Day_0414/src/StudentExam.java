
public class StudentExam {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.bun = 100;
		st1.name = "홍길동";
		st1.kor = 95;
		st1.eng = 85;
		st1.mat = 95;
		
		st1.totAve();
		st1.sPrint();
		
		Student st2 = new Student(1,"김학생",90,80,90);
		st2.totAve();
		st2.sPrint();
		
	}

}
