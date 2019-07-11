import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
* https://leetcode.com/problems/two-sum/
*/
public class TwoSum {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		int n = Integer.parseInt(scanner.nextLine());
		int target = Integer.parseInt(scanner.nextLine());

		int[] arr = getArr(n);

		int[] sum = twoSum(arr, target);
		System.out.println(Arrays.toString(sum));
	}

	private static int[] twoSum(int[] nums, int target) {

		// Using hash map for locating a complement
		Map<Integer, Integer> maps = new HashMap<>();

		for (int i = 0;i < nums.length;i++) {
			int sec = target - nums[i];
			if (maps.containsKey(sec)) {
				return new int[] {maps.get(sec), i};
			}

			maps.put(nums[i], i);
		}

		return null;
	}

	private static int[] getArr(int n) {
		String[] aItems = scanner.nextLine().split(" ");

		int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        return a;
	}
}