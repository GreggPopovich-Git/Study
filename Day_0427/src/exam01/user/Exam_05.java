package exam01.user;

import exam01.util.UserProcess;
import exam01.util.DataProcess;

public class Exam_05 {

	public static void main(String[] args) {
		DataProcess x = new UserProcess();
		int max, min, sum;
		double ave;
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		sum = x.sum(1,2,3,4,5,6,7,8,9,10);
		System.out.println("sum = " + sum);
		double[] b = {1.1,2.2,3.3,4.4,5.5,6.6};
		ave = x.avg(b);
		System.out.println("ave = " + ave);
		max = x.max(1,10);
		System.out.println("max = " + max);
		max = x.max(1,2,3,4,5,6,7,8,9,10);
		System.out.println("max = " + max);
		min = x.min(1,10);
		System.out.println("min = " + min);
		min = x.min(a);
		System.out.println("min = " + min);
		x.sortAsc(a);
		x.sortDesc(a);
		x.sortBubbleAsc(a);
		x.sortBubbleDesc(a);
		
	}

}