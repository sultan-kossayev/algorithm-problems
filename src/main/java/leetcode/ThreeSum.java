package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {

    /**
     * First sort the input. This will help with handling duplicates.
     * Then use two pointer technique to find other two complements.
     * <p>
     * Time: O(N^2), N is a size of the array
     * Space: O(1)
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip duplicates
                continue;
            }

            if (nums[i] > 0) { // if right elements are all positive then we can exit earlier
                break;
            }

            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum2 = nums[lo] + nums[hi];
                if (sum2 + nums[i] == 0) {
                    list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) { // skip duplicates
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) { // skip duplicates
                        hi--;
                    }
                } else if (sum2 < -nums[i]) { // going left. hoping to find bigger number
                    lo++;
                } else { // going right. hoping to find lower number
                    hi--;
                }
            }
        }

        return list;
    }

    public static void main(String... args) {
        List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        Assertions.assertArrayEquals(res.get(0).stream().mapToInt(i -> i).toArray(), new int[]{-1, -1, 2});
        Assertions.assertArrayEquals(res.get(1).stream().mapToInt(i -> i).toArray(), new int[]{-1, 0, 1});
    }
}
