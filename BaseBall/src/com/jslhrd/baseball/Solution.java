package com.jslhrd.baseball;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> baseballsol(int[][] baseball) {
		List<String> list = new ArrayList<String>();
		for (int x = 123; x < 988; x++) {
			int i = x / 100; // 100의 자리
			int j = (x % 100) / 10; // 10의 자리
			int k = (x % 100) % 10; // 1의 자리
			if (i == j || i == k || j == k)
				continue;
			if (j == 0 || k == 0)
				continue;
			String temp = Integer.toString(x);
			list.add(temp);
		}
		for (int x = 0; x < baseball.length; x++) {
			String temp1 = Integer.toString(baseball[x][0]);
			for (int y = 0; y < list.size(); y++) {
				String temp2 = list.get(y);
				int strike = 0;
				int ball = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i == j && temp1.charAt(i) == temp2.charAt(j)) {
							strike++;
						} else if (temp1.charAt(i) == temp2.charAt(j)) {
							ball++;
						}
					}
				}
				if (baseball[x][1] != strike || baseball[x][2] != ball) {
					list.remove(y);
					y--;
				}
			}
		}
		return list;
	}
}
