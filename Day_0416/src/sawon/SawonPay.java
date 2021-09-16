package sawon;
public class SawonPay {
	Sawon[] sa;
	int cnt;
	SawonPay(){}
	SawonPay(Sawon[] sa, int cnt) {
		this.sa = sa;
		this.cnt = cnt;
	}
	public void print(Sawon sa[], int cnt) {
		int sumtime = 0;
		int sumpay = 0;
		int max = -99;
		int check = 0;
		System.out.println("아이디\t등급\t시급\t근무시간\t주간급여");
		for (int x = 0; x < cnt; x++) {
			System.out.println(sa[x].id + "\t" + sa[x].clas + "\t" + sa[x].pay + "\t" + sa[x].time + "\t" + sa[x].weekpay);
			sumtime += sa[x].time;
			sumpay += sa[x].weekpay;
			if (sa[x].weekpay > max) {
				max = sa[x].weekpay;
				check = x;
			}
		}
		System.out.println("합계 \t\t\t" + sumtime + "\t" + sumpay);
		System.out.println("주간 급여를 가장 많이 받는 사원(가장 먼저 짤라야 하는 사원)");
		System.out.println("아이디\t주간급여");
		System.out.println(sa[check].id + "\t" + sa[check].weekpay);
	}
}