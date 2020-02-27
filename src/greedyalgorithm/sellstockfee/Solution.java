package greedyalgorithm.sellstockfee;

/**
 * 714. 买卖股票的最佳时机含手续费 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee
 * 代表了交易股票的手续费用。
 * 
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 
 * 返回获得利润的最大值。
 * 
 * 示例 1:
 * 
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2 输出: 8 <br>
 * 解释: 能够达到的最大利润: 在此处买入 prices[0] = 1 在此处卖出 prices[3] = 8 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 
 * @author Administrator
 *
 */
public class Solution {
	
	/**
	 * 方法一：根据峰值和谷值进行计算。
	 * 这里的峰值需要减去fee之后，再与谷值进行比较，如果大于谷值，则
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {
		int profit = 0;
		int valley = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < valley) {
				valley = prices[i];
			} else if (prices[i] - fee > valley) {
				profit += prices[i] - valley - fee;
				valley = prices[i] - fee;
			}
		}
		return profit;
	}
}
