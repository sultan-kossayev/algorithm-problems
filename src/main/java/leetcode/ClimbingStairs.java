package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    /**
     * Assume that the stair case has 8 steps. Also, assume that F(8) will calculate amount of steps needed to reach the top
     * such staircase.
     * Then, assume that F(7) and F(6) will calculate amount of steps needed to reach the top of the staircases that
     * have 7 and 6 steps each.
     * <p>
     * Now, going back to the staircase with 8 steps. When you just start climbing you have 2 choices: start with 1 step or 2 steps.
     * If you first take 2 steps, then only 6 steps will left to climb.
     * If you first take 1 step, then only 7 steps will left to climb.
     * <p>
     * Thus, each option reduces the problem to 7 and 6 steps staircases i.e. F(6) and F(7).
     * Thus, F(8) = F(7) + F(6), which is a relation that Fibonacci numbers have.
     * <p>
     * Time: O(n)
     * Space: O(1)
     */
    private static int climbStairs(int n) {
        int n1 = 1;
        int n2 = 1;
        for (int i = 2; i <= n; i++) {
            int t = n1;
            n1 = n1 + n2;
            n2 = t;
        }

        return n1;
    }

    public static void main(String... args) {
        int steps = climbStairs(8);

        Assertions.assertEquals(steps, 34);
    }
}
