// 진법변환
// Integer 클래스 활용
public class Exam_08 {
	public static void main(String[] args) {
		int su = 25;
		
		String bin = Integer.toBinaryString(su);
		System.out.println("2진수 : " + bin);
		
		String oct = Integer.toOctalString(su);
		System.out.println("8진수 : " + oct);
		
		String hex = Integer.toHexString(su);
		System.out.println("16진수 : " + 	hex);
		
		int binDec = Integer.parseInt(bin, 2);
		int octDec = Integer.parseInt(oct, 8);
		int hexDec = Integer.parseInt(hex, 16);
		
		System.out.println("2진수 : " + bin + "는 10진수 : " + binDec);
		System.out.println("8진수 : " + oct + "는 10진수 : " + octDec);
		System.out.println("16진수 : " + hex + "는 10진수 : " + hexDec);
		
		
	}

}
