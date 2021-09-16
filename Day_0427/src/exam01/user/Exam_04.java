package exam01.user;

import exam01.util.Action;

public class Exam_04 {

	public static void main(String[] args) {
		Action act = new Action() { // 익명 구현개체
			@Override
			public void work() {
				System.out.println("작업을 수행합니다.");
			}
			
		};
		act.work();
		
	}

}
