//final -> 상수
class CC {
	final double PI = 3.14; // 변수를 다른 곳에서 바꾸지 못하게 상수화 함. final
}
public class Exam_03 {
	public static void main(String[] args) {
		CC c1 = new CC();
		System.out.println(c1.PI);
		double a = 3 * c1.PI;
		System.out.println(a);
		
		// c1.PI = 100; 상수화 되면 값을 바꿀 수 없음.
		System.out.println(c1.PI);
		CC c2 = new CC();
		System.out.println(c2.PI);
	}

}
