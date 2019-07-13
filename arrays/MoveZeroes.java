import java.util.Arrays;

/**
* https://leetcode.com/problems/move-zeroes/
*/
public class MoveZeroes {

	public static void main(String... args) {
		int[] nums = new int[]{1, 1, 1, 1, 1, 0}; 
		int[] nums1 = new int[]{0, 1, 1, 1, 1, 1};
		int[] nums2 = new int[]{0, 0, 0, 0, 0, 1};
		int[] nums3 = new int[]{1, 0, 0, 0, 0, 0};

		moveZeroes(nums);
		moveZeroes(nums1);
		moveZeroes(nums2);
		moveZeroes(nums3);
	}
	
	public static void moveZeroes(int[] nums) {
        int idx = 0;	// index of the first element after the last non-zero element (so far)
        for (int i = 0; i < nums.length;i++) {
        	if (nums[i] != 0) {
        		if (i != idx) { // don't swap if the element is the itself
	        		nums[idx] = nums[i];
	        		nums[i] = 0;
	        	}

        		idx++;
        	}
        }
    }
}