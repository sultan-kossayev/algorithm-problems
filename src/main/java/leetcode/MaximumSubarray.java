package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    /**
     * The algorithm is based on a simple observation that
     * maximum at each i step equals to maximum of 2 numbers, where
     * 1st number is num[i] itself and
     * 2nd number is a sum of num[i] and maximum found on i + 1 step.
     * i.e. max[i] = Math.max(num[i], num[i] + max[i + 1]).
     * Thus, in order to get maximum for 3rd step we have to know what maximum was in 4rd step.
     * To do that the algorithm is looping backward.
     * Once we identify maximum for each step,
     * the correct answer can just be found by iterating through the array and finding the maximum element.
     * <p>
     * For example, given an array [3, -1, 4, -3] the maximum calculated each step would be
     * [6,  3, 4, -3].
     * <p>
     * To save space, the source array gets changed. If it is prohibited, then additional O(n) space
     * is required to store maximums calculated at each step.
     * <p>
     * Time: O(n)
     * Space: O(1) (if source is changed, otherwise O(n)
     */
    private static int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            // calculating the max[i]
            nums[i] = Math.max(nums[i], nums[i] + nums[i + 1]);

            // calculating the global max
            maxSum = Math.max(maxSum, nums[i]);
        }

        return maxSum;
    }

    /**
     * Divide and conquer technique.
     * The algorithm follows the idea that every time when a pivot divides the array into parts then the maximum sum
     * can sit:
     * 1) completely on the left part
     * 2) completely on the right part
     * 3) or it can consists of some of the elements from left and right parts
     * Each recursion call gives us answer only for 1st and 2nd choices.
     * The 3rd option is handled by crossSum() function.
     * <p>
     * So, once we found results for all 3 above steps then the maximum sum is simply
     * maximum of those 3 options i.e. Math.max(leftMax, rightMax, crossMax)
     * <p>
     * Time: O(N * logN)
     * Space: O(logN), because of recursion
     */
    private static int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        return divide(nums, 0, nums.length - 1);
    }

    private static int divide(int[] nums, int lo, int hi) {
        if (hi == lo) { // base case
            return nums[lo];
        }

        int p = (lo + hi) / 2;

        int leftMax = divide(nums, lo, p);
        int rightMax = divide(nums, p + 1, hi);

        int crossMax = crossSum(nums, lo, p, hi);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int crossSum(int[] nums, int lo, int p, int hi) {
        // find max of left part of the pivot
        int maxleft = nums[p];
        int sum = nums[p];
        for (int i = p - 1; i >= lo; i--) {
            sum += nums[i];
            maxleft = Math.max(sum, maxleft);
        }

        // find max of right part of the pivot
        int maxRight = nums[p + 1];
        sum = nums[p + 1];
        for (int i = p + 2; i <= hi; i++) {
            sum += nums[i];
            maxRight = Math.max(sum, maxRight);
        }

        // combine
        return maxleft + maxRight;
    }

    public static void main(String... args) {
        int max1 = maxSubArray1(new int[]{3, -1, 4, -3});
        Assertions.assertEquals(max1, 6);

        int max2 = maxSubArray2(new int[]{3, -1, 4, -3});
        Assertions.assertEquals(max2, 6);
    }
}