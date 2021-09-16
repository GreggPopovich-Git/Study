package com.jslhrd.exam01;
	
public class A {
	A a1 = new A();
	A a2 = new A(100);
	A a3 = new A("AAA");
	
	private A() {}
	A(int a) {}
	public A(String a) {}
	
}