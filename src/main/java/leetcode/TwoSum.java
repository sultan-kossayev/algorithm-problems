package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    /**
     * Using a hash map for locating a complement in one pass.
     *
     * Time: O(N)
     * Space: O(N)
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length;i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String... args) {
        int[] nums = new int[]{2,3,4,5};
        int[] sum = twoSum(nums, 9);

        Assertions.assertArrayEquals(sum, new int[]{2, 3});
    }
}