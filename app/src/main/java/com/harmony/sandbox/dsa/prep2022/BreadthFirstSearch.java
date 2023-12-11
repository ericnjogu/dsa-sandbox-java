package com.harmony.sandbox.dsa.prep2022;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Objects;

class BreadthFirstSearch {
	HashMap<String, String> search(HashMap<String, List<String>> graph, String startNode, String targetNode) {
		List<String> visited = new ArrayList<>();
		LinkedList<String> queue = new LinkedList<>();
		HashMap<String, String> parent = new HashMap<>();
		
		queue.add(startNode);
		while (! queue.isEmpty()) {
			String current = queue.poll();
			System.out.println("current: " + current);
			System.out.println("queue: " + queue);
			System.out.println("visited: " + visited);
			if (current.equalsIgnoreCase(targetNode)) {
				break;
			} else {
				List<String> nodeList = graph.getOrDefault(current, Collections.emptyList());
				System.out.println("adding nodes: " + nodeList);
				for (String node: nodeList) {
					if (visited.contains(node)) {
						System.out.println(String.format("%s is visited", node));
					} else {
						visited.add(node);
						queue.add(node);
						System.out.println(String.format("queing %s", node));
						parent.put(node, current);
					}
				}
			}
		}
		return parent;
	}
	
	LinkedList<String> showPath(HashMap<String, String> nodeToParent, String targetNode, LinkedList<String> path) {
		String parent = nodeToParent.get(targetNode);
		path.push(targetNode);
		if (Boolean.FALSE.equals(Objects.isNull(parent))) {
			return showPath(nodeToParent, parent, path);
		} else {
			return path;
		}
	}
	
	public static void main (String[] args) {
		HashMap<String, List<String>> graph = new HashMap<>();
		graph.put("cab", List.of("cat", "car"));
		graph.put("car", List.of("cat", "bar"));
		graph.put("bar", List.of("bat"));
		graph.put("cat", List.of("mat", "bat"));
		graph.put("mat", List.of("bat"));
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		HashMap<String, String> nodeToParent = bfs.search(graph, "cab", "bat");
		System.out.printf("search tree: %s\n", nodeToParent);
		System.out.printf("path: %s\n", bfs.showPath(nodeToParent, "bat", new LinkedList<>()));
	}
}