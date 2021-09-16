import java.util.Scanner;

public class Test {
	public static void main(String[] args) { 
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 1 ; i < n+1 ; i++) {
			for (int k = n ; k > i ; k--) {
				System.out.print(" ");
			}
			for (int j = 1 ; j < i+1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scn.close();
	}
}
