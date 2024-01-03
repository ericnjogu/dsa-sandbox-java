package com.harmony.sandbox.dsa.prep2023;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Slf4j
public class Bfs {
    List<String> bfs(Map<String, List<String>> graph, String start, String target) {
        /*
         * initialise a visited list
         * initialise a queue
         * add items to the queue and pop them off to check
         */
        List<String> visited = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> path = new HashMap<>();

        queue.add(start);
        while (!queue.isEmpty()) {
            log.debug("queue at start of while loop {}", queue);
            String node = queue.poll();
            log.debug("polled node {}", node);
            for (String neighbor: graph.get(node)) {
                log.debug("checking neighbor {}", neighbor);
                if (visited.contains(neighbor)) {
                    log.debug("skipping visited node '{}'", neighbor);
                } else {
                    path.put(neighbor, node);
                    if (neighbor.equalsIgnoreCase(target)) {
                        log.debug("paths {}", path);
                        return visited;
                    }
                    queue.addAll(graph.get(neighbor));
                    // node is visited when the children are added to the queue
                    visited.add(neighbor);
                }
            }
        }
        return visited;
    }
}
