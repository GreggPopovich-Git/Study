package dept;
public class SawonProcess {
	Sawon[] sawon; // 배열 주소 저장
	int cnt;
	
	SawonProcess(){}
	SawonProcess(Sawon[] sawon, int cnt) {
		this.sawon = sawon;
		this.cnt = cnt;
	}
	public void sawonPrint() {
		int sumpay = 0;
		int totpay = 0;
		System.out.println("부서\t이름\t사번\t급여");
		for (int x = 0; x < cnt; x++) {
			if (x != 0 && sawon[x].bu.equals(sawon[x-1].bu))
				System.out.print("\t");
			else if(x != 0) {
				System.out.println("합계 : \t\t\t" + sumpay);
				sumpay = 0;
				System.out.print(sawon[x].bu + "\t");
			}
			else
				System.out.print(sawon[x].bu + "\t");
			System.out.println(sawon[x].name + "\t" + sawon[x].sabun + "\t" + sawon[x].pay);
			sumpay += sawon[x].pay;
			totpay += sawon[x].pay;
		}
		System.out.println("합계 : \t\t\t" + sumpay);
		System.out.println("총합계 : \t\t\t" + totpay);
	}
}