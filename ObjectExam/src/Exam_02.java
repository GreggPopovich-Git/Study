import java.util.Scanner;

// toString() 객체를 문자열로 변환
class BB {
	int bun;
	String name;
	BB(){}
	BB(int bun, String name) {
		this.bun = bun;
		this.name = name;
	}
	@Override
	public String toString() {
		
		return bun + "\t" + name;
	}
}

public class Exam_02 {
	public static void main(String[] args) {
		BB b = new BB(1101,"김학생");
		System.out.println(b);
		String str = new String("AAAA");
		System.out.println(str);
		Scanner scn = new Scanner(System.in);
		System.out.println(scn);
	}

}
