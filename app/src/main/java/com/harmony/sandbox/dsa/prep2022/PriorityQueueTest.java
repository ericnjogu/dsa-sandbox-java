package com.harmony.sandbox.dsa.prep2022;

import java.util.PriorityQueue;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;

class PriorityQueueTest {
	public static void main(String[] args) {
		Collection<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
			public int compare(List<Integer> one, List<Integer> two) {
				return Integer.compare(one.size(), two.size());
			}
		});
		pq.add(List.of(1, 2, 3));
		pq.add(List.of(3, 4));
		pq.add(List.of(8));
		System.out.println(pq);
	}
}