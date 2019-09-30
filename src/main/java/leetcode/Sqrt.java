package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/sqrtx/
public class Sqrt {

    /**
     * Using binary search approach.
     * <p>
     * Time: O(logN)
     * Space: O(1)
     */
    private static int mySqrt1(int x) {
        if (x < 1) {
            return 0;
        }

        int lo = 1;
        int hi = x;

        int res = 1;
        while (lo <= hi) {
            int pivot = lo + (hi - lo) / 2; // to prevent overflow

            if (pivot > x / pivot) {    // to prevent overflow
                hi = pivot - 1;
            } else {
                lo = pivot + 1;
                res = pivot;        // just find the upper-bound value
            }
        }

        return res;
    }

    /**
     * Using simplification of the Newton's method
     * which states that x(k+1) = (x(k) + x/x(k)) / 2
     * converges to the sqrt(x) when x(k+1) == x(k). In this case x(k+1) is the sqrt of x.
     * <p>
     * However, in our case x(k+1) == x(k) check will be transformed to x(k) = x(k+1) + 1
     * <p>
     * Time: O(logN)
     * Space: O(1)
     */
    private static int mySqrt2(int x) {
        double x0 = x;
        double x1 = (x0 + x / x0) / 2;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2;
        }

        return (int) x1;
    }

    public static void main(String... args) {
        Assertions.assertEquals(mySqrt1(10), 3);
        Assertions.assertEquals(mySqrt2(10), 3);
    }
}
