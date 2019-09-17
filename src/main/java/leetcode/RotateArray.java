package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {

    /**
     * Reverse 3 times
     * <p>
     * Time: O(N), N is a size of the array
     * Space: O(1)
     */
    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
            lo++;
            hi--;
        }
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        rotate(nums, 2);
        Assertions.assertArrayEquals(nums, new int[]{4, 5, 1, 2, 3});
    }
}
