/**
* https://leetcode.com/problems/missing-number/
*/
public class MissingNumber {

	public static void main(String... args) {
		int[] nums = new int[]{1, 0, 3};

		int missing1 = missingNumberXOR(nums);
		System.out.println(missing1);

		int missing2 = missingNumberGauss(nums);
		System.out.println(missing2);
	}

	private static int missingNumberXOR(int[] nums) {
		int missing = nums.length;

		for (int i = 0; i < nums.length;i++) {
			// using XOR's property: self-inverse A ^ A = 0
			// {1, 0, 3}
			// 1st) 3 ^ 1 ^ 0 => 2nd) 3 ^ 1 ^ 0 ^ 0 ^ 1 = > 3rd) 3 ^ 1 ^ 0 ^ 0 ^ 1 ^ 3 ^ 2
			// (3 ^ 3) ^ (1 ^ 1) ^ (0 ^ 0) ^ 2 => 0 ^ 0 ^ 0 ^ 2
			missing = missing ^ nums[i] ^ i;
		}

		return missing;
	}

	private static int missingNumberGauss(int[] nums) {
		// using closed-form formula which calculates the sum of first N positive numbers
		int sum = nums.length * (nums.length + 1) / 2;

		for (int i = 0; i < nums.length;i++) {
			sum -= nums[i];
		}

		return sum;
	}
}