package com.harmony.sandbox.dsa.prep2022;

import java.util.ArrayList;
import java.util.List;

class QuickSort {
	List<Integer> sort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		} else {
			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();
			int pivot = numbers.get(0);
			for (int i = 1; i < numbers.size(); i++) {
				if (numbers.get(i) <= pivot) {
					left.add(numbers.get(i));
				} else {
					right.add(numbers.get(i));
				}
			}
			List<Integer> combiList = new ArrayList<>();
			combiList.addAll(sort(left));
			combiList.add(pivot);
			combiList.addAll(sort(right));
			return combiList;
		}
	}
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		for (String num: args) {
			input.add(Integer.valueOf(num));
		}
		QuickSort qs = new QuickSort();
		System.out.println(qs.sort(input));
	}
}