package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/power-of-three/
public class PowerOfThree {

    /**
     * N is a power of 3 only if a result of log3(N) is a decimal
     * log3(N) can be calculated using logarithm property logX(b) = logK(b) / logK(X)
     * K in our case is 10 because it allows us to ignore precision errors.
     * "% 1" checks whether the result of logX(b) is a decimal
     */
    private static boolean isPowerOfThree1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /**
     * This works only with powers that are primary numbers such as 3
     */
    private static boolean isPowerOfThree2(int n) {
        if (n < 0) {
            return false;
        }

        // 19 = log3(1162261467), because 3 ^ 20 overflows max int
        int pow = (int) (Math.log10(Integer.MAX_VALUE) / Math.log10(3));

        return Math.pow(3, pow) % n == 0;
    }

    public static void main(String... args) {
        Assertions.assertTrue(isPowerOfThree1(81));
        Assertions.assertTrue(isPowerOfThree2(81));
    }
}
