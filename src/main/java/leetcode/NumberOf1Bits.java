package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {

    /**
     * Time: O(M), where M is a number of set bits
     * Space: O(1)
     */
    private static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1); // allows us to nullify the rightmost set bit
        }

        return count;
    }

    public static void main(String... args) {
        Assertions.assertEquals(hammingWeight(9), 2);
    }
}
