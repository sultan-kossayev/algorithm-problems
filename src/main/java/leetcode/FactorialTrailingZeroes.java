package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeroes {

    /**
     * just count the number of times 5 is a factor of a given number.
     * <p>
     * Time: O(log5(N))
     * Space: O(1)
     */
    private static int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String... args) {
        Assertions.assertEquals(trailingZeroes(100), 24);
    }
}
