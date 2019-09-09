package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

    /**
     * The intuition behind the algo:
     * the maximum profit always sits between
     * the low price and highest price that is on the right side from the low price.
     * <p>
     * Time: O(N), N is a number of prices
     * Space: O(1)
     */
    private static int maxProfit(int... prices) {
        int profit = 0;
        int low = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price <= low) {
                low = price;
            } else {
                profit = Math.max(price - low, profit);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int profit = maxProfit(7, 1, 5, 3, 6, 4);

        // 6 - 1 = 5
        Assertions.assertEquals(profit, 5);
    }
}
