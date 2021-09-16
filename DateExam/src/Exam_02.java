import java.util.Calendar;

public class Exam_02 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//System.out.println(Calendar.YEAR);
		System.out.println(cal.get(Calendar.YEAR));
		int year = cal.get(Calendar.YEAR); // 년
		int month = cal.get(Calendar.MONTH) + 1; // java에서는 월이 0~11 까지임.
		int day = cal.get(Calendar.DATE); // 일
		int y = cal.get(Calendar.DAY_OF_WEEK); // 요일  0 = 일요일, 6 = 토요일
		System.out.println("요일 : " + y);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int ampm = cal.get(Calendar.AM_PM); // 오전 = 0, 오후 = 1
		
		System.out.print("현재 시각은 " + year + "년 " + month + "월 "  + day + "일 ");
		if (ampm == Calendar.AM) {
			System.out.print("오전 ");
		}
		else
			System.out.print("오후 ");
		System.out.println(hour + "시 "  + min + "분 "  + sec + "초 ");
	}

}