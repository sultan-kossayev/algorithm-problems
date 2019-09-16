package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/single-number/
public class SingleNumber {

    /**
     * Bit manipulation using using XOR's property: self-inverse A ^ A = 0
     * For example:
     * nums = {1, 3, 5, 3, 1} results to 1 ^ 1 ^ 3 ^ 3 ^ 5 = 0 ^ 0 ^ 5 = 5
     * <p>
     * Time: O(N), N is size of the array
     * Space: O(1)
     */
    private static int singleNumber(int... nums) {
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            number = number ^ nums[i];
        }

        return number;
    }

    public static void main(String... args) {
        int num = singleNumber(1, 3, 5, 3, 1);
        Assertions.assertEquals(num, 5);
    }
}
