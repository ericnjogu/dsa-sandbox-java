package com.harmony.sandbox.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeEach
    void setup() {
        binarySearch = new BinarySearch();
    }

    @Test
    void binarySearch() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        assertEquals(1, binarySearch.binarySearch(array, 2 ));
        assertEquals(-1, binarySearch.binarySearch(array, 12));
        assertEquals(-1, binarySearch.binarySearch(array, 10));
    }
}