package setexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoArray {
	LottoArray(){
		lottoPrint();
	}
	private void lottoPrint() {
		int[] arr = new int[6];
		for (int x = 0; x < arr.length; x++) {
			arr[x] = (int)(Math.random() * 45) + 1;
			for(int y = 0; y < x - 1; y++) {
				if (arr[x] == arr[y]) {
					x--;
				}
			}
		}
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				if(arr[x] > arr[y]) {
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
		System.out.print("로또번호(Array) : ");
		for (int x : arr) {
			System.out.print(x + "\t");
		}
	}
	
}
class LottoList {
	LottoList(){
		lottoPrint();
	}
	private void lottoPrint() {
		List<Integer> list = new ArrayList<Integer>();
		for (int x = 0; list.size() < 6; x++) {
			int num = (int)(Math.random() *45) + 1;
			if (!(list.contains(num)))
				list.add(num);
		}
		Collections.sort(list);
		System.out.println("로또번호(List) : " + list);
	}
}
class LottoSet {
	LottoSet(){
		lottoPrint();
	}
	private void lottoPrint() {
		Set<Integer> lotto = new HashSet<Integer>();
		for (int x = 0; lotto.size() < 6; x++) {
			int num = (int)(Math.random() * 45) + 1;
			lotto.add(new Integer(num));
		}
		List<Integer> list = new ArrayList<Integer>(lotto);
		Collections.sort(list);
		System.out.println("로또번호(Set) : " + list);
	}
	
}
public class Exam_04 {

	public static void main(String[] args) {
		LottoSet set = new LottoSet();
		LottoList list = new LottoList();
		LottoArray arr = new LottoArray();
	}

}
