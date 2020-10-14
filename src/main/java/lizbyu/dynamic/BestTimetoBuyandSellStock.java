package lizbyu.dynamic;

import lizbyu.utils.log.LogUtils;

public class BestTimetoBuyandSellStock {
    private static final String TAG = "BestTimetoBuyandSellStock";

    public int maxProfit(int[] prices) {
        int[] profitArray = new int[prices.length];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            profitArray[i] = 0;

            if (prices[i - 1] >= prices[i]) {
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j] &&
                        profitArray[i] < profitArray[j] + prices[i] - prices[j]) {
                    profitArray[i] = profitArray[j] + prices[i] - prices[j];
                }
            }

            if (maxProfit < profitArray[i]) {
                maxProfit = profitArray[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] mon = {7, 1, 5, 3, 6, 0, 4};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new BestTimetoBuyandSellStock().maxProfit(mon));
    }
}
