package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

    /**
     * two pointers: slow and fast
     * Time: O(N), N is a size of the array
     * Space: O(1)
     */
    private static int removeDuplicates(int[] nums) {
        //[1, 1, 2, 3]
        //[1, 2, 2, 2, 3, 4, 4, 5]

        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 1, 2, 3};
        int size = removeDuplicates(nums);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, size), new int[]{1, 2, 3});
    }
}
