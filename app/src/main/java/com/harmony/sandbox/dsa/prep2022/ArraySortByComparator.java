package com.harmony.sandbox.dsa.prep2022;

import java.util.Arrays;
import java.util.Comparator;

class ArraySortByComparator {
	void sort(int[][] numbers) {
		Arrays.sort(numbers, new Comparator<int[]>() {
			public int compare(int[] i, int[] j) {
				return Integer.compare(i[0], j[0]);
			}
		});
	}
	
	public static void main(String[] args) {
		ArraySortByComparator abc = new ArraySortByComparator();
		int[][] arr = new int[][] {{9,8},{7,6},{5,4},{3,2},{1,-1}};
		abc.sort(arr);
		//System.out.println(Arrays.stream(arr).flatMap(Arrays::stream).map(String::valueOf)
				//.collect(Collectors.joining(", ")));
	}
}