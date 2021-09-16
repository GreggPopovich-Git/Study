package exam01.user;

import exam01.util.Action;

class ActionExam implements Action {

	@Override
	public void work() {
		System.out.println("작업을 수행합니다.");
		
	}
	
}
public class Exam_03 {

	public static void main(String[] args) {
		Action act = new ActionExam();
		act.work();
		
	}

}
