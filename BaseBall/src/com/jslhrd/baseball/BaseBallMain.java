package com.jslhrd.baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallMain {

	public static void main(String[] args) {
		int[][] baseball = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
		Solution sol = new Solution();
		List<String> list = new ArrayList<String>();
		list = sol.baseballsol(baseball);
		
		System.out.println("정답이 가능한 수");
		for(int x = 0; x < list.size(); x++)
			System.out.print(list.get(x) + "\t");
		System.out.println();
		System.out.print("가능한 경우의 수 : " + list.size());
		
	}

}