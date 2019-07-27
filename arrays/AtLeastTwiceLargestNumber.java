//https://leetcode.com/problems/largest-number-at-least-twice-of-others/
public class AtLeastTwiceLargestNumber {

	public static void main(String... args) {
		int[] nums = new int[]{3, 6, 1, 0};

		int idx = dominantIndex(nums);

		System.out.println(idx);
	}


	private static int dominantIndex(int[] nums) {
        int maxFirst = nums[0], maxSec = 0;
        int idx = 0;
        
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] > maxFirst) {
                maxSec = maxFirst;
                maxFirst = nums[i];
                idx = i;
            } else if (nums[i] > maxSec) {
                maxSec = nums[i];
            }
        }
        
        return maxSec * 2 <= maxFirst? idx : -1;
    }
}