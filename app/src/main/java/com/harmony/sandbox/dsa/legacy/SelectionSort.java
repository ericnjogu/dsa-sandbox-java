package com.harmony.sandbox.dsa.legacy;

import java.util.Arrays;

public class SelectionSort {
	public static final String DESC = "desc";
	public static final String ASC = "asc";
	/**
	* perform selection sort
	*/
	void selectionSort(int[] array, String type) {
		for (int i = 0; i < array.length; i++) {
			// start in the unsorted section
			for (int j = i+1; j < array.length; j++) {
				if (DESC.equalsIgnoreCase(type)) {
					if (array[i] < array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					} 
				} else {
					if (array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}
	}
	
	public static void main (String[] args) {
		int[] numbers = new int[args.length - 1];
		for (int i=0; i < args.length - 1; i++) {
			numbers[i] = Integer.valueOf(args[i]).intValue();
		}
		SelectionSort sorter = new SelectionSort();
		sorter.selectionSort(numbers, args[args.length - 1]);
		Arrays.stream(numbers).forEach(i -> System.out.print(String.format("%s,", i)));
		
		// System.out.println("testing");
	}
}