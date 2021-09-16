// protected 는 클래스에 사용하지 않음. 같은 패키지, 상속관계에서 사용가능
package com.jslhrd.exam01;
	
public class AA {
	// A a1 = new A(); // private 은 같은 클래스 내에서만 사용가능
	A a2 = new A(100); // default 는 같은 패키지 안에서는 사용가능
	A a3 = new A("AAA"); // public 은 모든 영역에서 사용가능
}
