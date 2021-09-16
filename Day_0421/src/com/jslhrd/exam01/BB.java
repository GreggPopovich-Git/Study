package com.jslhrd.exam01;

public class BB {
	public BB() { // B클래스의 field1 과 method1 은 private 이기 때문에 BB클래스에서 접근 불가능
		B b1 = new B();
		//b1.field1 = 10;
		b1.field2 = 10;
		b1.field3 = 10;
		
		//b1.method1();
		b1.method2();
		b1.method3();
		
	}
}
