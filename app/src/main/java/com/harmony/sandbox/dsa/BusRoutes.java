package com.harmony.sandbox.dsa;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Slf4j
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // consider the routes that a stop is on to be its neighbours
        Map<Integer, List<Integer>> stopsToBuses = new HashMap<>();
        for (int i=0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopsToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        log.debug("stops to buses: {}", stopsToBuses);
        // initialise queue
        Queue<Integer> queue = new ArrayDeque<>();
        // initialise used buses
        List<Integer> busesUsed = new ArrayList<>();
        List<Integer> visitedStops = new ArrayList<>();
        // do a breadth-first search
        queue.add(source);
        int count = 0;
        while (Boolean.FALSE.equals(queue.isEmpty())) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> buses = stopsToBuses.get(queue.poll());
                for (int bus: buses) {
                    // skip if bus visited
                    if (busesUsed.contains(bus)) {
                        continue;
                    }
                    busesUsed.add(bus);
                    for (int stop: routes[bus]) {
                        if (visitedStops.contains(stop)) {
                            continue;
                        }
                        visitedStops.add(stop);
                        if (target == stop) {
                            log.debug("buses: {}", busesUsed);
                            log.debug("stops: {}", visitedStops);
                            return count + 1;
                        } else {
                            queue.offer(stop);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
