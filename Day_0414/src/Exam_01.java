
public class Exam_01 {
	public static void main(String[] args) {
		Point pt;
		//객체(인스턴스)생성 new 연산자
		pt = new Point();
		pt.x = 100;
		pt.y = 200;
		pt.xPrint();
		pt.yPrint();
		
		System.out.println();
		
		Point pt2 = new Point();
		pt2.x = 500;
		pt2.y = 1000;
		pt2.xPrint();
		pt2.yPrint();
		
	}
}