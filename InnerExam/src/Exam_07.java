import java.io.IOException;

/* try {
 * 		// 예외가 발생가능한 코드
 * }catch() {
 * 예외가 발생 했을 때 메시지 출력
 * }catch() {
 * 
 * }finally() {
 * 		// 예외 발생과 상관없이 처리해야할 코드
 * }
 * 
 */
public class Exam_07 {

	public static void main(String[] args) {
		int num = 0;
		
		System.out.print("1문자 입력 : ");
		try {
			num = System.in.read();
		} catch (IOException ioe) {
			System.out.println("입출력 오류 : " + ioe.getMessage());
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("프로그램이 자동 종료됩니다.");
		}
		
		System.out.print("num = " + num);
		
	}

}
