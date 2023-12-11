package com.harmony.sandbox.dsa.prep2022;//import java.util.StringBuilder;

class LongestCommonSubstringRecap {
	String match(String a, String b) {
		int[][] table = new int[a.length()][b.length()];
		int highRow = 0;
		int high = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					int topLeft = 0;
					if (i > 0 & j > 0) {
						topLeft = table[i-1][j-1];
					}
					int score = topLeft + 1;
					table[i][j] = score;
					if (score > high) {
						high = score;
						highRow = i;
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
		System.out.printf("highRow: %s, high: %s\n", highRow, high);
		StringBuilder sb = new StringBuilder();
		int start = highRow - high + 1;
		for (int i=start; i < start + high; i++) {
			sb.append(a.charAt(i));
		}
		return sb.toString();
	}
	
	public final static void main(String[] args) {
	LongestCommonSubstringRecap lcs = new LongestCommonSubstringRecap();
		System.out.println(lcs.match("wip", "wimp"));
		System.out.println(lcs.match("shorten", "portal"));
		System.out.println(lcs.match("fish", "fosh"));
	}
}