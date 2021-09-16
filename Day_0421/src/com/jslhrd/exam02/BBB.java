package com.jslhrd.exam02;

import com.jslhrd.exam01.B;

public class BBB {
	BBB() { // public 은 패키지가 달라도 접근 가능.(import 필요함) 다른건 접근 불가능.
	B b1 = new B();
	//b1.field1 = 100;
	//b1.field2 = 100;
	b1.field3 = 100;
	
	//b1.method1();
	//b1.method2();
	b1.method3();
	}
}
