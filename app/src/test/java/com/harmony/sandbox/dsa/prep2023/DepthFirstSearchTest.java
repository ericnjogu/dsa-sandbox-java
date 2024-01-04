package com.harmony.sandbox.dsa.prep2023;

import com.harmony.sandbox.dsa.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    private DepthFirstSearch dfs;

    @BeforeEach
    void setUp() {
        dfs = new DepthFirstSearch();
    }

    @Test
    void dfs() {
        assertEquals(List.of("a", "b", "d", "c", "e"), dfs.search(TestData.getStructyGraph_01(), "a"));
    }

    @Test
    void undirectedPath_01() {
        List<List<String>> edges = List.of(
                List.of("i", "j"),
                List.of("k", "i"),
                List.of("m", "k"),
                List.of("k", "l"),
                List.of("o", "n")
        );
        assertTrue(dfs.undirectedPath(edges, "j", "m"));
    }
}