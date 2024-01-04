package com.harmony.sandbox.dsa.prep2023;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * depth first search
 */
@Slf4j
public class DepthFirstSearch {
    List<String> search(Map<String, List<String>> graph, String start) {
        // initialize visited, stack
        LinkedList<String> visited = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            String node = stack.pop();
            // node is visited when it is popped
            visited.add(node);
            log.debug("popped {}", node);
            for (String neighbor: graph.get(node)) {
                log.debug("checking neighbor {}", neighbor);
                if (visited.contains(neighbor)) {
                    log.debug("skipping visited {}", neighbor);
                } else {
                    stack.push(neighbor);
                }
            }
        }

        return visited;
    }

    public boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {
        // convert to adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> edge: edges) {
            graph.computeIfAbsent(edge.get(0), list -> new ArrayList<>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), list -> new ArrayList<>()).add(edge.get(0));
        }
        System.out.println("graph is " + graph);
        // use depth first search to check
        Deque<String> stack = new ArrayDeque<>();
        stack.push(nodeA);
        Set<String> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            String node = stack.pop();
            visited.add(node);
            if (node.equals(nodeB)) {
                System.out.println("returning true");
                return true;
            } else {
                for (String neighbor: graph.get(node)) {
                    if (! visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println("returning false");
        return false;
    }
}
