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

    @Test
    @DisplayName("when a route does not exist")
    void numBusesToDestination_02() {
        assertEquals(-1, busRoutes.numBusesToDestination(
                new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}}, 15, 12));
    }

    @Test
    @DisplayName("when a route exists on same bus")
    void numBusesToDestination_03() {
        assertEquals(1, busRoutes.numBusesToDestination(
                new int[][]{{24},
                        {3,6,11,14,22},
                        {1,23,24},
                        {0,6,14},
                        {1,3,8,11,20}}, 20, 8));
    }

    @Test
    @DisplayName("when a shorter route exists on same bus")
    void numBusesToDestination_04() {
        assertEquals(1, busRoutes.numBusesToDestination(
                new int[][]{{1,9,12,20,23,24,35,38},
                        {10,21,24,31,32,34,37,38,43},
                        {10,19,28,37},
                        {8},
                        {14,19},
                        {11,17,23,31,41,43,44},
                        {21,26,29,33},
                        {5,11,33,41},
                        {4,5,8,9,24,44}}, 37, 28));
    }

    @Test
    @DisplayName("when a shorter route exists on same bus")
    void numBusesToDestination_05() {
        assertEquals(1, busRoutes.numBusesToDestination(
                new int[][]{{0,1,6,16,22,23},
                        {14,15,24,32},
                        {4,10,12,20,24,28,33},
                        {1,10,11,19,27,33},
                        {11,23,25,28},
                        {15,20,21,23,29},
                        {29}}, 4, 21));
    }
}