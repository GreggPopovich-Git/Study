package com.jslhrd.weight;
public class StudentCal {
	int cnt, clas, num, wei, max = -999, min = 999;
	StudentCal(){}
	StudentCal(int clas, int num, int wei){
		this.clas = clas;
		this.num = num;
		this.wei = wei;
	}
	//sort
	public void sort(StudentCal stu[], int cnt) {
		for (int x = 0; x < cnt-1; x++) {
			for (int y = x+1; y < cnt; y++) {
				if (stu[x].clas > stu[y].clas) {
					StudentCal temp = stu[x];
					stu[x] = stu[y];
					stu[y] = temp;
				}
			}
		}
	}
	//print
	public void print(StudentCal stu[], int cnt) {
		System.out.println("반\t번호\t체중");
		for (int x = 0; x < cnt; x++) {
			if (x != 0 && stu[x].clas == stu[x-1].clas) {
				System.out.print("\t");
			}
			else
				System.out.print(stu[x].clas + "\t");
			System.out.println(stu[x].num + "\t" + stu[x].wei);
		}
	}
	//max,min
	public void maxmin(StudentCal stu[], int cnt) {
		for (int x = 0; x < cnt; x++) {
			max = (max >= stu[x].wei) ? max : stu[x].wei;
			min = (min <= stu[x].wei) ? min : stu[x].wei;
		}
		System.out.println("최소체중 : " + min);
		System.out.println("최대체중 : " + max);
	}
}