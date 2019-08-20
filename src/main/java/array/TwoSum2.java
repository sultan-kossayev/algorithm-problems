/**
* 
* https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
*/
public class TwoSum2 {

	public static void main(String... args) {
		int[] nums = {-2147483648, -11, -10, -9};
		//int[] nums = {1, 11, 12, 2147483647};

		int[] res = twoSum(nums, -21);

		System.out.println(res[0] + " " + res[1]);
	}

	private static int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length -1; i < j;) {
        	int sum = getSumAndConsiderOverflow(numbers[i], numbers[j]);

            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }

    private static int getSumAndConsiderOverflow(int x, int y) {
    	int sum = 0;
    	if (y > 0 && Integer.MAX_VALUE - y < x) {
    		sum = Integer.MAX_VALUE;
        } else if (y < 0 && Integer.MIN_VALUE - y > x) {
        	sum = Integer.MIN_VALUE;
        } else {
        	sum = x + y;
        }

        return sum;
    }
}