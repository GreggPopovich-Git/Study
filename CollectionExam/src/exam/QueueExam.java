package exam;

import java.util.LinkedList;
import java.util.Queue;
// offer("객체") - 삽입
// poll() - 제거
// peek() - 스택과 마찬가지
// overflow - 용량이 넘침
// underflow - 데이터가 모두 없어짐
public class QueueExam {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<String>();
		que.offer("AAAA");
		que.offer("BBBB");
		que.offer("CCCC");
		que.offer("DDDD");
		System.out.println(que.size());
		while(!que.isEmpty()) {
			Object obj = que.poll();
			System.out.println(obj);
		}
		System.out.println(que.size());
	}

}