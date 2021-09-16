package exam01;

public abstract class Student {
	int bun;
	String name;
	int[] jum;
	int tot;
	double ave;
	
	public Student() {}
	public Student(int bun, String name, int[] jum) {
		this.bun = bun;
		this.name = name;
		this.jum = jum;
	}
	public void titlePrint() {
		System.out.println("번호\t이름\t총점\t평균");
	}
	public abstract void account(); // 총점, 평균(소수이하 2자리)계산
	public abstract void scoreMax(); // 점수의 최대 최소값 출력
	public abstract void scoreSelection(); // 선택정렬을 이용한 점수 오름차순
	public abstract void scoreBubble(); // 버블정렬을 이용한 점수 내림차순
}
