import java.util.Arrays;

/**
* https://leetcode.com/problems/majority-element/
*/
public class MajorityElement {
	
	public static void main(String... args) {
		//int[] nums = new int[]{2, 1, 2, 2, 3};
		int[] nums = new int[]{2,2,1,1,1,3,3,2,2,3,3,1};

		int majorElement = majorityElement(nums);

		System.out.println(majorElement);
	}

	/**
	* Boyer-Moore Voting Algorithm
	* https://algorithms.tutorialhorizon.com/majority-element-boyer-moore-majority-vote-algorithm/
	*/
	private static int majorityElement(int[] nums) {
		int count = 0;
		int candidate = -1;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			if (candidate == num) {
				count++;
			} else {
				count--;
			}
		}

		return candidate;
    }
}