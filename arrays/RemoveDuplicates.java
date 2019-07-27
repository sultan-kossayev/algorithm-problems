//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
	
	public static void main(String... args) {
		int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

		int elms = removeDuplicates(nums);

		for (int i = 0; i < elms; i++) {
			System.out.println(nums[i]);
		}
	}

	private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int j = 0;
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        
        return j + 1;
    }
}