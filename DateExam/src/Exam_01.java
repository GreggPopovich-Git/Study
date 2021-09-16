import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_01 {

	public static void main(String[] args) {
		Date now = new Date(); // 날짜와 시간을 다루는 클래스
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); // 날짜 형식 클래스
		String now2 = sdf.format(now);
		System.out.println(now2);
		
	}

}
