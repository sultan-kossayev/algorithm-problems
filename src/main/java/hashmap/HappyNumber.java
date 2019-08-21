package hashmap;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {

    public static void main(String[] args) {
        Assertions.assertTrue(isHappy(19));
        Assertions.assertFalse(isHappy(2));
    }

    // Floyd's cycle detection algorithm is used
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
        while(n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }
}
