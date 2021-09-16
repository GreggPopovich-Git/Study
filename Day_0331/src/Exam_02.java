// 1+2+3+4+5+6+...+10
public class Exam_02 {
	public static void main(String[] args) {
		int i = 0;
		int s = 0;
/*		do {
			i++;
			s+=i;
		}while (i<10);
		System.out.println(s);
		
		while (true) {
			i++;
			s+=i;
			if (i==10) {
				break;
				// continue; //반복계속(조건식으로 이동)
			}
		}
		System.out.println(s);
*/
		while (i<10) {
			i++;
			s+=i;
		}
		System.out.println(s);
	}

}