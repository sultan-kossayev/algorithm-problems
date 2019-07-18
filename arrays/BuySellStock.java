// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BuySellStock {

	public static void main(String... args) {

		int[] nums = new int[]{7,1,5,3,6,4};
		int profit = maxProfit(nums);

		System.out.println(profit);
	}

	private static int maxProfit(int[] nums) {
		int minPrice = Integer.MAX_VALUE;
		int profit = 0;

		for (int i = 0; i < nums.length;i++) {
			if (nums[i] < minPrice) {
				minPrice = nums[i];
			} else if (nums[i] - minPrice > profit) {
				profit = nums[i] - minPrice;
			}
		}

		return profit;
	}
}