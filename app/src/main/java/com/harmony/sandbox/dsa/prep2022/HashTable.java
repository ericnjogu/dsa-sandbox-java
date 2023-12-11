package com.harmony.sandbox.dsa.prep2022;

class HashTable {
	final static int DEFAULT_CAPACITY = 1000;
	String[] array = null;
	
	public HashTable() {
		array = new String[DEFAULT_CAPACITY];
	}
	
	int hash(String value) {
		int sum = 0;
		for (int i = 0; i < value.length(); i++) {
			sum += value.charAt(i) ^ 0;
		}
		return sum % DEFAULT_CAPACITY;
	}
	
	public void put(String key, String value) {
		array[hash(key)] = value;
	}
	
	public String get(String key) {
		return array[hash(key)];
	}
	
	public static void main(String[] args) {
		HashTable table = new HashTable();
		System.out.println(table.hash(args[0]));
	}
}