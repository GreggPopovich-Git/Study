package com.jslhrd.bowling;

import java.util.ArrayList;
import java.util.List;

public class RunBowling {

	public static void main(String[] args) {
		ScoreInput si = new ScoreInput();
		ScoreCal sc = new ScoreCal();
		ScorePrint sp = new ScorePrint();
		List<Frame> fList = new ArrayList<Frame>();
		fList = si.scoreInput(); // 점수 입력 메소드
		int tot = sc.scoreCal(fList); // 점수 계산 메소드
		
		sp.scorePrint(fList,si.try3); // 점수표 출력

		System.out.println("총점 : " + tot); // 총점 출력
	}
}