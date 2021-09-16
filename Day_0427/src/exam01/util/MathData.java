package exam01.util;

public class MathData implements Data {

	@Override
	public int max(int a, int b) {
		
		return (a > b) ? a : b;
	}

	@Override
	public int min(int a, int b) {
		
		return (a < b) ? a : b;
	}

}
