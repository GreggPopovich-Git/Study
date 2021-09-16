import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_05 {

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-EEEE");
		SimpleDateFormat sdf2 = new SimpleDateFormat("a-hh:mm:ss");
		System.out.println(sdf1.format(now));
		System.out.println(sdf2.format(now));
		
	}

}
