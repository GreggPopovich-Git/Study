// Escape 문자 \n , \t , \r , \' , \\ , \"
public class Exam_02 {
	public static void main(String[] args) {
		System.out.print("seoul\t Korea\n");
		System.out.print("seoul\n Korea\n");
		System.out.print("seoul\r Korea\n");
		System.out.print("\'seoul\' Korea\n");
		System.out.print("\"seoul\" Korea\n");
		System.out.print("seoul\\ Korea\n");
		char ch = '\n';
		System.out.print("aaaa" + ch);
		System.out.print("bbbb" + ch);
		
		System.out.println("번호            이름            국어            영어            수학            총점            평균");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
	}

}
