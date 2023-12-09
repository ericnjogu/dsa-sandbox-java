package com.harmony.sandbox.dsa.legacy;

import java.util.Arrays;

class LongestIncreasingSequence {
	public static void main(String[] args) {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int len = lis.length(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80});
		System.out.println(len);
	}
	
	int length(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int highest = 0;
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				if (dp[i] > highest) {
					highest = dp[i];
				}
			}
		}
		return highest;
	}
}