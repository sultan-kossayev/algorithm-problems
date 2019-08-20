import java.util.*;

// https://leetcode.com/problems/3sum/
public class ThreeSum{

	public static void main(String... args) {
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

		List<List<Integer>> list = threeSum(nums);

		System.out.println(list);
	}

	private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 2;i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int h = nums.length - 1;
                int sum = 0 - nums[i];
                while (l < h) {
                    if (nums[l] + nums[h] == sum) {
                        list.add(Arrays.asList(nums[i], nums[l], nums[h]));
                        while (l < h && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < h && nums[h] == nums[h - 1]) {
                            h--;
                        }
                        l++;
                        h--;
                    } else if (nums[l] + nums[h] < sum) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
        }
        
        return list;
    }
}