import java.util.Arrays;

/**
* https://leetcode.com/problems/array-partition-i/
*/
public class ArrayPartition1 {

	public static void main(String... args) {
		int[] nums = new int[]{3, -1, 10, 4, 5, 2};

		System.out.println(arrayPairSum(nums));
	}

	private static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);

		int res = 0;
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length;i = i + 2) {
			res += nums[i];
		}

		return res;
    }
}