package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {

    /**
     * Cycle detection is based on Floyd's tortoise and hare algorithm
     * <p>
     * Time: O(n), where n is a number of steps needed to get to the 1 or cycle
     * Space: O(1)
     */
    private static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    private static int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Assertions.assertTrue(isHappy(19));
        Assertions.assertFalse(isHappy(2));
    }
}
