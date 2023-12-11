package com.harmony.sandbox.dsa.prep2022;

class MockInterview {
	int longestSubSeq(int[] A) {
		int count = 0;
		int longestCount = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i+1]) {
				count++;
				if (count > longestCount) {
					longestCount = count;
				}
			} else {
				count = 0;
			}
		}
		return longestCount + 1;
	}
	
	public static void main (String[] args) {
		MockInterview mi = new MockInterview();
		System.out.println(mi.longestSubSeq(new int[]{3, -3, 3, 3, 3, 1, -3}));
		System.out.println(mi.longestSubSeq(new int[]{1, 2, 3, -3, 3, 3, 3}));
		System.out.println(mi.longestSubSeq(new int[]{1}));
	}
}
