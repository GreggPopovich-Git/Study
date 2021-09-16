package com.jslhrd.user;

import java.util.Scanner;

import com.jslhrd.util.Data;
import com.jslhrd.util.DataPro;

public class DataExam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String data[] = new String[10];
		for(int x = 0; x < data.length; x++) {
			System.out.print("영문단어 입력 : ");
			String imsi = scn.next();
			if (imsi.equalsIgnoreCase("end"))
				break;
			data[x] = imsi;
		}
		Data aa = new DataPro(data);
		System.out.println();
		aa.alphaPrint();
		System.out.println();
		aa.alphaCount();
		System.out.println();
		aa.alphaDesc();
		scn.close();
	}

}