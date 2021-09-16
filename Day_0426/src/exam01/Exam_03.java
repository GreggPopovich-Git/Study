package exam01;
class StudentHak extends Student {
	int max;
	int min;
	StudentHak() {}
	StudentHak(int bun, String name, int[] jum) {
		super(bun,name,jum);
	}
	@Override
	public void account() { // 총점, 평균(소수이하 2자리)계산
		for (int x = 0; x < jum.length; x++) {
			tot += jum[x];
		}
		ave = (int)(tot / (double)jum.length * 100 + 0.5) / 100.;
	}@Override
	public void scoreMax() { // 점수의 최대 최소값 출력
		max = jum[0];
		min = jum[0];
		for (int x = 0; x < jum.length; x++) {
			max = (jum[x] > max) ? jum[x] : max;
			min = (jum[x] < min) ? jum[x] : min;
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}@Override
	public void scoreSelection() { // 선택정렬을 이용한 점수 오름차순
		for (int x = 0; x < jum.length-1; x++) { //기준
			for (int y = x + 1; y < jum.length; y++) { //비교대상
				if (jum[x] > jum[y]) {
					int temp = jum[x];
					jum[x] = jum[y];
					jum[y] = temp;
				}
			}
		}
		for (int x = 0; x < jum.length; x++) {
			System.out.print(jum[x] + "\t");
		}
	}@Override
	public void scoreBubble() { // 버블정렬을 이용한 점수 내림차순
		for (int x = 0; x < jum.length-1; x++) {
			for (int y = 0; y < jum.length-x-1; y++) {
				if (jum[y] < jum[y+1]) {
					int temp = jum[y];
					jum[y] = jum[y+1];
					jum[y+1] = temp;
				}
			}
		}
		for (int x = 0; x < jum.length; x++) {
			System.out.print(jum[x] + "\t");
		}
	}
	public void print() {
		System.out.println(bun + "\t" + name + "\t" + tot + "\t" + ave);
	}
}
public class Exam_03 {
	public static void main(String[] args) {
		int bun = 1101;
		String name = "김학생";
		int[] score = {95,88,67,68,46,74,88,98,65,48,70,89};
		StudentHak stu = new StudentHak(bun,name,score);
		
		stu.account();
		stu.scoreMax();
		stu.titlePrint();
		stu.print();
		System.out.println("선택정렬");
		stu.scoreSelection();
		System.out.println();
		System.out.println("버블정렬");
		stu.scoreBubble();
		
	}

}