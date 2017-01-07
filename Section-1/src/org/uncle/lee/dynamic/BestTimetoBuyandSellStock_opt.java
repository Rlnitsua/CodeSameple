package org.uncle.lee.dynamic;

public class BestTimetoBuyandSellStock_opt {
	public int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}
		
		int maxProfit = 0;
		int currentMinPrices = prices[0];
		
		for(int i = 0; i < prices.length; i++){
			if(prices[i] > currentMinPrices){
				maxProfit = Math.max(maxProfit, prices[i] - currentMinPrices);
			} else {
				currentMinPrices = prices[i];
			}
		}
		
		return maxProfit;
	}
}
