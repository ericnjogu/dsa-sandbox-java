package com.harmony.sandbox.dsa.legacy;

class Factorial {
	long calculate(long number) {
		if (number == 1) {
		 return 1;
		} else {
			return number * calculate(number - 1);
		}
	}
	
	public static void main (String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.calculate(Long.valueOf(args[0])));
	}
}