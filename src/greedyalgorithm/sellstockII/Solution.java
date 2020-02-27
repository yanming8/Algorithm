package greedyalgorithm.sellstockII;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author Administrator
 *
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public int maxProfit1(int[] prices) {
		int profit = 0;
		int valley = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < valley) {
				valley = prices[i];
			} else if (prices[i] > valley) {
				profit += prices[i] - valley;
				valley = prices[i];
			}
		}
		return profit;
	}
}
