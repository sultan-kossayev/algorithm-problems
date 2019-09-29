package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {

    /**
     * Using sorting.
     * Also can be solved using hash set, which gives linear time but with O(N) space
     * <p>
     * Time: O(NlogN), where N is a size of the array
     * Space: O(1)
     */
    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 2, 3, 2};

        boolean b = containsDuplicate(nums);

        Assertions.assertTrue(b);
    }
}
