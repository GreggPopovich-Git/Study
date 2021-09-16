package exam01.util;

public class TestData implements Data {

	@Override
	public int max(int a, int b) {
		
		return (a > b) ? a : b;
	}

	@Override
	public int min(int a, int b) {
		
		return (a < b) ? a : b;
	}
	
	public double max(double a, double b) {
		
		return (a > b) ? a : b;
	}
	
	public double min(double a, double b) {
		
		return (a < b) ? a : b;
	}

}
