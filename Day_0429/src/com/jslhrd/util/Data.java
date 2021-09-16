package com.jslhrd.util;

public abstract class Data {
	String data[];
	public Data(String data[]) {
	this.data = data;
	}
	public void alphaPrint() {
		System.out.println("영문자 분리하기");
		for (int y = 0; y < data.length; y++) {
			System.out.print(data[y] + " : ");
			for (int x = 0; x < data[y].length(); x++) {
				char ch = data[y].charAt(x);
				System.out.print(ch + "\t");
			}
		System.out.print("\n");
		}
	}
	// 영문자 빈도수 카운트
	public abstract void alphaCount();
	// 각 영문자별 역순 출력
	public abstract void alphaDesc();
}