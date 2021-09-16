package com.jslhrd.bowling;

public class Frame { // 한프레임
	private final int MAX_PIN = 10; // 총 핀의 개수
	private int try1, try2, try3; // 프레임 당 시도회수
	private boolean strike = false; // 스트라이크 체크
	private boolean spare = false; // 스페어 체크
	private int subtot; // 프레임 합계
	
	public int getTry1() {
		return try1;
	}
	public void setTry1(int try1) {
		this.try1 = try1;
	}
	public int getTry2() {
		return try2;
	}
	public void setTry2(int try2) {
		this.try2 = try2;
	}
	public int getTry3() {
		return try3;
	}
	public void setTry3(int try3) {
		this.try3 = try3;
	}
	public int getMAX_PIN() {
		return MAX_PIN;
	}
	public boolean isStrike() {
		return strike;
	}
	public void setStrike(boolean strike) {
		this.strike = strike;
	}
	public boolean isSpare() {
		return spare;
	}
	public void setSpare(boolean spare) {
		this.spare = spare;
	}
	public int getSubtot() {
		return subtot;
	}
	public void setSubtot(int subtot) {
		this.subtot = subtot;
	}
	
}
