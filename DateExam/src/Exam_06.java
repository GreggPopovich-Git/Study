import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Exam_06 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now(); // 오늘 날짜
		LocalTime time = LocalTime.now(); // 현재 시간
		LocalDateTime datetime = LocalDateTime.now(); // 오늘 날짜, 시간
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(datetime);
		
	}

}
