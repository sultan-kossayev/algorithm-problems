package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    /**
     * First fill the array such that res[i] = nums[i] * nums[i-1] * ... * nums[0]
     * Then work backward and update res[i] such that
     * res[i] = res[i - 1] * (nums[i + 1] * ... * nums[N - 1])
     * To save space, keep the result of (nums[i + 1] * ... * nums[N - 1]) in a separate variable
     * <p>
     * Time: O(N), N is a size of the array
     * Space: O(1)
     */
    private static int[] productExceptSelf(int... nums) {
        int[] res = new int[nums.length];

        res[0] = nums[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i] * res[i - 1];
        }

        int temp = 1;
        for (int i = res.length - 1; i >= 1; i--) {
            res[i] = res[i - 1] * temp;
            temp *= nums[i];
        }
        res[0] = temp;

        return res;
    }

    public static void main(String... args) {
        int[] result = productExceptSelf(2, 3, 4, 5);
        Assertions.assertArrayEquals(result, new int[]{60, 40, 30, 24});
    }
}
