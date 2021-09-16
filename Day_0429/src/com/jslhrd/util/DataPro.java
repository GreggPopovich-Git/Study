package com.jslhrd.util;

public class DataPro extends Data {
	public DataPro(String[] data) {
		super(data);
	}
	@Override
	public void alphaCount() {
		System.out.println("알파벳 개수 출력");
		int alpabet[] = new int[26];
		for (int x = 0; x < data.length; x++) {
			if (data[x] == null)
				break;
			for (int y = 0; y < data[x].length(); y++) {
				int ch = data[x].toUpperCase().charAt(y);
				alpabet[(ch-65)]++;
			}
		}
		for (char alpa = 65; alpa < 91; alpa++)
			System.out.print(alpa + "\t");
		System.out.println();
		for (int x = 0; x < alpabet.length; x++)
			System.out.print(alpabet[x] + "\t");
		System.out.println();
	}
	@Override
	public void alphaDesc() {
		System.out.println("알파벳 거꾸로 출력");
		for (int y = 0; y < data.length; y++) {
			if (data[y] == null)
				break;
			System.out.print(data[y] + " : ");
			for (int x = data[y].length()-1; x >= 0; x--) {
				char ch = data[y].charAt(x);
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	public void alphaPrint() {
		System.out.println("영문자 분리하기");
		for (int y = 0; y < data.length; y++) {
			if (data[y] == null)
				break;
			System.out.print(data[y] + " : ");
			for (int x = 0; x < data[y].length(); x++) {
				char ch = data[y].charAt(x);
				System.out.print(ch + "\t");
			}
		System.out.print("\n");
		}
	}
}