package exam01.util;

public class MathProcess implements Process {
	@Override
	public int sum(int... var) {
		int sum = 0;
		for(int x = 0; x < var.length; x++) // for(int x : var)  - 확장 for문
			sum += var[x];
		return sum;
	}

	@Override
	public double avg(double... var) {
		int sum = 0;
		double avg = 0.;
		for(int x = 0; x < var.length; x++)
			sum += var[x];
		avg = (int)(sum / var.length * 100 + 0.5) / 100.;
		return avg;
	}

	@Override
	public int max(int a, int b) {
		
		return (a > b) ? a : b;
	}

	@Override
	public int max(int... a) {
		int max = a[0];
		for (int x = 0; x < a.length; x++)
			if (a[x] > max)
				max = a[x];
		return max;
	}

	@Override
	public int min(int a, int b) {
		
		return (a < b) ? a : b;
	}

	@Override
	public int min(int... a) {
		int min = a[0];
		for (int x = 0; x < a.length; x++)
			if (a[x] < min)
				min = a[x];
		return min;
	}
}