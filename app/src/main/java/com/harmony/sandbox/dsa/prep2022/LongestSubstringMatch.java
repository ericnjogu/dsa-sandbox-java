package com.harmony.sandbox.dsa.prep2022;

class LongestSubstringMatch {
	String match(String one, String two) {
		int[][] grid = new int[one.length()][two.length()];
		int highScore = 0;
		int highScoreRow = -1;
		//int highScoreCol = -1;
		for (int i = 0; i < one.length(); i++) {
			for (int j = 0; j < two.length(); j++) {
				int score = 0;
				if (one.charAt(i) == two.charAt(j)) {
					score = 1;
					if (i > 0 && j > 0) {
						score += grid[i-1][j-1];
					}
				}
				grid[i][j] = score;
				if (score > highScore) {
					highScore = score;
					highScoreRow = i;
					//highScoreCol = j;
				}
			}
		}
		// print out largest, using the high score to determine where to stop since score is always +ve
		StringBuilder sub = new StringBuilder();
		while (highScore > 0) {
			sub.append(one.charAt(highScoreRow));
			highScoreRow -= 1;
			highScore -= 1;
		}
		/*for (int[] row: grid) {
			System.out.println(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
		}*/
		return sub.reverse().toString();
		
	}
	
	public static void main(String[] args) {
		LongestSubstringMatch lsm = new LongestSubstringMatch();
		System.out.println(lsm.match("gout!", "gut without"));
		System.out.println(lsm.match("hish", "fish"));
		System.out.println(lsm.match("hish", "vista"));
	}
}