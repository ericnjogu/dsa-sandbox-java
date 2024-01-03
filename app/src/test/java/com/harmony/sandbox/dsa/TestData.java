package com.harmony.sandbox.dsa;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestData {
    public static Map<String, List<String>> getStructyGraph_01() {
        return Map.of(
                "a", List.of("c", "b"),
                "c", List.of("e"),
                "e", List.of("b"),
                "b", List.of("d"),
                "f", List.of("d"),
                "d", Collections.emptyList()
        );
    }
}
