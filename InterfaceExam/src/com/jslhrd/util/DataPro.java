package com.jslhrd.util;

public class DataPro implements Data {

	@Override
	public int getMax(int... var) {
		int max = var[0];
		for (int x = 1; x < var.length; x++)
			max = (var[x] > max) ? var[x] : max;
		return max;
	}

	@Override
	public int getMin(int... var) {
		int min = var[0];
		for (int x = 1; x < var.length; x++)
			min = (var[x] < min) ? var[x] : min;
		return min;
	}

	@Override
	public void sort(int[] var, boolean bool) { // bool = true : 오름차순, bool = false : 내림차순
		for (int x = 0; x < var.length-1; x++) {
			for (int y = 0; y < var.length-x-1; y++) {
				if (bool) {
					if (var[y] > var[y+1]) {
						int temp = var[y];
						var[y] = var[y+1];
						var[y+1] = temp;
					}
				}
				else {
					if (var[y] < var[y+1]) {
						int temp = var[y];
						var[y] = var[y+1];
						var[y+1] = temp;
					}
				}
			}
		}
		
	}

}
