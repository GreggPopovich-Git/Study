// 객체소멸자 finalize()
class Counter {
	int no;
	Counter(int no) {
		this.no = no;
		System.out.println("Counter 객체" + no + "생성");
	}
	@Override
	protected void finalize() throws Throwable { // 객체가 소멸 되기 전에 반드시 해야 하는 작업을 할 수 있는 메소드
		System.out.println("Counter 객체" + no + "제거작업");
	}
}
public class Exam_08 {

	public static void main(String[] args) {
		Counter counter = null;
		for (int x = 0; x < 50; x++) {
			counter = new Counter(x);
			counter = null;
			System.gc(); // 사용하지 않는 객체를 제거 garbage collector 바로 제거 되는 건 아님. 제거 요청일 뿐.
			
		}
		
	}

}