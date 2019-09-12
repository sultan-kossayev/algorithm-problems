package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {

    /**
     * Recurrence relation:
     * F(1) = N[1]
     * F(2) = Max(N[1], N[2])
     * F(3) = Max(F(1) + N[3], F(2))
     * F(k) = Max(F(k-2) + N[k], F(k-1))
     * F(k+1) = Max(F(k-1) + N[k+1], F(k))
     * <p>
     * where,
     * N[k] is the amount of money that each house has
     * F(k) is the maximum amount of money that a robber can get from k house
     * <p>
     * Time: O(N), where N is a number of houses
     * Space: O(1)
     */
    private static int rob(int[] nums) {
        int prevPrev = 0; // F(k-2)
        int prev = 0;   // F(k-1)
        for (int n : nums) {
            // iteration k begins
            int tempPrev = prev;    // remember F(k-1)
            prev = Math.max(prevPrev + n, prev); // F(k) = Max(F(k-2) + N[k], F(k-1))
            prevPrev = tempPrev; // F(k-1) becomes F(k-2) for the next iteration, because F(k+1) = Max(F(k-1) + N[k+1], F(k))
        }

        return prev;
    }

    public static void main(String... args) {
        int max = rob(new int[]{1, 2, 3, 1});

        Assertions.assertEquals(max, 4);
    }
}
