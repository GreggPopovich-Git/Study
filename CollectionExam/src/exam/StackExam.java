package exam;

import java.util.Stack;
// push() -> 삽입
// pop() --> 제거
// peek() -> 맨 위 반환 제거 x
class Coin {
	private int value;
	Coin(int value) {
		this.value = value;
	}
	int getValue() {
		return value;
	}
}
public class StackExam {
	public static void main(String[] args) {
		Stack<Coin> stack = new Stack<Coin>();
		stack.push(new Coin(100));
		stack.push(new Coin(200));
		stack.push(new Coin(300));
		stack.push(new Coin(400));
		stack.push(new Coin(500));
		System.out.println("스택 객체 수 : " + stack.size());
		Coin c = stack.peek(); // 맨 위 객체 반환, 제거 x
		System.out.println("맨 위 객체 : " + c.getValue());
		System.out.println("스택 객체 수 : " + stack.size());
		c = stack.pop(); // 현재 위치의 객체 반환, 제거 o
		System.out.println("현재 객체 : " + c.getValue());
		System.out.println("스택 객체 수 : " + stack.size());
		// 스택 모두 제거하기
		while(!stack.isEmpty()) {
			c = stack.pop();
			System.out.println("꺼내온 동전 : " + c.getValue());
		}
		System.out.println("스택 객체 수 : " + stack.size());
	}

}