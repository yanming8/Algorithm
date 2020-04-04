package dynamicprogramming;

public class StockMaxProfit1 {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int min = prices[0];
		for (int price : prices) {
			if (min > price) {
				min = price;
			} else {
				profit = Math.max(profit, price - min);
			}
		}
		return 0;
	}
}
