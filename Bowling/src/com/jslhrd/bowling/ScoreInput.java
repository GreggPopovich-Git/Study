package com.jslhrd.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreInput {
	boolean try3 = false; // 10프레임 3번째 시도 여부

	public List<Frame> scoreInput() {
		List<Frame> fList = new ArrayList<Frame>();
		Scanner scn = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		// 9 프레임까지의 입력
		for (int x = 0; x < 9; x++) {
			Frame frame = new Frame();
			frame.setTry1(scn.nextInt());
			if (frame.getTry1() == frame.getMAX_PIN()) {
				fList.add(frame);
				frame.setStrike(true);
				continue;
			} else {
				frame.setTry2(scn.nextInt());
				if(frame.getTry1() + frame.getTry2() == 10)
					frame.setSpare(true);
			}
			// 점수 오류 검사
			if (frame.getTry1() < 0 || frame.getTry1() > 10) {
				System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.");
				System.exit(0);
			} else if (frame.getTry2() < 0 || frame.getTry2() > 10) {
				System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.");
				System.exit(0);
			} else if (frame.getTry1() + frame.getTry2() > frame.getMAX_PIN()) {
				System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.");
				System.exit(0);
			}
			fList.add(frame);
		}
		// 10 프레임 입력
		Frame frame = new Frame();
		frame.setTry1(scn.nextInt());
		frame.setTry2(scn.nextInt());
		// 첫번째 시도가 스트라이크 이거나 두번째 시도가 스페어 일 경우 세번째 시도 입력
		if (frame.getTry1() == frame.getMAX_PIN() || frame.getTry1() + frame.getTry2() == frame.getMAX_PIN()) {
			frame.setTry3(scn.nextInt());
			try3 = true;
		}
		// 10프레임 점수 오류 검사
		if (frame.getTry1() < 0 || frame.getTry1() > 10) {
			System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.1");
			System.exit(0);
		} else if (frame.getTry2() < 0 || frame.getTry2() > 10) {
			System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.2");
			System.exit(0);
		} else if (try3) { // 3번째 시도를 했을 때
			if (frame.getTry3() < 0 || frame.getTry3() > 10) {
				System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.3");
				System.exit(0);
			} else if (frame.getTry2() != frame.getMAX_PIN() && frame.getTry1() + frame.getTry2() != frame.getMAX_PIN()) {
				if (frame.getTry2() + frame.getTry3() > frame.getMAX_PIN()) {
					System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.4");
					System.exit(0);
				}
			}
		} else if (!try3) { // 3번째 시도를 안했을 때
			if (frame.getTry1() + frame.getTry2() > frame.getMAX_PIN()) {
				System.out.println("잘못 된 점수 입니다. 프로그램을 종료합니다.5");
				System.exit(0);
			}
		}
		fList.add(frame);
		scn.close();
		return fList;
	}
}
