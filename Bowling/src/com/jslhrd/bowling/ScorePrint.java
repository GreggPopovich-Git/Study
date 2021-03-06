package com.jslhrd.bowling;

import java.util.List;

public class ScorePrint {

	public void scorePrint(List<Frame> fList, boolean try3) {
		// 회차 출력
		for (int x = 0; x < fList.size() - 1; x++) {
			System.out.print("|  " + (x + 1) + " 회\t");
		} System.out.println("|    10회         |");
		// 점수 출력
		for (int x = 0; x < fList.size() - 1; x++) {
			if (fList.get(x).getTry1() != 10)
				System.out.print("| " + fList.get(x).getTry1() + " | " + fList.get(x).getTry2() + "\t");
			else
				System.out.print("|Strike\t");
		} System.out.print("|");
		System.out.print(" " + fList.get(9).getTry1() + " | ");
		System.out.print(fList.get(9).getTry2() + " | ");
		if(try3) {
			System.out.print(fList.get(9).getTry3());
		} else {
			System.out.print("    ");
		}
		System.out.println(" |");
		// 회차 별 소계 출력
		for (int x = 0; x < fList.size() - 1; x++) {
			System.out.print("|  " + fList.get(x).getSubtot() + " 점\t");
		}
		System.out.println("|    " + fList.get(9).getSubtot() + " 점        |");
	}
}
