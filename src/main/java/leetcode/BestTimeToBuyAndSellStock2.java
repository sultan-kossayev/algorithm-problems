package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStock2 {

    /**
     * We are interested in buying at most lowest point and
     * selling at most highest point.
     * <p>
     * Time: O(N), N is a size of the array
     * Space: O(1)
     */
    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            int sell = prices[i];
            for (int j = i + 1; j < prices.length && prices[j] > sell; j++) {
                sell = prices[j];
                i = j;
            }

            profit += sell - buy;
        }

        return profit;
    }

    public static void main(String... args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        int profit = maxProfit(prices);

        Assertions.assertEquals(profit, 7);
    }
}
