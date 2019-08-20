import java.util.Arrays;

/**
* https://leetcode.com/problems/majority-element/
*/
public class Duplicates {
	
	public static void main(String... args) {
		int[] nums = new int[]{1, 2, 3, 2};

		boolean b = containsDuplicate(nums);

		System.out.println(b);
	}

	private static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1;i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}

		return false;
    }
}