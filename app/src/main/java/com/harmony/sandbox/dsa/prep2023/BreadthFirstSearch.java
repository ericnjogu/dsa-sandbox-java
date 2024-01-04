package com.harmony.sandbox.dsa.prep2023;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@Slf4j
public class BreadthFirstSearch {
    List<String> bfs(Map<String, List<String>> graph, String start/*, String target*/) {
        /*
         * initialise a visited list
         * initialise a queue
         * add items to the queue and pop them off to check
         */
        List<String> visited = new LinkedList<>();
        //Map<String, String> path = new HashMap<>();

        Queue<String> queue = new LinkedList<>(graph.get(start));
        visited.add(start);
        while (!queue.isEmpty()) {
            log.debug("queue at start of while loop {}", queue);
            String node = queue.poll();
            log.debug("polled node {}", node);
            //for (String neighbor: graph.get(node)) {
                //log.debug("checking neighbor {}", neighbor);
                if (visited.contains(node)) {
                    log.debug("skipping visited node '{}'", node);
                } else {
                    //path.put(neighbor, node);
                    /*if (neighbor.equalsIgnoreCase(target)) {
                        log.debug("paths {}", path);
                        return visited;
                    }*/
                    queue.addAll(graph.get(node));
                    // when is a node is visited?
                    visited.add(node);
                }
            //}
        }
        return visited;
    }

    public int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        /*
        create a set of nodes
        initialise a counter
        Iterate over the nodes and use each node as the starting point for a BFS
        while visiting the nodes in the BFS, delete them from the set
        */
        Set<Integer> nodes = new HashSet<>(graph.keySet());
        int count = 0;
        while (!nodes.isEmpty()) {
            Deque<Integer> que = new ArrayDeque<>();
            Integer node = nodes.iterator().next();
            System.out.println("iterating over node " + node);
            System.out.println("nodes: " + nodes);
            que.add(node);
            Set<Integer> visited = new HashSet<>();
            while (! que.isEmpty()) {
                Integer current = que.poll();
                System.out.println("polled " + current);
                if (visited.contains(current)) {
                    System.out.println("skipping visited " + current);
                } else {
                    que.addAll(graph.get(current));
                    visited.add(current);
                }
            }
            System.out.println("visited: " + visited);
            nodes.removeAll(visited);
            count++;
        }

        System.out.println("Returning count " + count);
        return count;
    }
}
