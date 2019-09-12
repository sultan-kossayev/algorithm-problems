package leetcode;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {

    /**
     * Bit manipulation using using XOR's property: self-inverse A ^ A = 0
     * For example:
     * nums = {1, 0, 3}
     * 1st) 3 ^ 1 ^ 0
     * 2nd) 3 ^ 1 ^ 0 ^ 0 ^ 1
     * 3rd) 3 ^ 1 ^ 0 ^ 0 ^ 1 ^ 3 ^ 2 = (3 ^ 3) ^ (1 ^ 1) ^ (0 ^ 0) ^ 2 = 0 ^ 0 ^ 0 ^ 2
     * <p>
     * Time: O(N), N is size of the array
     * Space: O(1)
     */
    private static int missingNumberXOR(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ nums[i] ^ i;
        }

        return missing;
    }

    /**
     * Using Gauss' closed-form expression
     * which calculates the sum of first N positive numbers
     * <p>
     * Time: O(N)
     * Space: O(1)
     */
    private static int missingNumberGauss(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    public static void main(String... args) {
        int[] nums = new int[]{1, 0, 3};

        int missing1 = missingNumberXOR(nums);
        System.out.println(missing1);

        int missing2 = missingNumberGauss(nums);
        System.out.println(missing2);
    }
}
