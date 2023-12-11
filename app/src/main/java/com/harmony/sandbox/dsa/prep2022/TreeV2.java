package com.harmony.sandbox.dsa.prep2022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


// create a tree using adjacency lists
class TreeV2 {
	Set<Integer> parents(Map<Integer, int[]> tree) {
		return tree.keySet();
	}
	
	Collection<Integer> children(Integer root, Map<Integer, int[]> tree) {
		List<Integer> visited = new ArrayList<>();
		Queue<Integer> que = new LinkedList<>();
		que.add(root);
		visited.add(root);
		while(Boolean.FALSE.equals(que.isEmpty())) {
			Integer current = que.poll();
			int[] nodes = tree.get(current);
			if (Objects.nonNull(nodes)) {
				for (int node: nodes) {
					if (Boolean.FALSE.equals(visited.contains(node))) {
						visited.add(node);
						que.add(node);
					}
				}
			}
		}
		return visited;
	}
	
	void leafNodes(Integer root, Map<Integer, int[]> tree, List<Integer> visited, List<Integer> leafNodes) {
		int[] nodes = tree.get(root);
		if (Objects.isNull(nodes)) {
			leafNodes.add(root);
		} else {
			for (int node: nodes) {
				if (Boolean.FALSE.equals(visited.contains(node))) {
					visited.add(node);
					leafNodes(node, tree, visited, leafNodes);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, int[]> tree = new HashMap<>();
		Integer root = 1;
		tree.put(root, new int[]{2, 3, 4});
		tree.put(2, new int[] {5, 6});
		// tree.put(3, null);
		tree.put(4, new int[] {7});
		
		TreeV2 tv = new TreeV2();
		
		System.out.printf("parents %s\n", tv.parents(tree));
		System.out.printf("children - bfs %s\n", tv.children(root, tree));
		List<Integer> visited = new ArrayList<>();
		List<Integer> leafNodes = new ArrayList<>();
		visited.add(root);
		tv.leafNodes(root, tree, visited, leafNodes);
		System.out.printf("leafnodes: visited %s-\n", visited);
		System.out.printf("leafnodes: %s-\n", leafNodes);
	}
}