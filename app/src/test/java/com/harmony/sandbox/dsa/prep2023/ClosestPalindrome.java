package com.harmony.sandbox.dsa.prep2023;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClosestPalindrome {
    // https://leetcode.com/problems/find-the-closest-palindrome/
    // adapted from solution https://leetcode.com/problems/find-the-closest-palindrome/solutions/960052/find-previous-and-next-palindromes-detailed-explanation/
    public String nearestPalindromic(String n) {
        // find nearest higher palindrome
        // parse to long so that we can update it after every iteration
        // add one so that we do not match itself
        long next = getPalindrome(n, true);
        log.debug("next palindrome {}", next);
        long previous = getPalindrome(n, false);
        log.debug("previous palindrome {}", previous);
        long number = Long.parseLong(n);
        long nextDiff = next - number;
        long prevDiff = number - previous;
        if (prevDiff <= nextDiff) {
            log.debug("returning previous");
            return String.valueOf(previous);
        } else {
            log.debug("returning next");
            return String.valueOf(next);
        }
    }

    long getPalindrome(String n, boolean nextPalindrome) {
        // skip starting number, it could be a palindrome
        long startingNumber;
        if (nextPalindrome) {
            startingNumber = Long.parseLong(n) + 1;
        } else {
            startingNumber = Long.parseLong(n) - 1;
        }
        // get string equivalent of starting number
        String numberStr = String.valueOf(startingNumber);
        // iterate over digits in first half of number and compare to second half
        for (int i = 0; i < numberStr.length()/2; i++) {
            // since number of digits can reduce/increase after prev step
            numberStr = String.valueOf(startingNumber);
            int source = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
            int incIndex = n.length() - 1 - i;
            log.debug("index for right half {}", incIndex);
            String digitToIncrement = String.valueOf(numberStr.charAt(incIndex));

            int toCompare = Integer.parseInt(digitToIncrement);
            log.debug("comparing {}, {}", source, toCompare);

            // check for roll over increment/decrement
            if (nextPalindrome && source < toCompare) {
                source += 10;
                log.debug("adjusted source for rollover {}", source);
            } else if (!nextPalindrome && toCompare < source) {
                toCompare += 10;
                log.debug("adjusted toCompare for rollover {}", toCompare);
            }
            double diff = Math.abs(source - toCompare) * Math.pow(10, i);
            log.debug("diff {}", diff);
            if (nextPalindrome) {
                startingNumber += diff;
            } else {
                startingNumber -= diff;
            }
            // check if source has changed, if yes, repeat
            String numberStrAfterDiff = String.valueOf(startingNumber);
            if (source != Integer.parseInt(String.valueOf(numberStrAfterDiff.charAt(i)))) {
                log.debug("left half digit changed, re-calculating");
                i--;
            }
            log.debug("value of palindrome is {} after iteration {}", startingNumber, i);
        }
        return startingNumber;
    }

    boolean isPalindrome(String n) {
        int i = 0;
        int j = n.length() - 1;
        boolean palindrome = true;
        while (i <= j) {
            log.debug("checking i:{} & j:{}", n.charAt(i), n.charAt(j));
            if (n.charAt(i) == n.charAt(j)) {
                i++;
                j--;
            } else {
                palindrome = false;
                break;
            }

        }
        return palindrome;
    }
}
