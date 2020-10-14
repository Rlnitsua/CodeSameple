package lizbyu.greedy;

import lizbyu.utils.log.LogUtils;

public class BestTimetoBuyandSellStockII {
    private static final String TAG = "BestTimetoBuyandSellStockII";

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {10, 0, 11, 3, 5};
        LogUtils.d(TAG, new BestTimetoBuyandSellStockII().maxProfit(prices));
    }
}
