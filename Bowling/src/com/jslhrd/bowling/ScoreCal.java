package com.jslhrd.bowling;

import java.util.List;

public class ScoreCal {

	public int scoreCal(List<Frame> fList) {
		// 프레임 별 점수 계산
		for (int x = 0; x < fList.size(); x++) {
			int sum = 0;
			fList.get(x).setSubtot(fList.get(x).getTry1() + fList.get(x).getTry2() + fList.get(x).getTry3());
			if (x != 9) { // 1~9 프레임
				if (fList.get(x).isStrike()) { // 스트라이크 일 때
					if (fList.get(x + 1).isStrike()) { // 다음 프레임도 스트라이크 일 때
						sum = fList.get(x).getSubtot() + fList.get(x + 1).getTry1() + fList.get(x + 2).getTry1();
						fList.get(x).setSubtot(sum);
					} else {
						sum = fList.get(x).getSubtot() + fList.get(x + 1).getTry1() + fList.get(x + 1).getTry2();
						fList.get(x).setSubtot(sum);
					}
				} else if (fList.get(x).isSpare()) { // 스페어 일 때
					sum = fList.get(x).getSubtot() + fList.get(x + 1).getTry1();
					fList.get(x).setSubtot(sum);
				}
			}
		}
		// 총점 계산
		int tot = 0;
		for (int x = 0; x < fList.size(); x++) {
			tot += fList.get(x).getSubtot();
		}
		return tot;
	}
}
