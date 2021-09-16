// 예외처리 미루기 throws
class InData {
	
	int input() throws Exception {
		int c = System.in.read();
		return c;
	}
}
public class Exam_09 {

	public static void main(String[] args) { 
		InData in = new InData();
		try {
			int s = in.input();
			System.out.println(s);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
