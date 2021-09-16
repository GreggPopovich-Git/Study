package sawon;
import java.util.Scanner;
public class SawonPayExam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Sawon[] sa = new Sawon[10];
		int cnt = 0;
		for (int x = 0; x < sa.length; x++) {
			System.out.print("사원 등록 : ");
			String id = scn.next();
			if (id.equalsIgnoreCase("end"))
				break;
			int clas = scn.nextInt();
			int time = scn.nextInt();
			sa[x] = new Sawon(id, clas, time);
			cnt++;
		}	
		SawonPay mm = new SawonPay();
		mm.print(sa, cnt);
		scn.close();
	}
}