package com.harmony.sandbox.dsa.legacy;

public class BinarySearch {
 boolean binarySearch(int[] numbers, int target, int start, int stop) {
 	if (start > stop) {
		return false;
	}
	int midIndex = (stop + start) / 2;
 	int mid = numbers[midIndex];
	if (target == mid) {
		return true;
	} else if (target > mid) {
		return binarySearch(numbers, target, midIndex + 1, stop);
	} else {
		return binarySearch(numbers, target, start, midIndex - 1);
	}
	
 }
 
 public static void main(String[] args) {
 	BinarySearch bs = new BinarySearch();
	int[] array = new int[]{0,1,3,5,7,8,13,21};
  	System.out.println(bs.binarySearch(array, Integer.valueOf(args[0]).intValue(), 0, array.length - 1));
 }
}