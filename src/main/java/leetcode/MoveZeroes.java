package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {

    /**
     * Time: O(N), N is a length of the array
     * Space: O(1)
     */
    private static void moveZeroes(int[] nums) {
        int idx = 0;    // index of the first element after the last non-zero element (so far)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != idx) { // don't swap if the element is the itself
                    nums[idx] = nums[i];
                    nums[i] = 0;
                }

                idx++;
            }
        }
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 1, 1, 0};
        moveZeroes(nums);
        Assertions.assertArrayEquals(nums, new int[]{1, 1, 1, 0});

        int[] nums2 = new int[]{0, 0, 0, 1};
        moveZeroes(nums2);
        Assertions.assertArrayEquals(nums2, new int[]{1, 0, 0, 0});
    }
}
