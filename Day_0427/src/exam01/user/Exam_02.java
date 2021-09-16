package exam01.user;

import exam01.util.MathProcess;
import exam01.util.Process;

public class Exam_02 {

	public static void main(String[] args) {
		Process pro = new MathProcess();
		int sum = pro.sum(1,2,3,4,5);
		System.out.println("sum = " + sum);
		
		double ave = pro.avg(1,2,3,4,5);
		System.out.println("avg = " + ave);
		
		int max = pro.max(79,88);
		System.out.println("max = " + max);
		
		max = pro.max(79,88,77,55,99,70);
		System.out.println("max = " + max);
		
		int min = pro.min(79,88);
		System.out.println("min = " + min);
		
		min = pro.min(79,88,77,55,99,70);
		System.out.println("min = " + min);
	}

}
