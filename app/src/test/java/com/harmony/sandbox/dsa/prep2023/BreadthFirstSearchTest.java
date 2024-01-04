package com.harmony.sandbox.dsa.prep2023;

import com.harmony.sandbox.dsa.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    private BreadthFirstSearch breadthFirstSearch;

    @BeforeEach
    void setUp() {
        breadthFirstSearch = new BreadthFirstSearch();
    }

    @Test
    void bfs() {

        assertEquals(List.of("a", "b", "d"), breadthFirstSearch.bfs(TestData.getStructyGraph_01(), "a"/*, "d"*/));
    }

    @Test
    void bfs_02() {
        Map<String, List<String>> graph = Map.of(
                "start", List.of("a", "c"),
                "a", List.of("b"),
                "c", List.of("d", "e"),
                "d", List.of("b"),
                "b", List.of("end"),
                "e", List.of("b"),
                "end", Collections.emptyList()
        );
        assertEquals(List.of("start", "a", "b", "end"), breadthFirstSearch.bfs(graph, "start"/*, "end"*/));
    }

    @Test
    void connectedComponentsCount_01() {
        assertEquals(2, breadthFirstSearch.connectedComponentsCount(Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        )));
    }
}