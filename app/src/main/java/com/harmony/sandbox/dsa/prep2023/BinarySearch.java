package com.harmony.sandbox.dsa.prep2023;

public class BinarySearch {
    /**
     * @param array - sorted array
     * @return the index where target is found, otherwise -1
     */
    int binarySearch(int[] array, int target) {
        int targetIndex = -1;
        if (target < array[0] || target > array[array.length - 1]) {
            return targetIndex;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return targetIndex;
    }
}
