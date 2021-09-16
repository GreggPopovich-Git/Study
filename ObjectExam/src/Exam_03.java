// hashCode() - 객체가 생성될 때 생성되는 고유값 (해쉬코드가 같으면 서로 같은 객체) - 참조주소와 다름. 동일개체인지 판별 하는데 사용.
// hashCode의 오버라이딩 - 공부해야함.
class CC {
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
class DD {
	
}
public class Exam_03 {
	public static void main(String[] args) {
		CC c1 = new CC();
		CC c2 = new CC();
		DD d1 = new DD();
		DD d2 = new DD();
		
		System.out.println("c1 = " + c1.hashCode());
		System.out.println("c2 = " + c2.hashCode());
		System.out.println("d1 = " + d1.hashCode());
		System.out.println("d2 = " + d2.hashCode());
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
	}

}