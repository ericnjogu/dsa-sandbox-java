package com.harmony.sandbox.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusRoutesTest {

    private BusRoutes busRoutes;

    @BeforeEach
    void setUp() {
        busRoutes = new BusRoutes();
    }

    @Test
    @DisplayName("when a route exists")
    void numBusesToDestination_01() {
        assertEquals(2, busRoutes.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
    }
}