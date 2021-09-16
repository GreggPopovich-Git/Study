import java.util.Scanner;

class Sawon {
	int sabun;
	String name;
	int pay;
	Sawon(){}
	Sawon(int sabun, String name, int pay){
		this.sabun = sabun;
		this.name = name;
		this.pay = pay;
	}
	public void print() {
		System.out.println(sabun + "\t" + name + "\t" + pay);
	}
}
class SawonData {
	//Sort
	public void dataSort(Sawon[] ss, int cnt) {
		for (int x = 0; x < cnt-1; x++) {
			for (int y = x+1; y < cnt; y++) {
				if(ss[x].sabun > ss[y].sabun) {
					Sawon temp = ss[x];
					ss[x] = ss[y];
					ss[y] = temp;
				}
			}
		}
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		Sawon sa[] = new Sawon[10]; //객체(클래스) 배열
		Scanner scn = new Scanner(System.in);
		int cnt = 0;
		while (true) {
			System.out.print("사원등록 : ");
			int bun = scn.nextInt(); //사원번호
			if (bun == 0)
				break;
			String name = scn.next(); //이름
			int pay = scn.nextInt(); //급여
			//Sawon s = new Sawon(bun, name, pay);
			//sa[cnt] = s;
			sa[cnt] = new Sawon(bun,name,pay);
			cnt++;
		}
		SawonData sad = new SawonData();
		sad.dataSort(sa,cnt);
		//출력
		for (int x = 0; x < cnt; x++) {
			sa[x].print();
		}
		scn.close();
		
	}

}