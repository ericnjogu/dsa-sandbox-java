package com.harmony.sandbox.dsa;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // create map with graph nodes
        Map<Integer, List<Stop>> routeStops = new HashMap<>();
        int bus = 0;
        for (int[] route: routes) {
            for (int i = 0; i < route.length; i++) {
                log.debug("bus {}, stop {}", bus, route[i]);
                List<Stop> stops = routeStops.get(route[i]);
                if (Objects.isNull(stops)) {
                    stops = new ArrayList<>();
                    routeStops.put(route[i], stops);
                }
                int next = i + 1;
                if (next >= route.length) {
                    // no further stops
                } else {
                    stops.add(new Stop(route[next], bus));
                }
            }
            bus += 1;
        }
        log.debug("sanity {}", routeStops);
        // initialise queue

        // do a breadth-first search
        return -1;
    }
    record Stop (int id, int bus) {}
}
