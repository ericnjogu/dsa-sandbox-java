package com.harmony.sandbox.dsa.legacy;

class PalindromeCheck {
	public static void main(String[] args) {
		PalindromeCheck pc = new PalindromeCheck();
		String[] strings = new String[] {"bb", "a", "ab", "baab", "maam"};
		for (String str: strings) {
			System.out.printf("%s: %s\n", str, pc.isPalindrome(str));
		}
	}
	
	boolean isPalindrome(String str) {
		if (str.length() == 1) {
			return true;
		} else {
			int mid = str.length() / 2;
			for (int i=0; i<mid; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					return false;
				}
			}
			return true;
		}
	}
}