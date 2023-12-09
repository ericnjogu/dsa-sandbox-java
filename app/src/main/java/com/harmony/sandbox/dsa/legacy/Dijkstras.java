package com.harmony.sandbox.dsa.legacy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Dijkstras {
	Map<String, String> search(Map<String, List<WeightedEdge>> graph, String start) {
		Map<String, Integer> costs = new HashMap<>();
		Map<String, String> parents = new HashMap<>();
		List<String> visited = new ArrayList<>();
		
		String current = start;
		
		while (Objects.nonNull(current)) {
			List<WeightedEdge> edges = graph.get(current);
			if (Objects.nonNull(edges)) {
				for (WeightedEdge edge: edges) {
					int baseCost = costs.getOrDefault(current, 0);
					int newTotal = baseCost + edge.weight;
					int existingTotal = costs.getOrDefault(edge.node, Integer.MAX_VALUE);
					if (newTotal < existingTotal) {
						costs.put(edge.node, Integer.valueOf(newTotal));
						parents.put(edge.node, current);
					}
				}
			}
			visited.add(current);
			current = findLowestCostNode(costs, visited);
		}
		return parents;
	}
	
	String findLowestCostNode(Map<String, Integer> costs, List<String> visited) {
		int lowestCost = Integer.MAX_VALUE;
		String lowestCostNode = null;
		for (String node: costs.keySet()) {
			int nodeCost = costs.getOrDefault(node, 0);
			if (Boolean.FALSE.equals(visited.contains(node)) && nodeCost < lowestCost) {
				lowestCostNode = node;
				lowestCost = nodeCost;
			}
		}
		return lowestCostNode;
	}
	
	public static void main(String[] args) {
		Map<String, List<WeightedEdge>> graph = new HashMap<>();
		graph.put("book", List.of(new WeightedEdge("lp", 5), new WeightedEdge("poster", 0)));
		graph.put("lp", List.of(new WeightedEdge("bg", 15), new WeightedEdge("drums", 20)));
		graph.put("poster", List.of(new WeightedEdge("bg", 20), new WeightedEdge("drums", 35)));
		graph.put("bg", List.of(new WeightedEdge("piano", 20)));
		graph.put("drums", List.of(new WeightedEdge("piano", 10)));
		
		Dijkstras dj = new Dijkstras();
		System.out.println(dj.search(graph, "book"));
	}
}

class WeightedEdge {
	public String node;
	public int weight;
	
	public WeightedEdge(String node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}