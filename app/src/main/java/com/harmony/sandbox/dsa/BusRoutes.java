package com.harmony.sandbox.dsa;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

@Slf4j
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // special bus to denote first visit to source
        final int ON_FOOT = -1;
        // create map with graph nodes
        Map<Integer, List<Stop>> routeStops = new HashMap<>();
        int bus = 0;
        for (int[] route: routes) {
            for (int i = 0; i < route.length; i++) {
                //log.debug("bus {}, stop {}", bus, route[i]);
                List<Stop> stops = routeStops.get(route[i]);
                if (Objects.isNull(stops)) {
                    stops = new ArrayList<>();
                    routeStops.put(route[i], stops);
                }
                int next = i + 1;
                int prev = i - 1;
                if (next >= route.length) {
                    // no further stop
                } else {
                    stops.add(new Stop(route[next], bus));
                }
                if (prev < 0) {
                    // no previous stop
                } else {
                    stops.add(new Stop(route[prev], bus));
                }
            }
            bus += 1;
        }
        // sort route stops by increasing order of stop id so that earlier stops are found first
        for (Integer stopId: routeStops.keySet()) {
            routeStops.put(stopId, routeStops.get(stopId).stream().sorted(
                    Comparator.comparingInt(s -> s.id)
            ).toList());
        }
        log.debug("route stops sorted: {}", routeStops);
        // initialise queue
        Queue<Stop> queue = new ArrayDeque<>();
        // initialise visited stops
        List<Stop> visitedStops = new ArrayList<>();
        visitedStops.add(new Stop(source, ON_FOOT));
        // do a breadth-first search
        queue.addAll(routeStops.get(source));
        boolean found = false;
        while (Boolean.FALSE.equals(queue.isEmpty())) {
            Stop currentStop = queue.poll();
            if (visitedStops.contains(currentStop)) {
                continue;
            }
            visitedStops.add(currentStop);
            if (currentStop.id == target) {
                found = true;
                break;
            } else {
                // add stops, starting by those that match the bus used last
                int currentBus = currentStop.bus;
                List<Stop> sortedStops = routeStops.get(currentStop.id).stream().sorted(
                        Comparator.comparingInt(s -> Math.abs(s.bus - currentBus))
                ).toList();
                log.debug("sorted stops: {}", sortedStops);
                queue.addAll(sortedStops);
            }
            log.debug("visited: {}", visitedStops);
            log.debug("queue: {}", queue);
        }
        if (found) {
            Set<Integer> buses = new HashSet<>();
            for (Stop visitedStop: visitedStops) {
                buses.add(visitedStop.bus);
            }
            log.debug("buses: {}", buses);
            // do not count getting on the bus at the first stop
            return buses.size() - 1;
        } else {
            return -1;
        }
    }
    record Stop (int id, int bus) {}
}
