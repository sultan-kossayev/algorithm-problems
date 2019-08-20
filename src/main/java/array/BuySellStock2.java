public class BuySellStock2 {
	
	public static void main(String... args) {
		int[] prices = new int[]{7,1,5,3,6,4};

		int profit = maxProfit2(prices);

		System.out.println(profit);
	}

	// the points of interest are the consecutive valleys and peaks.
	private static int maxProfit(int[] prices) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxProfit = 0;
		while (i < prices.length - 1) {
			while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
				i++;
			}

			valley = prices[i];

			while(i < prices.length - 1 && prices[i] <= prices[i + 1]) {
				i++;
			}

			peak = prices[i];
			maxProfit += (peak - valley);
		}

		return maxProfit;
	}

	// we can simply go on crawling over the slope and keep on adding the profit 
	private static int maxProfit2(int[] prices) {
		int maxProfit = 0;
		for (int i = 1; i < prices.length;i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += (prices[i] - prices[i - 1]);
			}
		}

		return maxProfit;
	}
}