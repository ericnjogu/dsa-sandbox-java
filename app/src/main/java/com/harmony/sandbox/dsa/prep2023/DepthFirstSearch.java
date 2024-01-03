package com.harmony.sandbox.dsa.prep2023;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
}
