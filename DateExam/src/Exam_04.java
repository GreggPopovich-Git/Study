import java.text.DecimalFormat;

public class Exam_04 {

	public static void main(String[] args) {
		Double val = 12341234.567;
		DecimalFormat df1 = new DecimalFormat("0,000.0000"); // 소수점 아래 값이 없어도 0을 출력.
		DecimalFormat df2 = new DecimalFormat("#,###.####"); // 자동 반올림. 자리수 초과해도 자동 추가.
		System.out.println(df1.format(val));
		System.out.println(df2.format(val));
		
	}

}
