package com.harmony.sandbox.dsa.legacy;

import java.util.Objects;

class EditDistance {
	/*
	- create a table with a additional prefix space
	- for each char of word a, compare with each char of b
	- when chars match, add 1 to diagonal
	- set default parent as match
	- check current against top (insert) and left(delete)
		- set the current value as the lower
		- set the parent as the lower value
	*/
	
	public static String MATCH = "M";
	public static String INSERT = "I";
	public static String DELETE = "D";
	public static String[] OPS = {INSERT, DELETE};
	
	String editOperations(String one, String two) {
		one = String.format(" %s", one);
		two = String.format(" %s", two);
		Op[][] table = new Op[one.length()][two.length()];
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<one.length(); i++) {
			for (int j=1; j<one.length(); j++) {
				Op parent = table[i-1][j-1];
				int cost = 0;
				String operation = MATCH;
				if (one.charAt(i) == two.charAt(j)) {
					if (Objects.nonNull(table[i-1][j-1])) {
						cost = table[i-1][j-1].cost() + 1;
					} else {
						cost = 1;
					}
				}
				Op[] opChecks = {table[i-1][j], table[i][j-1]};
				for (int l=0; l<opChecks.length; l++) {
					int checkCost = 0;
					if (Objects.nonNull(opChecks[l])) {
						checkCost = opChecks[l].cost();
					}
					if (checkCost < cost) {
						parent = opChecks[l];
						cost = checkCost;
						operation = OPS[l];
					}
				}
				table[i][j] = new Op(cost, parent, operation);
			}
		}
		
		Op parent = table[one.length()-1][two.length()-1];
		while (Objects.nonNull(parent)) {
			sb.append(parent.operation());
			parent = parent.parent();
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String one = "you should not";
		String two = "thou shalt not";
		System.out.println(ed.editOperations(one, two));
	}
	
	record Op(Integer cost, Op parent, String operation) {};
}