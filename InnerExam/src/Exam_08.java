
public class Exam_08 {

	public static void main(String[] args) {
		int[] score = {1,2,3};
		
		try {
			System.out.println(score[1]);
			System.out.println(score[3]);
		} catch (Exception e) {
			System.out.println("배열 첨자가 너무 큽니다.");
			e.printStackTrace();
		} finally {
			System.out.println("시스템을 종료합니다.");
			System.out.println(score[0]);
		}
		System.out.println(score[0]);
	}

}
