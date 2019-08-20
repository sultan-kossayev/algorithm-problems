// https://leetcode.com/problems/find-pivot-index/
public class FindPivot {
	
	public static void main(String... args) {

		int[] nums = new int[]{1, 7, 3, 6, 5, 6};

		int pivot = pivotIndex(nums);

		System.out.println(pivot);
	}

	private static int pivotIndex(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length;i++) {
            sum += nums[i];
        }
        
        int leftSum = 0;
        for (int i = 0; i < nums.length;i++) {
            if (sum - leftSum - nums[i] == leftSum) {
                return i;
            }
            
            leftSum += nums[i];
        }
        
        return -1;
    }
}