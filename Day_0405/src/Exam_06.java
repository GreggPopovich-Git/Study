/* num = {30,67,55,79,97,65,33,78,96,58,94,32}
 * 저장되어 있을 경우 최대 최소를 뺀 나머지 합계를 구하여 출력
 * [출력형식]
 * Data : 30,67,55,79,97,65,33,78,96,58,94,32
 * 최대 : 
 * 최소 : 
 * 합계 :
 */
public class Exam_06 {
	public static void main(String[] args) {
		int num[] = {30,67,55,79,97,65,33,78,96,58,94,32};
		int max = num[0];
		int min = num[0];
		int tot = 0;
		System.out.print("Data : ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
			tot += num[i];
		}
		System.out.println();
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		System.out.println("합계 : " + (tot-max-min));

	}

}
