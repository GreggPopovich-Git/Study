// Object 클래스 - 최상위 클래스 (모든클래스는 Object 클래스로부터 상속받아서 생성됨)
class AA {
	int x;
	AA() {}
	AA(int x) {
		this.x = x;
	}
	@Override
	public boolean equals(Object obj) { // 두 객체가 동일한 객체인지 equals를 이용하여 비교하는 방법. 예) 회원정보가 중복되는걸 방지
		if (obj != null && obj instanceof AA)
			return x == ((AA)obj).x; // 강제 형변환
		else return false;
	}
}
public class Exam_01 {
	public static void main(String[] arg) {
		AA a1 = new AA();
		AA a2 = new AA();
		AA a3 = new AA(10);
		AA a4 = new AA(10);
		System.out.println("a1 == a2" + "\t" + (a1 == a2));
		System.out.println("a1.equals(a2)" + "\t" + (a1.equals(a2)));
		System.out.println("a1.equals(a3)" + "\t" + (a1.equals(a3)));
		System.out.println("a3.equals(a4)" + "\t" + (a3.equals(a4)));
	}
}
