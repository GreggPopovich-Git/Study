package exam01.util;

public interface Process {
	// 합계계산
	int sum(int ... var); // 가변인자 - 배열
	// 평균
	double avg(double ... var);
	// 최대값
	int max(int a, int b);
	int max(int ... a);
	// 최소값
	int min(int a, int b);
	int min(int ... a);
}
