package com.jslhrd.util;

public abstract class Person {
	String name;
	String birth;
	
	public Person(String name, String birth) {
		this.name = name;
		this.birth = birth;
	}
	
	public abstract int getAge();
}
