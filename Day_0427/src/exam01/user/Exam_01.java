package exam01.user;

import exam01.util.*;

public class Exam_01 {

	public static void main(String[] args) {
		MathData data = new MathData();
		int max = data.max(10, 20);
		System.out.println("max = " + max);
		int min = data.min(10, 20);
		System.out.println("min = " + min);
		
		TestData tData = new TestData();
		
		Data d = new MathData();
		Data dd = new TestData();
		
		
	}
}