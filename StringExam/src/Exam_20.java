import java.util.StringTokenizer;
// StringTokenizer : 구분자가 여러개 일때 토큰 여러개를 생성해서 각 토큰에 자료를 순차적으로 저장해줌. 배열이 아님
public class Exam_20 {

	public static void main(String[] args) {
		String str = "111,222,333 444-555,666-777,888";
		StringTokenizer st = new StringTokenizer(str,",- "); // ',', '-', ' ' 세개의 구분자를 이용해 구분해줌.
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
	}
}