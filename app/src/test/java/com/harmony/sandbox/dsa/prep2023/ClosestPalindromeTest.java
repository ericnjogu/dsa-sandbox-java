package com.harmony.sandbox.dsa.prep2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPalindromeTest {

    private ClosestPalindrome closestPalindrome;

    @BeforeEach
    void setUp() {
        closestPalindrome = new ClosestPalindrome();
    }

    @Test
    @DisplayName("closest palindrome to 120")
    void nearestPalindromic_01() {
        assertEquals("121", closestPalindrome.nearestPalindromic("120"));
    }

    @Test
    @DisplayName("closest palindrome to 571982")
    void nearestPalindromic_02() {
        assertEquals("572275", closestPalindrome.nearestPalindromic("571982"));
    }

    @Test
    @DisplayName("closest palindrome to 1")
    void nearestPalindromic_03() {
        assertEquals("0", closestPalindrome.nearestPalindromic("1"));
    }

    @Test
    @DisplayName("closest palindrome to 10")
    void nearestPalindromic_04() {
        assertEquals("9", closestPalindrome.nearestPalindromic("10"));
    }

    @Test
    @DisplayName("closest palindrome to 1213")
    void nearestPalindromic_05() {
        assertEquals("1221", closestPalindrome.nearestPalindromic("1213"));
    }

    @Test
    @DisplayName("closest palindrome to 11")
    void nearestPalindromic_06() {
        assertEquals("9", closestPalindrome.nearestPalindromic("11"));
    }

    @Test
    @DisplayName("check if 121 is palindrome")
    void isPalindrome_01() {
        assertTrue(closestPalindrome.isPalindrome("121"));
    }

    @Test
    @DisplayName("check if 122 is palindrome")
    void isPalindrome_02() {
        assertFalse(closestPalindrome.isPalindrome("122"));
    }

    @Test
    @DisplayName("check if 123 is palindrome")
    void isPalindrome_03() {
        assertFalse(closestPalindrome.isPalindrome("123"));
    }

    @Test
    @DisplayName("check if 0 is palindrome")
    void isPalindrome_04() {
        assertTrue(closestPalindrome.isPalindrome("0"));
    }
}