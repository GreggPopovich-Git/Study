package exam01.util;

public class UserProcess implements DataProcess {

	@Override
	public int sum(int... var) {
		int sum = 0;
		for(int x = 0; x < var.length; x++)
			sum += var[x];
		return sum;
	}

	@Override
	public double avg(double... var) {
		double sum = 0;
		double ave = 0.;
		for(int x = 0; x < var.length; x++)
			sum += var[x];
		ave = (int)(sum / var.length * 100 + 0.5) / 100.;
		return ave;
	}

	@Override
	public int max(int a, int b) {
		int max = (a > b) ? a : b;
		return max;
	}

	@Override
	public int max(int... a) {
		int max = a[0];
		for(int x = 0; x < a.length; x++)
			max = (a[x] > max) ? a[x] : max;
		return max;
	}

	@Override
	public int min(int a, int b) {
		int min = (a < b) ? a : b;
		return min;
	}

	@Override
	public int min(int... a) {
		int min = a[0];
		for(int x = 0; x < a.length; x++)
			min = (a[x] < min) ? a[x] : min;
		return min;
	}

	@Override
	public void sortAsc(int[] a) { // 선택정렬 오름차순
		System.out.println("선택정렬 오름차순");
		for (int x = 0; x < a.length-1; x++) {
			for (int y = x + 1; y < a.length; y++) {
				if (a[x] > a[y]) {
					int temp = a[x];
					a[x] = a[y];
					a[y] = temp;
				}
			}
		}
		for (int x = 0; x < a.length; x++)
			System.out.print(a[x] + "\t");
		System.out.println();
	}
	@Override
	public void sortDesc(int[] a) { // 선택정렬 내림차순
		System.out.println("선택정렬 내림차순");
		for (int x = 0; x < a.length-1; x++) {
			for (int y = x + 1; y < a.length; y++) {
				if (a[x] < a[y]) {
					int temp = a[x];
					a[x] = a[y];
					a[y] = temp;
				}
			}
		}
		for (int x = 0; x < a.length; x++)
			System.out.print(a[x] + "\t");
		System.out.println();
	}
	@Override
	public void sortBubbleAsc(int[] a) { // 버블정렬 오름차순
		System.out.println("버블정렬 오름차순");
		for (int x = 0; x < a.length-1; x++) {
			for (int y = 0; y < a.length-x-1; y++) {
				if (a[y] > a[y+1]) {
					int temp = a[y];
					a[y] = a[y+1];
					a[y+1] = temp;
				}
			}
		}
		for (int x = 0; x < a.length; x++)
			System.out.print(a[x] + "\t");
		System.out.println();
	}
	@Override
	public void sortBubbleDesc(int[] a) { // 버블정렬 내림차순
		System.out.println("버블정렬 내림차순");
		for (int x = 0; x < a.length-1; x++) {
			for (int y = 0; y < a.length-x-1; y++) {
				if (a[y] < a[y+1]) {
					int temp = a[y];
					a[y] = a[y+1];
					a[y+1] = temp;
				}
			}
		}
		for (int x = 0; x < a.length; x++)
			System.out.print(a[x] + "\t");
		System.out.println();
	}
}