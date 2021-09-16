import com.jslhrd.util.Student;

public class Exam_02 {

	public static void main(String[] args) {
		String hakbun = "1101";
		String name = "김학생";
		int[] score = {97,66,78,89,96,88};
		
		Student stu = new Student(hakbun,name,score);
		stu.titlePrint();
		//학년	반	번호	 이름	     총점	평균	     비고
		// 1	1	01	김학생     xxx   xx.x  수~가
		
	}

}
