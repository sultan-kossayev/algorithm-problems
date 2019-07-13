import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindDisappearedNumbers {

	public static void main(String... args) {
		int[] nums = new int[]{4,3,2,7,8,2,3,1};

		List<Integer> list = findDisappearedNumbers(nums);
		System.out.println(list);
	}

	private static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();

		// [4,3,2,7,8,2,3,1]
		// [4,3,2,-7,8,2,3,1]
		// [4,3,-2,-7,8,2,3,1]
		// [4,-3,-2,-7,8,2,3,1]
		// [4,-3,-2,-7,8,2,-3,1]
		// [4,-3,-2,-7,8,2,-3,-1]
		// [4,-3,-2,-7,8,2,-3,-1]
		// [4,-3,-2,-7,8,2,-3,-1]
		// [-4,-3,-2,-7,8,2,-3,-1]
		for (int i = 0; i < nums.length;i++) {
			int markIdx = Math.abs(nums[i]) - 1;

			// if a number exists, the another number in the related index will be marked
			if (nums[markIdx] > 0) {
				nums[markIdx] *= -1;
			}
		}

		for (int i = 0; i < nums.length;i++) {
			// if number is not marked, then its index doesn't exist in the original array as a number
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}

		return list;
	}
}