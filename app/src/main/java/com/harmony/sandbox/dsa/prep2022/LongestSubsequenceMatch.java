package com.harmony.sandbox.dsa.prep2022;

class LongestSubsequenceMatch {
	int match(String one, String two) {
		/*
		- if a chars match, place grid[row - 1][col - 1] + 1 on current location
		- if chars do not match, use higher of grid[row - 1][col] and grid[row][col - 1]
		- return highest score
		*/
		int[][] grid = new int[one.length()][two.length()];
		int highestScore = 0;
		for (int i=0; i < one.length(); i++) {
			for (int j=0; j < two.length(); j++) {
				int score = 0;
				if (one.charAt(i) == two.charAt(j)) {
					score = 1;
					if (i > 0 && j > 0) {
						score += grid[i-1][j-1];
					}
				} else {
					int up = 0;
					int left = 0;
					if (i > 0) {
						up = grid[i-1][j];
					}
					if (j > 0) {
						left = grid[i][j-1];
					}
					if (up > left) {
						score = up;
					} else {
						score = left;
					}
				}
				if (score > highestScore) {
					highestScore = score;
				}
				grid[i][j] = score;
			}
		}
		return highestScore;
	}
	
	public static void main(String[] args) {
		LongestSubsequenceMatch lsm = new LongestSubsequenceMatch();
		System.out.println(lsm.match("fosh", "fish"));
		System.out.println(lsm.match("fosh", "fort"));
	}
}