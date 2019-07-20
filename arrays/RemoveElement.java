// https://leetcode.com/problems/remove-element/
public class RemoveElement {
	
	public static void main(String... args) {
		int[] nums = new int[]{3, 2, 2, 3};
		int removeThis = 3;

		int removed = removeElement(nums, removeThis);

		for (int i = 0; i < removed; i++) {
			System.out.println(nums[i]);
		}
	}

	private static int removeElement(int[] nums, int val) {
		int idx = nums.length -1;
        for(int i = 0; i <= idx;i++) {
            if (nums[i] == val) {
                while (nums[idx] == val && i != idx) {
                    idx--;
                }
                
                int t = nums[idx];
                nums[idx] = nums[i];
                nums[i] = t;
                idx--;
            }
        }
        
        return idx + 1;
	}
}